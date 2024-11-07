package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable{
    private int idReserva;
    private LocalDate fechaDeCompra;
    private Cliente cliente;
    private Viaje viaje;
    private int puestos;
    private String estado;


    public Reserva() {

    }

    public Reserva(int idReserva, LocalDate fechaDeCompra, Cliente cliente, Viaje viaje, int puestos, String estado) {
        this.idReserva = idReserva;
        this.fechaDeCompra = fechaDeCompra;
        this.cliente = cliente;
        this.viaje = viaje;
        this.puestos = puestos;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDate fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
    public int getPuestos() {
        return puestos;
    }
    public void setPuestos(int puestos) {
        this.puestos = puestos;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}