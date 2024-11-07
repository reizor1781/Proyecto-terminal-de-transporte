package excepciones;

public class NoDisponibleVehiculoException extends Exception {
    public NoDisponibleVehiculoException() {
        super("El vehículo está actualmente en un viaje y no puede ser asignado a otro hasta un día después de su fecha de llegada. Por favor, selecciona otro vehículo o espera hasta que esté disponible nuevamente.");
    }
}
