package excepciones;

public class NoExisteElViajeException extends Exception {
    public NoExisteElViajeException() {
        super("El viaje seleccionado no existe en su empresa");
    }
}
