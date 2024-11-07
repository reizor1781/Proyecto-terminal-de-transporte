/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class FechaInvalidaAntesDeLaLocalException extends Exception {
    public FechaInvalidaAntesDeLaLocalException(){
        super("La fecha del viaje es inválida. La fecha de salida no puede ser anterior a la fecha actual.Por favor, revise y corrija las fechas ingresadas.");
    }
    
}
