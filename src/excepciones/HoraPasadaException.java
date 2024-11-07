package excepciones;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DARIO LOPEZ
 */
public class HoraPasadaException extends Exception{
    public HoraPasadaException(){
        super ("Error: La hora de salida no puede ser en el pasado. Por favor, ingrese una hora de salida futura para asegurar que el viaje se programe correctamente.");
    }
    
}
