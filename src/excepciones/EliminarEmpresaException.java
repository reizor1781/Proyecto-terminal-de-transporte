package excepciones;

public class EliminarEmpresaException extends Exception {
    public EliminarEmpresaException() {
        super("Error: No se pudo eliminar la empresa debido a un problema inesperado. Verifique que la empresa no esté asociada a otros registros o intente nuevamente más tarde.");
    }
}
