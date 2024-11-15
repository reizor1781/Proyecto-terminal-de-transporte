package excepciones;

public class NoSeVendioElTiqueteException extends Exception {
    public NoSeVendioElTiqueteException() {
        super("No se vendio el tiquete por favor vuelva a intentarlo");
    }
}
