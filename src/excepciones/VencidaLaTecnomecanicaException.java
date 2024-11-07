/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class VencidaLaTecnomecanicaException extends Exception {
    public VencidaLaTecnomecanicaException(){
        super("El estado de la tecnomecánica se encuentra vencido. Por favor, asegúrese de renovar la tecnomecánica del vehículo para cumplir con los requisitos legales y garantizar su seguridad en la vía.");
    }
    
}
