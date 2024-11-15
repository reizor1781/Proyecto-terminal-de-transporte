package excepciones;

public class LimiteCantidadPlazasException extends Exception {
    public LimiteCantidadPlazasException() {
        super("Límite de capacidad alcanzado: No es posible registrar el vehículo porque se ha excedido el número máximo de plazas de estacionamiento asignadas a la empresa. Libere una plaza antes de intentar un nuevo registro.");
    }
}
