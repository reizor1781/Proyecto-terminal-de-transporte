package controlador.flota;

import excepciones.*;
import modelo.*;
import persistencia.Serializadora;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class ControladorVistaAdminFlota {
    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;
    public ControladorVistaAdminFlota() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }
    public Empresa buscarEmpresa (Persona persona) {
        for (Caseta caseta : this.listaCasetas) {
            if (caseta.getEmpresa().getAdminFlota().equals(persona)) {
                return caseta.getEmpresa();
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculoEnCadaEmpresa(Vehiculo vehiculo) {
        for (int i = 0; i < listaCasetas.size(); i++) {
            ArrayList<Vehiculo> vehiculos = listaCasetas.get(i).getEmpresa().getVehiculos();
            for (int j = 0; j < vehiculos.size(); j++) {
                if (vehiculo.getPlaca().equals(vehiculos.get(j).getPlaca())) {
                    return vehiculos.get(j);
                }
            }
        }
        return null;
    }

    public void guardarVehiculoEnLaEmpresa(Empresa empresa, Vehiculo vehiculo) throws PlacaRepetidaException {
        Vehiculo aux = buscarVehiculoEnCadaEmpresa(vehiculo);
        if (aux != null) {
            throw new PlacaRepetidaException();
        }
        ArrayList<Vehiculo> listaVehiculos = empresa.getVehiculos();
        listaVehiculos.add(vehiculo);
        this.serializadora.escribirArrayListCasetas(this.listaCasetas);
    }
    public Viaje buscarViajeConElMismoVehiculo(Viaje viaje) {
        for (int i = 0; i < listaCasetas.size(); i++) {
            ArrayList<Viaje> listaviajes = listaCasetas.get(i).getEmpresa().getViajes();
            for (int j = 0; j < listaviajes.size(); j++) {
                if (listaviajes.get(i).getVehiculo().equals(viaje)) {
                    return listaviajes.get(j);
                }
            }
        }
        return null;
    }

    public Viaje buscarViajeConElMismoVehiculoYFecha(Viaje viaje) {
        Viaje ViajeAux = buscarViajeConElMismoVehiculo(viaje);
        if (ViajeAux != null) {
            if (ViajeAux.getFechaSalida().equals(viaje.getFechaSalida()) || ViajeAux.getFechallegada().equals(viaje.getFechallegada()) || ViajeAux.getFechallegada().equals(viaje.getFechaSalida())) {
                return viaje;
            }
        }
        return null;
    }

    public void guardarViajeEnLaEmpresa(Empresa empresa, Viaje viaje) throws NoDisponibleVehiculoException {
        Viaje viajeAux = buscarViajeConElMismoVehiculoYFecha(viaje);
        if (viajeAux != null) {
            throw new NoDisponibleVehiculoException();
        }
        empresa.getViajes().add(viaje);
        this.serializadora.escribirArrayListCasetas(this.listaCasetas);
    }

    public void generarTiquete(int cant ,Empresa empresa,Viaje viaje, Tiquete tiquete) throws NoPuntosException, NoExisteElViajeException, ElViajeYaNoEstaDisponibleException,NoAsientosException {
        for (int i = 0;i < empresa.getViajes().size();i++){
            if (viaje != empresa.getViajes().get(i)) {
                throw new NoExisteElViajeException();
            }
        }
        if (Objects.equals(viaje.getFechallegada(), LocalDate.now())){
            throw new ElViajeYaNoEstaDisponibleException();
        }
        if (viaje.getTiquetes().size()+cant > viaje.getVehiculo().getCantidadPuestos()){
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

    public ArrayList<Caseta> getListaCasetas() {
        return listaCasetas;
    }
    
    
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
