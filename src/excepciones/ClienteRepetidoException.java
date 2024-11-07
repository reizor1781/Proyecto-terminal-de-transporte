package excepciones;

public class ClienteRepetidoException extends Exception {
    public ClienteRepetidoException() {
        super("Error: Ya existe un usuario registrado con esta cédula. Por favor, verifica la información o utiliza una cédula diferente.");
    }
}
