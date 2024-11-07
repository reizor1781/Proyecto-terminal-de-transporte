package controlador;


import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.ElViajeYaNoEstaDisponibleException;
import persistencia.Serializadora;
import modelo.*;

public class ControladorVistaCliente {
    private Serializadora serializadora;
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Caseta> listaCasetas;

    public ControladorVistaCliente() {
        serializadora = new Serializadora();
        listaCasetas = serializadora.leerArrayListCasetas();
        listaPersonas = serializadora.leerArrayListPersonas();
    }
    public void reservarReserva (Reserva reserva) throws ElViajeYaNoEstaDisponibleException {
        if (reserva.getViaje().getFechallegada().equals(LocalDate.now())) {
            throw new ElViajeYaNoEstaDisponibleException();
        }
        reserva.getViaje().getReservas().add(reserva);
    }
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
    public ArrayList<Caseta> getListaEmpresas() {
        return listaCasetas;
    }


}
