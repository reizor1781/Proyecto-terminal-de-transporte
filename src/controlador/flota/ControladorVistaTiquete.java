package controlador.flota;

import excepciones.*;
import modelo.*;
import persistencia.Serializadora;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class ControladorVistaTiquete {

    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;

    public ControladorVistaTiquete() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }

    public void generarTiquete(int cant, Caseta caseta, Viaje viaje, Tiquete tiquete) throws NoPuntosException, NoExisteElViajeException, ElViajeYaNoEstaDisponibleException, NoAsientosException {

        if (viaje.getFechaSalida().isBefore(LocalDate.now())) {
            throw new ElViajeYaNoEstaDisponibleException();
        }
        int total = viaje.getTiquetes().size() + (int) viaje.getReservas().stream().filter(r -> r.getEstado().equals("activa")).count() + cant;
        if (total > viaje.getVehiculo().getCantidadPuestos()) {
            throw new NoAsientosException();
        }
        switch (tiquete.getMetodoPago()) {
            case "Puntos":
                for (int i = 0; i < cant; i++) {
                    guardar(caseta,viaje,tiquete);
                    generarTransferencia(viaje, tiquete);
                }
                break;
            case "Dinero":
                incrementardorDePuntos(tiquete);
                for (int i = 0; i < cant; i++) {
                    guardar(caseta,viaje,tiquete);
                }
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                break;
        }
    }
    public void guardar(Caseta caseta, Viaje viaje, Tiquete tiquete) {
        for (Caseta casetaAux : this.listaCasetas) {
            if (caseta.getEmpresa().getNit() == casetaAux.getEmpresa().getNit()) {
                for (Viaje viajeAux : casetaAux.getEmpresa().getViajes()) {
                    if (viajeAux.getIdViaje() == viaje.getIdViaje()) {
                        viajeAux.getTiquetes().add(tiquete);
                        viaje.getTiquetes().add(tiquete);
                        this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                        return;
                    }
                }
            }
        }
        System.out.println("No se encontró la caseta o el viaje correspondiente.");
    }

    public void incrementardorDePuntos(Tiquete tiquete) {
        int valorViaje = tiquete.getViaje().getValor();
        int puntosAcumulado = (valorViaje / 10000) * 3;
        int valorPuntos = tiquete.getCliente().getPuntos();
        tiquete.getCliente().setPuntos(valorPuntos + puntosAcumulado);
        serializadora.escribirArrayListPersonas(this.listaPersonas);
    }
    public void generarTransferencia(Viaje viaje, Tiquete tiquete) throws NoPuntosException {
        int valorPuntos = tiquete.getCliente().getPuntos();
        if (valorPuntos >= 90) {
            Transaccion transaccion = new Transaccion( tiquete, tiquete.getCliente(), LocalDateTime.now(), 90);
            tiquete.getCliente().setPuntos(valorPuntos - 90);
            viaje.getTiquetes().add(tiquete);
            tiquete.getCliente().getRedencionPuntos().add(transaccion);
            this.serializadora.escribirArrayListPersonas(this.listaPersonas);
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