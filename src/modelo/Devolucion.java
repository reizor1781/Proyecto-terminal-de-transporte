package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Devolucion implements Serializable {
    private int idDevolucion;
    private Tiquete tiquete;
    private Cliente cliente;
    private LocalDateTime fechaCreacion;
    private String pago;
    private int cantidad;
    public Devolucion() {
    }
    public Devolucion(int idDevolucion, Tiquete tiquete, Cliente cliente, LocalDateTime fechaCreacion, String pago, int cantidad) {
        this.idDevolucion = idDevolucion;
        this.tiquete = tiquete;
        this.cliente = cliente;
        this.fechaCreacion = fechaCreacion;
        this.pago = pago;
        this.cantidad = cantidad;
    }

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
