package excepciones;

public class NoAsientosException extends Exception {
    public NoAsientosException() {
        super("Operación no permitida: No es posible generar más tiquetes, ya que todos los asientos disponibles están ocupados.");
    }
}
