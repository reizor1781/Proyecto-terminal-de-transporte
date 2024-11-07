package excepciones;

public class PlacaRepetidaException extends Exception {
    public PlacaRepetidaException() {
        super("Error: La placa del bus ya está registrada en otra empresa de transporte. Por favor, verifica la información y asegúrate de que la placa sea única.");
    }
}
