package excepciones;

public class AdministradorYaRegistradoException extends Exception{
    public AdministradorYaRegistradoException(){
        super("El administrador de flota ya está asignado a otra empresa. Un administrador solo puede trabajar para una empresa a la vez. Por favor, selecciona otro administrador o verifica la información.");
    }
}
