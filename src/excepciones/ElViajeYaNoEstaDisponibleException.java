package excepciones;

public class ElViajeYaNoEstaDisponibleException extends RuntimeException {
    public ElViajeYaNoEstaDisponibleException() {
        super("Operación no permitida: No es posible generar el tiquete porque la fecha del viaje ya ha pasado. Verifique la fecha e intente nuevamente con un viaje futuro.");
    }
}
