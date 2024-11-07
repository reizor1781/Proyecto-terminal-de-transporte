/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author CARLOS
 */
public class NoSeleccionoNadaException extends Exception{

    public NoSeleccionoNadaException() {
        super("No ha seleccionado ninguna fila. Por favor, seleccione una fila para continuar.");
    }
}
