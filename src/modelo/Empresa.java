package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
    private AdminFlota adminFlota;
    private int nit;
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Viaje> viajes;
    private ArrayList<Devolucion> devoluciones;

    public Empresa() {
    }

    public Empresa(AdminFlota adminFlota, int nit, String nombre) {
        this.adminFlota = adminFlota;
        this.nit = nit;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
        this.viajes = new ArrayList<>();
        this.devoluciones = new ArrayList<>();
    }

    public AdminFlota getAdminFlota() {
        return adminFlota;
    }

    public void setAdminFlota(AdminFlota adminFlota) {
        this.adminFlota = adminFlota;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public ArrayList<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(ArrayList<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }
}
