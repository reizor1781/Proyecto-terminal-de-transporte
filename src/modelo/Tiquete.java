package modelo;

import java.io.*;
import java.time.LocalDate;

public class Tiquete implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;
    private int idTiquete;
    private LocalDate fechaDeCreacion;
    private Cliente cliente;
    private Viaje viaje;
    private String metodoPago;

    public Tiquete() {
    }

    public Tiquete(LocalDate fechaDeCreacion, Cliente cliente,Viaje viaje ,String metodoPago) {
        this.idTiquete = contadorId++;
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

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
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
    public static void guardarContadorId() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("contadorIdTiquete.dat"))) {
            out.writeInt(contadorId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarContadorId() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("contadorIdTiquete.dat"))) {
            contadorId = in.readInt();
        } catch (IOException e) {
            contadorId = 1; 
        }
    }
}
