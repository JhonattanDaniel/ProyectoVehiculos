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
}
