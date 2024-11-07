package excepciones;

public class EmpresaRepetidaException extends Exception {
    public EmpresaRepetidaException() {
        super("La empresa transportadora ya está registrada en esta terminal. Por favor, verifica los datos e intenta con una empresa diferente.");
    }
}
