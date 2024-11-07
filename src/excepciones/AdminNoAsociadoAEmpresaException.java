/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class AdminNoAsociadoAEmpresaException extends Exception{
    public AdminNoAsociadoAEmpresaException(){
        super("El usuario especificado no se encuentra asociado a ninguna empresa de flota en el sistema. Por favor, verifique los datos ingresados o registre al usuario en una empresa antes de proceder con esta operación.");
    }
}
