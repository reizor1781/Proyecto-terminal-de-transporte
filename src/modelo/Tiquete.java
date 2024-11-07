package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Tiquete implements Serializable {
    private int idTiquete;
    private LocalDateTime fechaDeCreacion;
    private Cliente cliente;
    private Viaje viaje;
    private String metodoPago;

    public Tiquete() {
    }

    public Tiquete(int idTiquete, LocalDateTime fechaDeCreacion, Cliente cliente,Viaje viaje ,String metodoPago) {
        this.idTiquete = idTiquete;
        this.fechaDeCreacion = fechaDeCreacion;
        this.cliente = cliente;
        this.viaje = viaje;
        this.metodoPago=metodoPago;
    }

    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
