
package modelo;

import persistencia.Serializadora;

import java.io.Serializable;
import java.time.LocalDate;

public class AdminFlota extends Persona implements Serializable {
    private int añosExperiencia;
    private int sueldo;
    private Direccion direccion;
    private String estadoCivil;
    public AdminFlota() {
    }

    public AdminFlota(int cedula, String nombre, char genero, String celular, LocalDate fechaNacimiento, String contraseña, int añosExperiencia, int sueldo, Direccion direccion, String estadoCivil) {
        super(cedula, nombre, genero, celular, fechaNacimiento, contraseña);
        this.añosExperiencia = añosExperiencia;
        this.sueldo = sueldo;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
