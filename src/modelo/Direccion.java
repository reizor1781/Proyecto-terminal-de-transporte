/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author DARIO LOPEZ
 */
public class Direccion implements Serializable {
    private String Carrera;
    private String numeral;
    private String numerla2;
    private String barrio;
    private String complento;

    public Direccion(String Carrera, String numeral, String numerla2, String barrio, String complento) {
        this.Carrera = Carrera;
        this.numeral = numeral;
        this.numerla2 = numerla2;
        this.barrio = barrio;
        this.complento = complento;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public String getNumerla2() {
        return numerla2;
    }

    public void setNumerla2(String numerla2) {
        this.numerla2 = numerla2;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getComplento() {
        return complento;
    }

    public void setComplento(String complento) {
        this.complento = complento;
    }
    
}
