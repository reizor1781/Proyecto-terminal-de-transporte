/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class FechaInvalidaLlegadaAntesDeSalidaException extends Exception {
    
    public FechaInvalidaLlegadaAntesDeSalidaException(){
        super("La fecha del viaje es inválida. La fecha de llegada no puede ser anterior a la fecha de salida. Por favor, revise y corrija las fechas ingresadas." );
    }
    
}
