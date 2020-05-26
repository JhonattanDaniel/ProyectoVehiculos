/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.modelo;

import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.vista.MdiVehiculos;

/**
 *
 * @author Daniel Quintero
 */
public class Coche extends AbstractVehiculo {

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
        String mensaje = "el vehiculo tipo " + this.getClass().getSimpleName() + " con matricula " + this.getMatricula()
                + " tiene un kilomeraje actual de " + this.getKm() + " un valor de alquiler de " + this.getValorAlquiler() + " y el estado de extras es " + this.isExtras();
        return mensaje;
    }

    @Override
    public double calcularAlquiler(int dias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debolver(int kmFinal) {
        setKm(kmFinal);
        setEstado(true);
    }

    @Override
    public void alquilar() {
        setEstado(false);
    }

    @Override
    public Object[] obtenerArregloObjeto() {
        Object[] dataV = {getMatricula(), getKm(), isEstado(), getValorAlquiler(), isExtras()};

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
