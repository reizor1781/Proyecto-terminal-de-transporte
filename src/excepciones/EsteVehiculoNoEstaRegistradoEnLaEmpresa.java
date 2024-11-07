package excepciones;

public class EsteVehiculoNoEstaRegistradoEnLaEmpresa extends Exception {
    public EsteVehiculoNoEstaRegistradoEnLaEmpresa() {
        super("El vehículo especificado no se encuentra registrado en el sistema. Por favor, verifique que la placa ingresada sea correcta o registre el vehículo antes de proceder con esta operación.");
    }
}
