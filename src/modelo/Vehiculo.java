package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Vehiculo implements Serializable {
    private String placa;
    private int cantidadPuestos;
    private String marca;
    private int modelo;
    private String estado;
    private LocalDate soatVencimiento;
    private LocalDate tecnomecanicaVencimiento;
    public Vehiculo() {
    }

    public Vehiculo(String placa, int cantidadPuestos, String marca, int modelo,String estado,LocalDate soatVencimiento, LocalDate tecnomecanicaVencimiento) {
        this.placa = placa;
        this.cantidadPuestos = cantidadPuestos;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.soatVencimiento = soatVencimiento;
        this.tecnomecanicaVencimiento = tecnomecanicaVencimiento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LocalDate getSoatVencimiento() {
        return soatVencimiento;
    }

    public void setSoatVencimiento(LocalDate soatVencimiento) {
        this.soatVencimiento = soatVencimiento;
    }

    public LocalDate getTecnomecanicaVencimiento() {
        return tecnomecanicaVencimiento;
    }

    public void setTecnomecanicaVencimiento(LocalDate tecnomecanicaVencimiento) {
        this.tecnomecanicaVencimiento = tecnomecanicaVencimiento;
    }
}
