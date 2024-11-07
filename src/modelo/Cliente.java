
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
    private String ciudad;
    private int puntos;
    private ArrayList<Devolucion> devoluciones;
    private ArrayList<Transaccion> redencionTransaccions;
    private ArrayList<Reserva> reservas;
    public Cliente() {
    }

    public Cliente(int cedula, String nombre, char genero, String celular, LocalDate fechaNacimiento, String contraseña) {
        super(cedula, nombre, genero, celular, fechaNacimiento, contraseña);
        this.ciudad = ciudad;
        this.puntos = 0;
        this.devoluciones = new ArrayList<>();
        this.redencionTransaccions = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(ArrayList<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public ArrayList<Transaccion> getRedencionPuntos() {
        return redencionTransaccions;
    }

    public void setRedencionPuntos(ArrayList<Transaccion> redencionTransaccions) {
        this.redencionTransaccions = redencionTransaccions;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
