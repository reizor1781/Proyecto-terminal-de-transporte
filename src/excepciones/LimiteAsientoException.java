package excepciones;

public class LimiteAsientoException extends Exception {
    public LimiteAsientoException() {
        super("Lo sentimos, el vehículo ha alcanzado su capacidad máxima de pasajeros. Por favor, selecciona otro vehículo o revisa las opciones de disponibilidad más tarde.");
    }
}
