/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author CARLOS
 */
public class ClienteNoRegistradoException extends Exception{
    public ClienteNoRegistradoException (){
        super("Este usuario aun no se ha registrado porfavor registrarse antes de iniciar sesion");
    }
}
