/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.modelo;

import java.io.Serializable;

/**
 *
 * @author Daniel Quintero
 */
public class Usuario implements Serializable {

    public String cedula;
    public String nombre;
    public String correoElectronico;
    public String password;
    public TipoUsuario tipoUsuario;

    public Usuario(String cedula, String nombre, String correoElectronico, String password, TipoUsuario tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;

    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Object[] obtenerArregloObjeto() {
        Object[] data = {getNombre(), getCedula(), getCorreoElectronico(), getTipoUsuario().toString()};
                
             return data;
    }
    
    public String toString1() {
        return this.getNombre() + "" + this.getCedula();
    }
}
