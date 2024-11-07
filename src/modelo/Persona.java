
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
    protected int cedula;
    protected String nombre;
    protected char genero;
    protected String celular;
    protected LocalDate fechaNacimiento;
    protected String contraseña;

    public Persona() {
    }

    public Persona(int cedula, String nombre, char genero, String celular, LocalDate fechaNacimiento,String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
