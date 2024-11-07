/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DARIO LOPEZ
 */
public class VencidaElSoatException extends Exception {
    public VencidaElSoatException(){
      super("El estado del SOAT se encuentra vencido. Por favor, renueve el SOAT del vehículo para cumplir con las normas legales y garantizar la cobertura de seguridad en caso de accidentes.");   
    }
}
