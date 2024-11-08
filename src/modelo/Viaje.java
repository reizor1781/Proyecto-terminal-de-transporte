package modelo;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;
    private int idViaje;
    private String origen;
    private String destino;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private LocalDate fechallegada;
    private LocalTime horallegada;
    private LocalDate fechaCreacion;
    private Vehiculo vehiculo;
    private int valor;
    private ArrayList<Tiquete> tiquetes;
    private ArrayList<Reserva> reservas;

    public Viaje() {

    }

    public Viaje(String origen, String destino, LocalDate fechaSalida,LocalTime horaSalida, LocalDate fechallegada,LocalTime horallegada, LocalDate fechaCreacion, Vehiculo vehiculo, int valor) {
        this.idViaje = contadorId++;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.fechallegada = fechallegada;
        this.horallegada = horallegada;
        this.fechaCreacion = fechaCreacion;
        this.vehiculo = vehiculo;
        this.valor = valor;
        this.tiquetes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDate getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(LocalDate fechallegada) {
        this.fechallegada = fechallegada;
    }

    public LocalTime getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(LocalTime horallegada) {
        this.horallegada = horallegada;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    public static void guardarContadorId() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("contadorIdViaje.dat"))) {
            out.writeInt(contadorId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarContadorId() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("contadorIdViaje.dat"))) {
            contadorId = in.readInt();
        } catch (IOException e) {
            contadorId = 1; 
        }
    }
}
