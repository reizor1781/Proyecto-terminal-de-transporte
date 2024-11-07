package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaccion implements Serializable {
    private int idTransaccion;
    private Tiquete tiquete;
    private Cliente cliente;
    private LocalDateTime local;
    private int puntos;
    public Transaccion(){
    }
    public Transaccion(int idTransaccion, Tiquete tiquete, Cliente cliente, LocalDateTime local, int puntos) {
        this.idTransaccion = idTransaccion;
        this.tiquete = tiquete;
        this.cliente = cliente;
        this.local = local;
        this.puntos = puntos;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
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

    public LocalDateTime getLocal() {
        return local;
    }

    public void setLocal(LocalDateTime local) {
        this.local = local;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
