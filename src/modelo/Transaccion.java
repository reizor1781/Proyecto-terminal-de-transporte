package modelo;

import java.io.*;
import java.time.LocalDateTime;

public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;
    private int idTransaccion;
    private Tiquete tiquete;
    private Cliente cliente;
    private LocalDateTime local;
    private int puntos;
    public Transaccion(){
    }
    public Transaccion( Tiquete tiquete, Cliente cliente, LocalDateTime local, int puntos) {
        this.idTransaccion = contadorId++;
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
    public static void guardarContadorId() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("contadorIdTransaccion.dat"))) {
            out.writeInt(contadorId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarContadorId() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("contadorIdTransaccion.dat"))) {
            contadorId = in.readInt();
        } catch (IOException e) {
            contadorId = 1; 
        }
    }

}
