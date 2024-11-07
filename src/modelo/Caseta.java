package modelo;

import java.io.Serializable;

public class Caseta implements Serializable {
    private static int contadorId = 1;
    private int idCaseta;
    private int canonArrendamiento;
    private int cantidadPlazas;
    private Empresa empresa;
    public Caseta() {
    }
    public Caseta( int canonArrendamiento, int cantidadPlazas, Empresa empresa)  {
        this.idCaseta = contadorId++;
        this.canonArrendamiento = canonArrendamiento;
        this.cantidadPlazas = cantidadPlazas;
        this.empresa = empresa;
    }

    public int getIdCaseta() {
        return idCaseta;
    }

    public void setIdCaseta(int idCaseta) {
        this.idCaseta = idCaseta;
    }

    public int getCanonArrendamiento() {
        return canonArrendamiento;
    }

    public void setCanonArrendamiento(int canonArrendamiento) {
        this.canonArrendamiento = canonArrendamiento;
    }

    public int getCantidadPlazas() {
        return cantidadPlazas;
    }

    public void setCantidadPlazas(int cantidadPlazas) {
        this.cantidadPlazas = cantidadPlazas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
