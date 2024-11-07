package controlador.terminal;
import excepciones.*;
import modelo.*;
import persistencia.Serializadora;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorVistaAdminTerminal {
    private Serializadora serializadora;
    private ArrayList<Caseta> listaCasetas;
    private ArrayList<Persona> listaPersonas;
    public ControladorVistaAdminTerminal() {
        this.serializadora = new Serializadora();
        this.listaCasetas = serializadora.leerArrayListCasetas();
        this.listaPersonas = serializadora.leerArrayListPersonas();
    }
    
    public Empresa buscarEmpresa(Empresa empresa) {
        for (int i = 0; i < listaCasetas.size(); i++) {
            if (listaCasetas.get(i).getEmpresa().getNit() == empresa.getNit() || listaCasetas.get(i).getEmpresa().getNombre().equals(empresa.getNombre())) {
                return listaCasetas.get(i).getEmpresa();
            }
        }
        return null;
    }
    public AdminFlota buscarAdminFlota(AdminFlota adminFlota) {
        for (int i = 0; i < listaCasetas.size(); i++) {
            if (listaCasetas.get(i).getEmpresa().getAdminFlota().equals(adminFlota)) {
                return listaCasetas.get(i).getEmpresa().getAdminFlota() ;
            }
        }
        return null;
    }

    public void agregarCaseta(Caseta caseta) throws AdministradorYaRegistradoException, EmpresaRepetidaException {
        Empresa aux = buscarEmpresa(caseta.getEmpresa());
        if (aux != null) {
            throw new EmpresaRepetidaException();
        }
        if (buscarAdminFlota(caseta.getEmpresa().getAdminFlota()) != null) {
            throw new AdministradorYaRegistradoException();
        }
        listaCasetas.add(caseta);
        this.serializadora.escribirArrayListCasetas(listaCasetas);
    }
    public void eliminarCaseta(Caseta caseta) throws EliminarEmpresaException {
        for (int i = 0; i < listaCasetas.size(); i++) {
            if (listaCasetas.get(i).getEmpresa().getNit() == caseta.getEmpresa().getNit()) {
                listaCasetas.remove(i);
                this.serializadora.escribirArrayListCasetas(listaCasetas);
            }
            throw new EliminarEmpresaException();
        }
    }
    public Caseta buscarCaseta(Caseta caseta){
        for (int i = 0; i < listaCasetas.size(); i++) {
            if (caseta.equals(listaCasetas.get(i))) {
                return listaCasetas.get(i);
            }
        }
        return null;
    }
    public void modificarEmpresa(Caseta caseta) throws EditarEmpresaException,AdministradorYaRegistradoException {
        Empresa auxEmpresa = buscarEmpresa(caseta.getEmpresa());
        if (auxEmpresa != null) {
            AdminFlota auxAdmin = buscarAdminFlota(caseta.getEmpresa().getAdminFlota());
            if (auxAdmin != null)  {
                throw new AdministradorYaRegistradoException();
            }
            auxEmpresa.setAdminFlota(caseta.getEmpresa().getAdminFlota());
            auxEmpresa.setNombre(caseta.getEmpresa().getNombre());
            this.serializadora.escribirArrayListCasetas(listaCasetas);
        }
        throw new EditarEmpresaException();
    }
    public void modificarCaseta(Caseta caseta)throws EmpresaRepetidaException{
        Caseta casetaAux = buscarCaseta(caseta);
        if (casetaAux != null){
            Empresa empresaAux = buscarEmpresa(casetaAux.getEmpresa());
            if (empresaAux != null) {
                throw new EmpresaRepetidaException();
            }
            casetaAux.setEmpresa(caseta.getEmpresa());
            casetaAux.setCanonArrendamiento(caseta.getCanonArrendamiento());
            casetaAux.setCantidadPlazas(caseta.getCantidadPlazas());
        }

    }

    public ArrayList<Caseta> getListaCasetas() {
        return listaCasetas;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
