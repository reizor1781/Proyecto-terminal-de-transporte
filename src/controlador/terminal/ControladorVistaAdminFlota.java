/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.terminal;


import excepciones.NoSePudoRegistrarLaPersonaException;
import excepciones.PersonaYaRegistradaException;
import java.util.ArrayList;
import modelo.AdminFlota;
import modelo.Persona;
import persistencia.Serializadora;

/**
 *
 * @author DARIO LOPEZ
 */
public class ControladorVistaAdminFlota {

    private Serializadora serializadora;
    private ArrayList<Persona> listaPersonas;

    public ControladorVistaAdminFlota() {
        this.serializadora = new Serializadora();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }

    public Persona buscarPersona(Persona persona) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCedula() == persona.getCedula()) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }

    public void guardarAdminFlota(AdminFlota adminFlota) throws PersonaYaRegistradaException, NoSePudoRegistrarLaPersonaException {
    Persona personaAux = buscarPersona(adminFlota);
    if (personaAux == null) {
        boolean agregado = listaPersonas.add(adminFlota);
        serializadora.escribirArrayListPersonas(listaPersonas);
        if (!agregado) {
           
            throw new NoSePudoRegistrarLaPersonaException();
        }
    } else {
        throw new PersonaYaRegistradaException();
    }
}

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

}
