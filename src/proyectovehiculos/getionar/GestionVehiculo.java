/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.getionar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.excepciones.ExcepcionVehiculo;
import proyectovehiculos.modelo.Coche;
import proyectovehiculos.modelo.Furgoneta;
import proyectovehiculos.modelo.Moto;
import proyectovehiculos.modelo.Usuario;
import proyectovehiculos.utilidades.ArchivoPlano;

/**
 *
 * @author Daniel Quintero
 */
public class GestionVehiculo implements Serializable {

    public List<AbstractVehiculo> vehiculos;

    public GestionVehiculo() {
        llenarVehiculos();
    }

    public List<AbstractVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<AbstractVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void llenarVehiculos() {
        //vehiculos = new ArrayList<>();

        //vehiculos.add(new Moto(true, "123qw", 100, true, 50000));
        //vehiculos.add(new Coche(true, "789poi", 200, true, 100000));
        //vehiculos.add(new Furgoneta((short) 8, "123asd", 150, false, 150000));
        vehiculos = ArchivoPlano.cargarMotos();
        vehiculos = ArchivoPlano.cargarCoches();
        vehiculos = ArchivoPlano.cargarFurgonetas();
        
    }

    public List<AbstractVehiculo> obtenerVehiculo (String tipo) {
        List<AbstractVehiculo> listaTemp = new ArrayList<>();
        //Recorrer todo el listado de personas , pero solo voy a adicionar a la lista la que me digan
        for (AbstractVehiculo vehiculo : vehiculos) {
            switch (tipo) {
                case "Moto":
                    if (vehiculo instanceof Moto) {
                        listaTemp.add(vehiculo);
                    }
                    break;
                case "Coche":
                    if (vehiculo instanceof Coche) {
                        listaTemp.add(vehiculo);
                    }
                    break;
                case "Furgoneta":
                    if (vehiculo instanceof Furgoneta) {
                        listaTemp.add(vehiculo);
                    }
                    break;
                default:
                    listaTemp.add(vehiculo);
            }
        }
        return listaTemp;
    }

    public void adicionarVehiculo(AbstractVehiculo vehiculo) throws ExcepcionVehiculo {
        if (validarExistenciaVehiculo(vehiculo)) {

            throw new ExcepcionVehiculo("El Vehiculo de matricula " + vehiculo.getMatricula()
                    + " ya existe");
        } else {
            vehiculos.add(vehiculo);
            // agregarla en el archivo
        }
    }

    private boolean validarExistenciaVehiculo(AbstractVehiculo vehiculo) {
        for (AbstractVehiculo Vehi : this.vehiculos) {
            if (Vehi.getMatricula().compareTo(vehiculo.getMatricula()) == 0) {
                return true;
            }
        }
        return false;
    }

}
