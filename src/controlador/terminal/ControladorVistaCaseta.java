/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.terminal;

import excepciones.*;
import modelo.*;
import persistencia.Serializadora;
import java.util.ArrayList;
/**
 *
 * @author DARIO LOPEZ
 */
public class ControladorVistaCaseta {
    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;
    public ControladorVistaCaseta (){
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }
    public AdminFlota buscarAdminflotaRegistrado(int cedula) {
    for (Persona personaAux : listaPersonas) {
        if (personaAux.getCedula() == cedula && personaAux instanceof AdminFlota) {
            return (AdminFlota) personaAux;
        }
    }
    return null;
    }

    public Empresa buscarEmpresa(Empresa empresa) {
        for (int i = 0; i < listaCasetas.size(); i++) {
            if (listaCasetas.get(i).getEmpresa().getNit() == empresa.getNit() || listaCasetas.get(i).getEmpresa().getNombre().equals(empresa.getNombre())) {
                return listaCasetas.get(i).getEmpresa();
            }
        }
        return null;
    }
    public AdminFlota buscarAdminFlotaYaRegistradoEnUnaEmpresa(AdminFlota adminFlota) {
        for (int i = 0; i < listaCasetas.size(); i++) {
            if (listaCasetas.get(i).getEmpresa().getAdminFlota().equals(adminFlota)) {
                return listaCasetas.get(i).getEmpresa().getAdminFlota() ;
            }
        }
        return null;
    }

    public void agregarCaseta(Caseta caseta) throws AdministradorYaRegistradoException, EmpresaRepetidaException, UsuarioNoEncontradoONoRegistradoException {
    Empresa empresaAux = buscarEmpresa(caseta.getEmpresa());
    
    if (empresaAux != null) {
        throw new EmpresaRepetidaException();
    }
    
    AdminFlota adminFlota = caseta.getEmpresa().getAdminFlota();
    if (adminFlota == null) {
        throw new UsuarioNoEncontradoONoRegistradoException();
    }
    

    if (buscarAdminFlotaYaRegistradoEnUnaEmpresa(adminFlota) != null) {
        throw new AdministradorYaRegistradoException();
    }
    

    if (buscarAdminflotaRegistrado(adminFlota.getCedula()) == null) {
        throw new UsuarioNoEncontradoONoRegistradoException();
    }
    

    listaCasetas.add(caseta);
    this.serializadora.escribirArrayListCasetas(listaCasetas);
}

    public ArrayList<Caseta> getListaCasetas() {
        return listaCasetas;
    }
    
}
