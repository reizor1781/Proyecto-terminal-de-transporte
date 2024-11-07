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
    public ControladorVistaTiquete(){
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }
    public void generarTiquete(int cant ,Empresa empresa,Viaje viaje, Tiquete tiquete) throws NoPuntosException, NoExisteElViajeException, ElViajeYaNoEstaDisponibleException, NoAsientosException {
        for (int i = 0;i < empresa.getViajes().size();i++){
            if (viaje != empresa.getViajes().get(i)) {
                throw new NoExisteElViajeException();
            }
        }
        if (viaje.getFechaSalida().isAfter(LocalDate.now())){
            throw new ElViajeYaNoEstaDisponibleException();
        }
        int total = viaje.getTiquetes().size() + (int) viaje.getReservas().stream().filter(r -> r.getEstado().equals("activa")).count()+ cant;
        if (total > viaje.getVehiculo().getCantidadPuestos()){
            throw new NoAsientosException();
        }
        switch (tiquete.getMetodoPago()) {
            case "Puntos":
                for(int i = 0; i< cant; i++) {
                    viaje.getTiquetes().add(tiquete);
                    generarTransferencia(empresa, viaje, tiquete);
                }
                break;
            case "Dinero":
                incrementardorDePuntos(tiquete);
                for(int i = 0; i< cant; i++){
                    viaje.getTiquetes().add(tiquete);
                }
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                break;
        }
    }
    public void incrementardorDePuntos(Tiquete tiquete) {
        int valorViaje = tiquete.getViaje().getValor();
        int puntosAcumulado = (valorViaje / 10000) * 3;
        int valorPuntos = tiquete.getCliente().getPuntos();
        tiquete.getCliente().setPuntos(valorPuntos + puntosAcumulado);
    }

    public void generarTransferencia(Empresa empresa, Viaje viaje, Tiquete tiquete) throws NoPuntosException {
        int valorPuntos = tiquete.getCliente().getPuntos();
        if (valorPuntos >= 90) {
            Transaccion transaccion = new Transaccion(0, tiquete, tiquete.getCliente(), LocalDateTime.now(), 90);
            tiquete.getCliente().setPuntos(valorPuntos - 90);
            viaje.getTiquetes().add(tiquete);
            tiquete.getCliente().getRedencionPuntos().add(transaccion);
            this.serializadora.escribirArrayListPersonas(this.listaPersonas);
        }
        throw new NoPuntosException(valorPuntos, 90);
    }
    public void generarDevolucion(Empresa empresa,Tiquete tiquete){
        String pago = tiquete.getMetodoPago();
        switch (pago){
            case "Puntos":
                Devolucion devolucionPuntos = new Devolucion(0,tiquete,tiquete.getCliente(),LocalDateTime.now(),tiquete.getMetodoPago(),90);
                empresa.getDevoluciones().add(devolucionPuntos);
                int puntos = tiquete.getCliente().getPuntos();
                tiquete.getCliente().setPuntos(puntos - 90);
                tiquete.getCliente().getDevoluciones().add(devolucionPuntos);
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                this.serializadora.escribirArrayListPersonas(this.listaPersonas);
                break;
            case "Dinero":
                Devolucion devolucionDinero = new Devolucion(0,tiquete,tiquete.getCliente(),LocalDateTime.now(),tiquete.getMetodoPago(),tiquete.getViaje().getValor());
                empresa.getDevoluciones().add(devolucionDinero);
                int valor = desIncrementardorDePuntos(tiquete);
                tiquete.getViaje().getTiquetes().remove(tiquete);
                tiquete.getCliente().getDevoluciones().add(devolucionDinero);
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                this.serializadora.escribirArrayListPersonas(this.listaPersonas);
                break;
        }
    }
    public int desIncrementardorDePuntos(Tiquete tiquete) {
        int valorViaje = tiquete.getViaje().getValor();
        int puntosAcumulado = (valorViaje / 10000) * 3;
        int valorPuntos = tiquete.getCliente().getPuntos();
        tiquete.getCliente().setPuntos(valorPuntos - puntosAcumulado);
        return puntosAcumulado;
    }
    public Cliente buscarCliente(int cedula){
        for (Persona persona : listaPersonas){
            if (persona.getCedula() == cedula){}
        }
    }
}
