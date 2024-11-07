package excepciones;

public class LimiteVehiculosException extends Exception {
    public LimiteVehiculosException() {
        super("Lo sentimos, no puedes registrar más vehículos. La empresa ha alcanzado el número máximo permitido de vehículos según las plazas de estacionamiento disponibles.");
    }
}
