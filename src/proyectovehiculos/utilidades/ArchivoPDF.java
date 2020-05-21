/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectovehiculos.utilidades;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import proyectovehiculos.abstracta.AbstractVehiculo;
import proyectovehiculos.modelo.Moto;
import proyectovehiculos.modelo.AlquilarVehiculo;
import proyectovehiculos.modelo.Usuario;

/**
 *
 * @author Daniel Quintero
 */
public class ArchivoPDF {
    
    public static final String DESTINO = "./src/archivospdf/tablas.pdf";

    public static void main(String... args)
    {
        try
        {
            File archivo = new File(DESTINO);
            archivo.getParentFile().mkdirs();
            ArchivoPDF ejemplo = new ArchivoPDF();
            ejemplo.crearDocumentoPdf(DESTINO);
            ejemplo.abrirEjemplotabla2();
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void crearDocumentoPdf(String destino) throws Exception
    {

        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        Table tabla = new Table(8);
        for (int i = 0; i < 6; i++)
        {
            Cell cell = new Cell().add(new Paragraph("holaaaaa")
                    .setFont(font)
                    .setFontColor(ColorConstants.WHITE));
            cell.setBackgroundColor(ColorConstants.GREEN);
            cell.setBorder(Border.NO_BORDER);
            cell.setTextAlignment(TextAlignment.CENTER);
            tabla.addCell(cell);
            //Crea celda con string
            //tabla.addCell("Prog 1");
        }
        doc.add(tabla);
        doc.close();

    }

    public void abrirEjemplotabla()
    {
        try
        {
            File archivo = new File(DESTINO);
            Desktop.getDesktop().open(archivo);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void abrirDocumento(String ruta)
    {
        try
        {
            File archivo = new File(ruta);
            Desktop.getDesktop().open(archivo);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void abrirEjemplotabla2()
    {
        try
        {
            File archivo = new File(DESTINO);
            Runtime.getRuntime().exec("cmd /c start " + archivo);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private Cell obtenerCeldaEncabezado(String texto) throws IOException
    {
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Cell celda = new Cell().add(new Paragraph(texto)
                .setFont(font)
                .setFontColor(ColorConstants.WHITE));
        celda.setBackgroundColor(ColorConstants.GREEN);
        celda.setBorder(Border.NO_BORDER);
        celda.setTextAlignment(TextAlignment.CENTER);
        return celda;
    }

    public void crearDocumentoPdfVehiculosGeneral(String destino, List<AbstractVehiculo> listado) throws Exception
    {
        File archivo = new File(destino);
        archivo.getParentFile().mkdirs();
        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);

        Table tabla = new Table(5);
        tabla.addCell(obtenerCeldaEncabezado("Matricula"));
        tabla.addCell(obtenerCeldaEncabezado("Kilometraje"));
        tabla.addCell(obtenerCeldaEncabezado("Estado"));
        tabla.addCell(obtenerCeldaEncabezado("Valor Alquiler"));
        tabla.addCell(obtenerCeldaEncabezado("Tipo de Vehículo"));

        for (AbstractVehiculo veh : listado)
        {
            tabla.startNewRow();
            tabla.addCell(veh.getMatricula());
            tabla.addCell(String.valueOf(veh.getKm()));
            tabla.addCell(String.valueOf(veh.isEstado()));
            tabla.addCell(String.valueOf(veh.getValorAlquiler()));
            tabla.addCell(String.valueOf(veh.getClass().getSimpleName()));
            }

        doc.add(tabla);
        doc.close();

    }

    public void crearDocumentoPdfVehiculosAlquilados(String destino, List<AlquilarVehiculo> listado) throws Exception
    {
        File archivo = new File(destino);
        archivo.getParentFile().mkdirs();
        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);

        Table tabla = new Table(5);
        tabla.addCell(obtenerCeldaEncabezado("Vehículo Alquilado"));
        tabla.addCell(obtenerCeldaEncabezado("Cliente"));
        tabla.addCell(obtenerCeldaEncabezado("Fecha Alquiler"));
        tabla.addCell(obtenerCeldaEncabezado("Fecha Devolución"));

        for (AlquilarVehiculo veh : listado)
        {
           tabla.startNewRow();
            tabla.addCell(String.valueOf(veh.getVehiculo()));
            tabla.addCell(String.valueOf(veh.getUsuarioRegistra()));
            tabla.addCell(String.valueOf(veh.getFechaAlquiler()));
            tabla.addCell(String.valueOf(veh.getFechaDevolucion()));
        }

        doc.add(tabla);
        doc.close();

    }

    public void crearDocumentoPdfUsuarios(String destino, List<Usuario> listado) throws Exception
    {
        File archivo = new File(destino);
        archivo.getParentFile().mkdirs();
        PdfDocument documento = new PdfDocument(new PdfWriter(destino));
        Document doc = new Document(documento);

        Table tabla = new Table(4);
        tabla.addCell(obtenerCeldaEncabezado("Nombre"));
        tabla.addCell(obtenerCeldaEncabezado("Cedula"));
        tabla.addCell(obtenerCeldaEncabezado("Correo Electronico"));
        tabla.addCell(obtenerCeldaEncabezado("Tipo de Usuario"));

        for (Usuario us : listado)
        {
         tabla.startNewRow();
            tabla.addCell(String.valueOf(us.getCedula()));
            tabla.addCell(String.valueOf(us.getNombre()));
            tabla.addCell(String.valueOf(us.getCorreoElectronico()));
            tabla.addCell(String.valueOf(us.getTipoUsuario().getDescripcion()));
        }

        doc.add(tabla);
        doc.close();

    }
}
