package modelo;

import java.io.*;


public class Caseta implements Serializable {
    private static final long serialVersionUID = 1L;
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
    public static void guardarContadorId() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("contadorIdCaseta.dat"))) {
            out.writeInt(contadorId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarContadorId() {
        try (DataInputStream in = new DataInputStream(new FileInputStream("contadorIdCaseta.dat"))) {
            contadorId = in.readInt();
        } catch (IOException e) {
            contadorId = 1; 
        }
    }



   
}
