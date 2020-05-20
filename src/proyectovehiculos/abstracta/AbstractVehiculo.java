/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.abstracta;

/**
 *
 * @author Daniel Quintero
 */
public abstract class AbstractVehiculo implements VehiculoAble {

    public String matricula;
    public int km;
    public boolean estado;
    public double valorAlquiler;

    public AbstractVehiculo(String matricula, int km, boolean estado, double valorAlquiler) {
        this.matricula = matricula;
        this.km = km;
        this.estado = estado;
        this.valorAlquiler = valorAlquiler;
        
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getValorAlquiler() {
        return valorAlquiler;
    }

    public void setValorAlquiler(double valorAlquiler) {
        this.valorAlquiler = valorAlquiler;
    }

    @Override
    public abstract String mostrarDatos();

    @Override
    public abstract double calcularAlquiler(int km);

    @Override
    public abstract void debolver(int kmFinal);

    @Override
    public abstract void alquilar();

    public abstract Object[] obtenerArregloObjeto();
   
   public Object[] obtenerArregloPersonaObjeto()
   {
       Object[] dataV = {getMatricula(), getKm(), isEstado(), getValorAlquiler(), getClass().getName().toString()};

        return dataV;

    }
  public  abstract String listarCombos();
}
