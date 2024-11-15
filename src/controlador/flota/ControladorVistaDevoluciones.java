/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.flota;

import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.Caseta;
import modelo.Devolucion;
import modelo.Empresa;
import modelo.Persona;
import modelo.Tiquete;
import persistencia.Serializadora;

/**
 *
 * @author CARLOS
 */
public class ControladorVistaDevoluciones {

    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;

    public ControladorVistaDevoluciones() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }

    public void generarDevolucion(Empresa empresa, Tiquete tiquete) {
        String pago = tiquete.getMetodoPago();
        switch (pago) {
            case "Puntos":
                Devolucion devolucionPuntos = new Devolucion(tiquete, tiquete.getCliente(), LocalDateTime.now(), tiquete.getMetodoPago(), 90);
                empresa.getDevoluciones().add(devolucionPuntos);
                int puntos = tiquete.getCliente().getPuntos();
                tiquete.getCliente().setPuntos(puntos - 90);
                tiquete.getCliente().getDevoluciones().add(devolucionPuntos);
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                this.serializadora.escribirArrayListPersonas(this.listaPersonas);
                break;
            case "Dinero":
                Devolucion devolucionDinero = new Devolucion(tiquete, tiquete.getCliente(), LocalDateTime.now(), tiquete.getMetodoPago(), tiquete.getViaje().getValor());
                empresa.getDevoluciones().add(devolucionDinero);
                int valor = desIncrementardorDePuntos(tiquete);
                tiquete.getViaje().getTiquetes().remove(tiquete);
                tiquete.getCliente().getDevoluciones().add(devolucionDinero);
                this.serializadora.escribirArrayListCasetas(this.listaCasetas);
                this.serializadora.escribirArrayListPersonas(this.listaPersonas);
                break;
        }
    }

    public int desIncrementardorDePuntos(Tiquete tiquete) {
        int valorViaje = tiquete.getViaje().getValor();
        int puntosAcumulado = (valorViaje / 10000) * 3;
        int valorPuntos = tiquete.getCliente().getPuntos();
        tiquete.getCliente().setPuntos(valorPuntos - puntosAcumulado);
        return puntosAcumulado;
    }
}
