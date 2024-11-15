/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.cliente;

import excepciones.ElViajeYaNoEstaDisponibleException;
import excepciones.NoAsientosException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Caseta;
import modelo.Persona;
import modelo.Reserva;
import modelo.Viaje;
import persistencia.Serializadora;

/**
 *
 * @author DARIO LOPEZ
 */
public class ControladorVistaGestionReserva {

    private Serializadora serializadora;
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Caseta> listaCasetas;

    public ControladorVistaGestionReserva() {
        serializadora = new Serializadora();
        listaCasetas = serializadora.leerArrayListCasetas();
        listaPersonas = serializadora.leerArrayListPersonas();
    }

    public void guardarReserva(Reserva reserva) throws ElViajeYaNoEstaDisponibleException, NoAsientosException {
        if (reserva.getViaje().getFechaSalida().equals(LocalDate.now())) {
            if (reserva.getViaje().getHoraSalida().isBefore(LocalTime.now())) {
                throw new ElViajeYaNoEstaDisponibleException();
            }
        }

        if (reserva.getViaje().getFechaSalida().isBefore(LocalDate.now())) {
            throw new ElViajeYaNoEstaDisponibleException();
        }
        int total = reserva.getViaje().getTiquetes().size() + (int) reserva.getViaje().getReservas().stream().filter(r -> r.getEstado().equals("activa")).count() + reserva.getPuestos();
        if (total > reserva.getViaje().getVehiculo().getCantidadPuestos()) {
            throw new NoAsientosException();
        }
        reserva.getViaje().getReservas().add(reserva);
        serializadora.escribirArrayListCasetas(listaCasetas);
        modelo.Reserva.guardarContadorId();
    }

    public Viaje buscarViajeTabla(int id) {
        ArrayList<Caseta> listCasetaAux = serializadora.leerArrayListCasetas();
        for (Caseta casetaAux : listCasetaAux) {
            for (Viaje viaje : casetaAux.getEmpresa().getViajes()) {
                if (viaje.getIdViaje() == id) {
                    return viaje;
                }
            }
        }
        return null;
    }

    public ArrayList<Caseta> getListaCasetas() {
        return listaCasetas;
    }
}
