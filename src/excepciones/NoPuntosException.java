package excepciones;

public class NoPuntosException extends Exception {
    public NoPuntosException(int puntosDisponibles, int puntosRequeridos) {
        super("No tienes suficientes puntos para comprar el tiquete. Puntos disponibles: "
                + puntosDisponibles + ". Puntos requeridos: " + puntosRequeridos + ".");
    }
}
