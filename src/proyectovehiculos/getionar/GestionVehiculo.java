/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.getionar;

import com.toedter.calendar.JDateChooser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.excepciones.ExcepcionVehiculo;
import proyectovehiculos.modelo.AlquilarVehiculo;
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
    public List<AlquilarVehiculo> vehiculosAlquilados;
    public List<AlquilarVehiculo> VehiculosOcupados;

    public GestionVehiculo() {
        llenarVehiculos();
        vehiculosAlquilados = new ArrayList<>();
        VehiculosOcupados = new ArrayList<>();
    }

    public List<AbstractVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<AbstractVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<AlquilarVehiculo> getVehiculosAlquilados() {
        return vehiculosAlquilados;
    }

    public void setVehiculosAlquilados(List<AlquilarVehiculo> vehiculosAlquilados) {
        this.vehiculosAlquilados = vehiculosAlquilados;
    }

    public void llenarVehiculos() {
        vehiculos = new ArrayList<>();

        ArchivoPlano.cargarFurgonetas(vehiculos);
        ArchivoPlano.cargarCoches(vehiculos);
        ArchivoPlano.cargarMotos(vehiculos);

    }

    public List<AbstractVehiculo> obtenerVehiculo(String tipo) {
        List<AbstractVehiculo> listaTemp = new ArrayList<>();
        //Recorrer todo el listado, pero solo voy a adicionar a la lista la que me digan
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

    public void adicionarVehiculoAlquilado(AlquilarVehiculo vehiculoAlquilado) {

        vehiculosAlquilados.add(vehiculoAlquilado);
        // agregarla en el archivo
    }

    public int contarDias(JDateChooser alquiler, JDateChooser devolucion) {
        if (alquiler != null && devolucion != null) {
            Calendar fechaAlquiler = alquiler.getCalendar();
            Calendar fechaDevolucion = devolucion.getCalendar();
            int dias = 0;

            while (fechaAlquiler.before(fechaDevolucion) || fechaAlquiler.equals(fechaDevolucion)) {
                dias++;
                fechaAlquiler.add(Calendar.DATE, 1);
            }
            return dias;
        }
        return 0;

    }
    public List<AlquilarVehiculo> llenarListaOcupados(AbstractVehiculo vehiculoOcupado){
        for (AlquilarVehiculo vehiculoAlquilado : getVehiculosAlquilados()) {
            if(vehiculoAlquilado.getVehiculo().equals(vehiculoOcupado)){
                VehiculosOcupados.add(vehiculoAlquilado);
            }
        }
        return VehiculosOcupados;
    }
    public boolean  ocupacionFechas(List<AlquilarVehiculo> nuevaLista, AbstractVehiculo vehiculoOcupado, Date inicio, Date fin){
        for (AlquilarVehiculo ocupacionFechas : nuevaLista) {
            if(ocupacionFechas.getVehiculo().equals(vehiculoOcupado)){
                if(ocupacionFechas.getFechaDevolucion().compareTo(inicio) >= 0 && 
                        ocupacionFechas.getFechaAlquiler().compareTo(fin) <= 0){
                    return false;
                }
            }else{
                continue;
            
            }
            
        }
        return true;
    }
    
}
