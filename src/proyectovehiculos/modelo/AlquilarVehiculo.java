/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.modelo;

import java.util.Calendar;
import java.util.Date;
import proyectovehiculos.abstracta.AbstractVehiculo;

/**
 *
 * @author Daniel Quintero
 */
public class AlquilarVehiculo {

    public AbstractVehiculo vehiculo;
    public Usuario usuarioRegistra;
    public Calendar fechaAlquiler;
    public Calendar fechaDevolucion;

    public AlquilarVehiculo(AbstractVehiculo vehiculo, Usuario usuarioRegistra, Calendar fechaAlquiler, Calendar fechaDevolucion) {
        this.vehiculo = vehiculo;
        this.usuarioRegistra = usuarioRegistra;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }
    

    public AbstractVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(AbstractVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(Usuario usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public Calendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Calendar fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Calendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Calendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Object[] obtenerArregloObjeto() {
        Object[] dataA = {getVehiculo().toString(), getUsuarioRegistra().toString(), getFechaAlquiler(), getFechaDevolucion()};
                
             return dataA;
    }
}
