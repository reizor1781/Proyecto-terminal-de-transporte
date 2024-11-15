package controlador.flota;

import excepciones.*;
import modelo.*;
import persistencia.Serializadora;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class ControladorVistaTiquete {

    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;

    public ControladorVistaTiquete() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }

    public void generarTiquete(int cant, Caseta caseta, Viaje viaje,Cliente cliente,String pago) throws NoPuntosException, NoExisteElViajeException, ElViajeYaNoEstaDisponibleException, NoAsientosException, NoSeVendioElTiqueteException {
        if (viaje.getFechaSalida().isBefore(LocalDate.now())) {
            throw new ElViajeYaNoEstaDisponibleException();
        }
        int total = viaje.getTiquetes().size() + (int) viaje.getReservas().stream().filter(r -> r.getEstado().equals("activa")).count() + cant;
        if (total > viaje.getVehiculo().getCantidadPuestos()) {
            throw new NoAsientosException();
        }
        switch (pago) {
            case "Puntos":
                if (cliente.getPuntos()<90*cant){
                    throw new NoPuntosException(cliente.getPuntos(), 90*cant);
                }
                for (int i = 0; i < cant; i++) {
                    if (cliente.getPuntos() < 90) {
                        throw new NoPuntosException(cliente.getPuntos(), 90);
                    }
                    modelo.Tiquete.cargarContadorId();
                    Tiquete tiquete = new Tiquete(LocalDate.now(), cliente, viaje, "Combianda");
                    int valorPuntos = tiquete.getCliente().getPuntos();
                    int puntosUtilizados = (valorPuntos / 90) * 90;
                    int descuentoTotal = (puntosUtilizados / 90) * 30000;
                    int valorFaltanteDelDinero = viaje.getValor() - descuentoTotal;
                    if (valorFaltanteDelDinero > 0  ) {
                        int respuesta = JOptionPane.showConfirmDialog(
                                null,
                                "No tiene la cantidad necesaria de puntos, ¿desea pagar parte por puntos y Dinero?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);
                        if (respuesta == JOptionPane.YES_OPTION) {
                            tiquete.setMetodoPago("Combinada");
                            if (cliente.getPuntos() < 90) {
                                throw new NoPuntosException(cliente.getPuntos(), 90);
                            }
                            int respuesta2 = JOptionPane.showConfirmDialog(
                                    null,
                                    "Cantidad a puntos utlizar es: " + puntosUtilizados + " Valor restante a pagar en dinero " + valorFaltanteDelDinero + " Cantidad a pagar con puntos :" + descuentoTotal + " Desea continuar?",
                                    "Confirmación",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.WARNING_MESSAGE);
                            if (respuesta2 == JOptionPane.YES_OPTION) {
                                generarTransferenciaCombinado(viaje, tiquete);
                                guardar(caseta, viaje, tiquete);
                            }
                            throw new NoSeVendioElTiqueteException();
                        }
                        throw new NoSeVendioElTiqueteException();

                    }
                    else {
                        generarTransferenciaPuntos(viaje, tiquete);
                        guardar(caseta, viaje, tiquete);
                    }
                }
                break;
            case "Dinero":
                for (int i = 0; i < cant; i++) {
                    modelo.Tiquete.cargarContadorId();
                    Tiquete tiquete = new Tiquete(LocalDate.now(),cliente,viaje,pago);
                    guardar(caseta,viaje,tiquete);
                    incrementardorDePuntos(tiquete);
                }
                break;
        }
    }
    public void guardar(Caseta caseta, Viaje viaje,Tiquete tiquete) {
        for (Caseta casetaAux : this.listaCasetas) {
            if (caseta.getEmpresa().getNit() == casetaAux.getEmpresa().getNit()) {
                for (Viaje viajeAux : casetaAux.getEmpresa().getViajes()) {
                    if (viajeAux.getIdViaje() == viaje.getIdViaje()) {
                        modelo.Tiquete.guardarContadorId();
                        viajeAux.getTiquetes().add(tiquete);
                        viaje.getTiquetes().add(tiquete);
                        this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                        return ;
                    }
                }
            }
        }
    }

    public void incrementardorDePuntos(Tiquete tiquete) {
        int valorViaje = tiquete.getViaje().getValor();
        int puntosAcumulado = (valorViaje / 10000) * 3;
        int valorPuntos = tiquete.getCliente().getPuntos();
        tiquete.getCliente().setPuntos(valorPuntos + puntosAcumulado);
        serializadora.escribirArrayListPersonas(this.listaPersonas);
    }
    public void incrementardorDePuntosCombianada(Tiquete tiquete, int valor) {
        int puntosAcumulado = (valor / 10000) * 3;
        int valorPuntos = tiquete.getCliente().getPuntos();
        tiquete.getCliente().setPuntos(valorPuntos + puntosAcumulado);
        serializadora.escribirArrayListPersonas(this.listaPersonas);
    }
    public void generarTransferenciaCombinado(Viaje viaje, Tiquete tiquete) throws NoPuntosException {
        int valorPuntos = tiquete.getCliente().getPuntos();
        int puntosUtilizados = (valorPuntos / 90) * 90;
        int descuentoTotal = (puntosUtilizados / 90) * 30000;
        if (puntosUtilizados > 0) {
            modelo.Transaccion.cargarContadorId();
            Transaccion transaccion = new Transaccion(tiquete, tiquete.getCliente(), LocalDateTime.now(), puntosUtilizados);
            modelo.Transaccion.guardarContadorId();
            tiquete.getCliente().setPuntos(valorPuntos - puntosUtilizados);
            viaje.getTiquetes().add(tiquete);
            tiquete.getCliente().getRedencionPuntos().add(transaccion);
            incrementardorDePuntosCombianada(tiquete,tiquete.getViaje().getValor()-descuentoTotal);
            this.serializadora.escribirArrayListPersonas(this.listaPersonas);
            return;
        }
        throw new NoPuntosException(valorPuntos, puntosUtilizados);
    }

    public void generarTransferenciaPuntos(Viaje viaje, Tiquete tiquete) throws NoPuntosException {
        int valorPuntos = tiquete.getCliente().getPuntos();
        if (valorPuntos >= 90) {
            modelo.Transaccion.cargarContadorId();
            Transaccion transaccion = new Transaccion(tiquete, tiquete.getCliente(), LocalDateTime.now(), 90);
            modelo.Transaccion.guardarContadorId();
            tiquete.getCliente().setPuntos(valorPuntos - 90);
            viaje.getTiquetes().add(tiquete);
            tiquete.getCliente().getRedencionPuntos().add(transaccion);
            this.serializadora.escribirArrayListPersonas(this.listaPersonas);
            return;
        }
        throw new NoPuntosException(valorPuntos, 90);
    }



    public Cliente buscarCliente(int cedula) throws UsuarioNoEncontradoONoRegistradoException {
        for (Persona persona : listaPersonas) {
            if (persona.getCedula() == cedula && persona instanceof Cliente) {
                return (Cliente) persona;
            }
        }
        throw new UsuarioNoEncontradoONoRegistradoException();
    }
    public Viaje buscarViajeTabla(Caseta caseta, int id) {
        ArrayList<Caseta> listCasetaAux = serializadora.leerArrayListCasetas();
        for (Caseta casetaAux : listCasetaAux) {
            if (casetaAux.getEmpresa().getNit() == caseta.getEmpresa().getNit()) {
                for (Viaje viaje : caseta.getEmpresa().getViajes()) {
                    if (viaje.getIdViaje() == id) {
                        return viaje;
                    }

                }
            }
        }
        return null;
    }
    public ArrayList<Viaje> getListaViajesDeLaCaseta(Caseta caseta) {
        ArrayList<Caseta> listaCasetasAux = serializadora.leerArrayListCasetas();
        for (Caseta casetaAux : listaCasetasAux) {
            if (casetaAux.getEmpresa().getNit() == caseta.getEmpresa().getNit()) {
                return caseta.getEmpresa().getViajes();
            }
        }
        return null;
    }

}