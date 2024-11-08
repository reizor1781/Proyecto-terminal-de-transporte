package modelo;

import java.io.*;
import java.time.LocalDateTime;

public class Devolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;
    private int idDevolucion;
    private Tiquete tiquete;
    private Cliente cliente;
    private LocalDateTime fechaCreacion;
    private String pago;
    private int cantidad;
    public Devolucion() {
    }
    public Devolucion(Tiquete tiquete, Cliente cliente, LocalDateTime fechaCreacion, String pago, int cantidad) {
        this.idDevolucion = contadorId++;
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
    public static void guardarContadorId() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("contadorIdDevolucion.dat"))) {
            out.writeInt(contadorId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarContadorId() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("contadorIdDevolucion.dat"))) {
            contadorId = in.readInt();
        } catch (IOException e) {
            contadorId = 1; 
        }
    }
}
