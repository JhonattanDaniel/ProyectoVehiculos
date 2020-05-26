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
public class Furgoneta extends AbstractVehiculo {

    public short capacidad;

    public Furgoneta(short capacidad, String matricula, int km, boolean estado, double valorAlquiler) {
        super(matricula, km, estado, valorAlquiler);
        this.capacidad = capacidad;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String mostrarDatos() {
        String mensaje = "el vehiculo tipo " + this.getClass().getSimpleName() + " con matricula " + this.getMatricula()
                + " tiene un kilomeraje actual de " + this.getKm() + " un valor de alquiler de " + this.getValorAlquiler() + " y una capacidad de " + this.getCapacidad();
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
        Object[] dataV = {getMatricula(), getKm(), isEstado(), getValorAlquiler(), getCapacidad()};

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
