/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.flota;

import excepciones.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import persistencia.Serializadora;
import modelo.*;

/**
 *
 * @author DARIO LOPEZ
 */
public class ControladorVistaViaje {

    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;

    public ControladorVistaViaje() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
    }

    public Viaje buscarViajeConElMismoVehiculo(Caseta caseta, Viaje viaje) {
        ArrayList<Caseta> listaCasetasAux = serializadora.leerArrayListCasetas();
        for (Caseta casetaAux : listaCasetasAux) {
            if (casetaAux.getEmpresa().getNit() == caseta.getEmpresa().getNit()) {
                ArrayList<Viaje> listaViajes = casetaAux.getEmpresa().getViajes();
                for (int j = 0; j < listaViajes.size(); j++) {
                    if (listaViajes.get(j) != null) {
                        if (listaViajes.get(j).getVehiculo().getPlaca().equals(viaje.getVehiculo().getPlaca())) {
                            return listaViajes.get(j);
                        }
                    }
                }
            }

        }
        return null;
    }

    public Viaje buscarViajeConElMismoVehiculoYFecha(Caseta caseta, Viaje viaje) {
        Viaje viajeAux = buscarViajeConElMismoVehiculo(caseta, viaje);
        if (viajeAux != null) {
            if (viajeAux.getFechaSalida().equals(viaje.getFechaSalida())
                    || viajeAux.getFechallegada().equals(viaje.getFechallegada())
                    || viajeAux.getFechallegada().equals(viaje.getFechaSalida())
                    || (viajeAux.getFechaSalida().isAfter(viaje.getFechaSalida()) && viajeAux.getFechaSalida().isBefore(viaje.getFechallegada()))
                    || (viajeAux.getFechallegada().isAfter(viaje.getFechaSalida()) && viajeAux.getFechallegada().isBefore(viaje.getFechallegada()))
                    || (viajeAux.getFechaSalida().isBefore(viaje.getFechaSalida()) && viajeAux.getFechallegada().isAfter(viaje.getFechallegada()))
                    || (viaje.getFechaSalida().isBefore(viajeAux.getFechaSalida()) && viaje.getFechallegada().isAfter(viajeAux.getFechallegada()))) {
                return viajeAux;
            }
        }
        return null;
    }

    public void guardarViajeEnLaEmpresa(Caseta caseta, Viaje viaje) throws NoDisponibleVehiculoException, VencidaElSoatException, VencidaLaTecnomecanicaException, FechaInvalidaAntesDeLaLocalException, FechaInvalidaLlegadaAntesDeSalidaException, HoraInvalidaException, HoraPasadaException {
        Viaje viajeAux = buscarViajeConElMismoVehiculoYFecha(caseta, viaje);
        if (viajeAux != null) {
            throw new NoDisponibleVehiculoException();
        }
        if (viaje.getVehiculo().getSoatVencimiento().isBefore(LocalDate.now())) {
            throw new VencidaElSoatException();
        }
        if (viaje.getVehiculo().getTecnomecanicaVencimiento().isBefore(LocalDate.now())) {
            throw new VencidaLaTecnomecanicaException();
        }
        if (viaje.getFechaSalida().isBefore(LocalDate.now())) {
            throw new FechaInvalidaAntesDeLaLocalException();
        }
        if (viaje.getFechallegada().isBefore(viaje.getFechaSalida())) {
            throw new FechaInvalidaLlegadaAntesDeSalidaException();
        }
        if (viaje.getFechaSalida().isEqual(viaje.getFechallegada()) && viaje.getHoraSalida().isAfter(viaje.getHorallegada())) {
            throw new HoraInvalidaException();
        }
        if (viaje.getFechaSalida().isEqual(LocalDate.now())) {
            if (viaje.getHoraSalida().isBefore(LocalTime.now())) {
                throw new HoraPasadaException();
            }
        }

        guardar(caseta, viaje);
    }

    public Vehiculo buscarVehiculo(Caseta caseta, String placa) throws EsteVehiculoNoEstaRegistradoEnLaEmpresa {
        for (Vehiculo vehiculoAux : caseta.getEmpresa().getVehiculos()) {
            if (vehiculoAux.getPlaca().equals(placa)) {
                return vehiculoAux;
            }
        }
        throw new EsteVehiculoNoEstaRegistradoEnLaEmpresa();
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

    public void guardar(Caseta caseta, Viaje viaje) {
        for (Caseta casetaAux : this.listaCasetas) {
            if (caseta.getEmpresa().getNit() == casetaAux.getEmpresa().getNit()) {
                casetaAux.getEmpresa().getViajes().add(viaje);
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
            }
        }
    }

    public Viaje buscarViajeTabla(Caseta caseta, int id) {
        ArrayList<Caseta> listCasetaAux = serializadora.leerArrayListCasetas();
        for (Caseta casetaAux : listCasetaAux) {
            if (casetaAux.getEmpresa().getNit() == caseta.getEmpresa().getNit()) {
                for (Viaje viaje : casetaAux.getEmpresa().getViajes()) {
                    if (viaje.getIdViaje() == id) {
                        return viaje;
                    }

                }
            }
        }
        return null;
    }
}
