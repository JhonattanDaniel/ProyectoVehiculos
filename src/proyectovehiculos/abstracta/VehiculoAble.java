/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.abstracta;

/**
 *
 * @author Daniel Quintero
 */
public interface VehiculoAble {
    
    public void alquilar ();
    public void debolver (int kmFinal);
    public double calcularAlquiler (int km);
    public String mostrarDatos ();
    
    
  
     
}
