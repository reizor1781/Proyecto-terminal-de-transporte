package excepciones;

public class EditarEmpresaException extends Exception {
    public EditarEmpresaException() {
        super("Error: No se pudo editar la empresa. Asegúrese de que los datos ingresados sean correctos y que no existan conflictos con otros registros. Intente nuevamente más tarde.");
    }
}
