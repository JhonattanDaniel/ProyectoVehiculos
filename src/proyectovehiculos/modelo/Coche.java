/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.modelo;

import proyectovehiculos.abstracta.AbstractVehiculo;

/**
 *
 * @author Daniel Quintero
 */
public class Coche extends AbstractVehiculo{
    
    public boolean extras;

    public Coche(boolean extras, String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.extras = extras;
    }

    public boolean isExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    
    @Override
    public String mostrarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularAlquiler(int km) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debolver(int kmFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alquilar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] obtenerArregloObjeto() {
         Object[] dataV = {getMatricula(), getKm(), isEstado(), getValorAlquiler(), isExtras() };

        return dataV;
    }

    
    
}
