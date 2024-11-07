/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class HoraInvalidaException extends Exception {
    public HoraInvalidaException(){
        super("Error: La hora de salida del viaje no puede ser posterior a la hora de llegada. Asegúrese de que la hora de salida esté antes o coincida con la hora de llegada para una programación válida del viaje.");
    }
    
}
