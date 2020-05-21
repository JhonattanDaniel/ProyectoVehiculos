/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.getionar;

import java.util.ArrayList;
import java.util.List;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.excepciones.ExcepcionVehiculo;
import proyectovehiculos.modelo.TipoUsuario;
import proyectovehiculos.modelo.Usuario;
import proyectovehiculos.utilidades.ArchivoPlano;

/**
 *
 * @author Daniel Quintero
 */
public class GestionUsuario {

    private TipoUsuario[] tipoUsuarios;

    private List<Usuario> usuarios;

    public TipoUsuario[] getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(TipoUsuario[] tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public GestionUsuario() {
        llenarTiposUsuario();
        llenarUsuarios();

    }

    private void llenarTiposUsuario() {
        tipoUsuarios = new TipoUsuario[3];
        tipoUsuarios[0] = new TipoUsuario("0", "Administrador");
        tipoUsuarios[1] = new TipoUsuario("1", "Usuario");
        tipoUsuarios[2] = new TipoUsuario("2", "Cliente");
    }

    public void llenarUsuarios() {

        //usuarios = new ArrayList<>();
        //usuarios.add(new Usuario("123456", "daniel", "daniel@gmail.com", "123", tipoUsuarios[0]));
        //cargar el csv
        usuarios = ArchivoPlano.cargarUsuarios(tipoUsuarios);

    }

    public Usuario encontrarUsuario(String correoElectronico, String password) {
        for (Usuario usuarioEncontrado : usuarios) {
            if (usuarioEncontrado.getCorreoElectronico().compareTo(correoElectronico) == 0
                    && usuarioEncontrado.getPassword().compareTo(password) == 0) {
                return usuarioEncontrado;
            }
        }

        return null;
    }

    public void adicionarUsuario(Usuario usuario) throws ExcepcionVehiculo {
        if (validarExistenciaUsuario(usuario)) {

            throw new ExcepcionVehiculo("El usuario con cedula " + usuario.getCedula()
                    + " ya existe");
        } else {
            usuarios.add(usuario);
            // agregarla en el archivo
        }
    }

    private boolean validarExistenciaUsuario(Usuario usuario) {
        for (Usuario usu : this.usuarios) {
            if (usu.getCedula().compareTo(usuario.getCedula()) == 0) {
                return true;
            }
        }
        return false;
    }
}

