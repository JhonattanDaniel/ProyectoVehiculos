/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.modelo;

import java.util.Date;
import proyectovehiculos.abstracta.AbstractVehiculo;

/**
 *
 * @author Daniel Quintero
 */
public class AlquilarVehiculo {
    public AbstractVehiculo vehiculo;
    public Usuario usuarioRegistra;
    public Date fechaAlquiler;
    public Date fechaDevolucion;

    public AlquilarVehiculo(AbstractVehiculo vehiculo, Usuario usuarioRegistra, Date fechaAlquiler, Date fechaDevolucion) {
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

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
}
