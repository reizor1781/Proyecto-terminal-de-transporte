package controlador;

import excepciones.ClienteRepetidoException;
import modelo.Cliente;
import modelo.Persona;
import persistencia.Serializadora;

import java.util.ArrayList;

public class ControladorVistaRegistrarCliente {
    private ArrayList<Persona> listaPersonas;
    private Serializadora serializadora;
    public ControladorVistaRegistrarCliente() {
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
    public void guardarCliente(Cliente cliente) throws ClienteRepetidoException {
        Persona personaAux = buscarPersona(cliente);
        if (personaAux != null) {
            throw new ClienteRepetidoException();
        }
        listaPersonas.add(cliente);
        serializadora.escribirArrayListPersonas(listaPersonas);
    }

}
