package controlador;

import persistencia.*;
import modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Serializadora serializadora = new Serializadora();
        ArrayList<Persona> listaPersonas = serializadora.leerArrayListPersonas();
        ArrayList<Caseta> listaCaseta = serializadora.leerArrayListCasetas();
        
        serializadora.escribirArrayListPersonas(listaPersonas);
        for (Persona persona : listaPersonas) {
            if(persona instanceof Cliente){
                Cliente cliente = (Cliente) persona;
                System.out.println(cliente.getPuntos());
            }
            System.out.println(persona.getNombre());
            if (persona == null) {
                System.out.println("Papito no guarda");
            }
            if (persona != null) {
                System.out.println("Si guarda en teoria " + persona.getCedula() + " " + persona.getContraseña());
            }
        }
        for (Caseta caseta : listaCaseta) {
            for (Vehiculo vehiculo : caseta.getEmpresa().getVehiculos()) {
                if (vehiculo == null) {
                    System.out.println("Papito no guarda");
                }
                if (vehiculo != null) {
                    System.out.println("Si guarda en teoria " + vehiculo.getPlaca() + " " + vehiculo.getMarca());
                }
            }
        }
        for (Caseta caseta : listaCaseta) {
            for (Viaje viaje : caseta.getEmpresa().getViajes()) {
                if (viaje == null) {
                    System.out.println("Papito no guarda");
                }
                if (viaje != null) {
                    System.out.println("Si guarda en teoria " + viaje.getDestino() + " " + viaje.getIdViaje());
                }
            }
        }
        AdminTerminal admin = new AdminTerminal(123, "Carlos", 'M', "3135003380", LocalDate.of(2005, 8, 27), "123", "Armenia", "Union libre");
        listaPersonas.add(admin);
        Viaje viaje = new Viaje(null,null,null,null,null,null,null,null,0);
        System.out.println(viaje.getTiquetes().size());
    }
}
