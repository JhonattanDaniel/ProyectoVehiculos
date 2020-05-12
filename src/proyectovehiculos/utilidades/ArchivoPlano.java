/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.modelo.Coche;
import proyectovehiculos.modelo.Furgoneta;
import proyectovehiculos.modelo.Moto;
import proyectovehiculos.modelo.TipoUsuario;
import proyectovehiculos.modelo.Usuario;

/**
 *
 * @author Daniel Quintero
 */
public class ArchivoPlano {

    public static List<Usuario> cargarUsuarios(TipoUsuario[] tipos) {
        List<Usuario> listado = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/usuvehiculos.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                Usuario usuario = new Usuario(
                        datos[0],
                        datos[1],
                        datos[2],
                        datos[3],
                        tipos[Integer.parseInt(datos[4])]);

                listado.add(usuario);

            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }
    public static List<AbstractVehiculo>  cargarMotos() {
        List<AbstractVehiculo> listado = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/motos.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                Moto moto = new Moto(
                        Boolean.parseBoolean(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Boolean.parseBoolean(datos[3]),
                        Double.parseDouble(datos[4]));

                listado.add(moto);

            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }
    public static List<AbstractVehiculo>  cargarCoches() {
        List<AbstractVehiculo> listado = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/coches.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                Coche coche = new Coche(
                        Boolean.parseBoolean(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Boolean.parseBoolean(datos[3]),
                        Double.parseDouble(datos[4]));

                listado.add(coche);

            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }
    public static List<AbstractVehiculo>  cargarFurgonetas() {
        List<AbstractVehiculo> listado = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("src/furgonetas.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                Furgoneta furgoneta = new Furgoneta(
                        Short.parseShort(datos[0]),
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Boolean.parseBoolean(datos[3]),
                        Double.parseDouble(datos[4]));

                listado.add(furgoneta);

            }
        } catch (Exception e) {
            System.out.println("El archivo no existe = " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return listado;
    }
}
