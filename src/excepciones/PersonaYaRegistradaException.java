/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class PersonaYaRegistradaException extends Exception {
    public PersonaYaRegistradaException() {
        super("Esta Persona ya esta registrada");
    }
    
}
