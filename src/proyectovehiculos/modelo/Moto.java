/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.modelo;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import javax.swing.JOptionPane;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.abstracta.VehiculoAble;

/**
 *
 * @author Daniel Quintero
 */
public class Moto extends AbstractVehiculo {

    public boolean casco;

    public Moto(boolean casco, String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.casco = casco;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    @Override
    public String mostrarDatos() {

        String mensaje = "el vehiculo tipo " + this.getClass().getSimpleName() + " con matricula " + this.getMatricula()
                + " tiene un kilomeraje actual de " + this.getKm() + " un valor de alquiler de " + this.getValorAlquiler() + " y el estado del casco es " + this.isCasco();
        return mensaje;

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
        setEstado(false);
    }

    @Override
    public Object[] obtenerArregloObjeto() {
        Object[] dataV = {getMatricula(), getKm(), isEstado(), getValorAlquiler(), isCasco()};

        return dataV;

    }

    @Override
    public String toString() {
        return this.getMatricula() + "-" + this.getClass().getSimpleName() + "(" + estado() + ")";
    }

    public String estado() {
        if (isEstado() == true) {
            return "Disponible";
        }
        return "Ocupado";
    }

}
