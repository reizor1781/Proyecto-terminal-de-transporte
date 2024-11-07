/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class NoSePudoRegistrarLaPersonaException extends Exception {
    public NoSePudoRegistrarLaPersonaException (){
        super("Error: No se pudo registrar a la persona en el sistema. Verifique los datos ingresados o intente nuevamente.");
    }
    
}
