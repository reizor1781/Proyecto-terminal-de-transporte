package controlador;

import excepciones.*;
import java.util.ArrayList;

import modelo.*;
import persistencia.Serializadora;

public class ControladorVistaIniciarSesion {

    ArrayList<Caseta> listaCasetas;
    ArrayList<Persona> listaPersonas;
    Serializadora serializadora;

    public ControladorVistaIniciarSesion() {
        this.serializadora = new Serializadora();
        this.listaPersonas = serializadora.leerArrayListPersonas();
        this.listaCasetas = serializadora.leerArrayListCasetas();

    }

    public Persona buscarInicioSesion(int cedula, String contraseña) throws UsuarioNoEncontradoONoRegistradoException {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCedula() == cedula && listaPersonas.get(i).getContraseña().equals(contraseña)) {
                return listaPersonas.get(i);
            }
        }
        throw new UsuarioNoEncontradoONoRegistradoException();
    }

    public Caseta buscarEmpresaDeAdminFlota(AdminFlota admin) throws AdminNoAsociadoAEmpresaException {
        for (Caseta caseta : listaCasetas) {
            if (caseta.getEmpresa().getAdminFlota().getCedula()== admin.getCedula()) {
                return caseta;
            }
        }
        throw new AdminNoAsociadoAEmpresaException();
    }

}
