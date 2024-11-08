/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.flota;

import excepciones.*;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.*;
import persistencia.Serializadora;

/**
 *
 * @author DARIO LOPEZ
 */
public class ControladorVistaVehiculo {

    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;

    public ControladorVistaVehiculo() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
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

    public void guardarVehiculoEnLaEmpresa(Caseta caseta, Vehiculo vehiculo) throws PlacaRepetidaException, VencidaLaTecnomecanicaException, VencidaElSoatException {
        Vehiculo aux = buscarVehiculoEnCadaEmpresa(vehiculo);
        if (aux != null) {
            throw new PlacaRepetidaException();
        }
        if (vehiculo.getSoatVencimiento().isBefore(LocalDate.now())) {
            throw new VencidaElSoatException();
        }
        if (vehiculo.getTecnomecanicaVencimiento().isBefore(LocalDate.now())) {
            throw new VencidaLaTecnomecanicaException();
        }
        guardar(caseta, vehiculo);

    }

    public ArrayList<Vehiculo> getListaVehiculosDeLaCaseta(Caseta caseta) {
        ArrayList<Caseta> listaCasetasAux = serializadora.leerArrayListCasetas();
        for (Caseta casetaAux : listaCasetasAux) {
            if (casetaAux.getEmpresa().getNit() == caseta.getEmpresa().getNit()) {
                return casetaAux.getEmpresa().getVehiculos();
            }
        }
        return null;
    }

    public void guardar(Caseta caseta, Vehiculo vehiculo) {
        for (Caseta casetaAux : this.listaCasetas) {
            if (caseta.getEmpresa().getNit() == casetaAux.getEmpresa().getNit()) {
                casetaAux.getEmpresa().getVehiculos().add(vehiculo);
                caseta.getEmpresa().getVehiculos().add(vehiculo);
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
            }
        }
    }

}
