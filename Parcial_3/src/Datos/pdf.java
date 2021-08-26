
package Datos;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class pdf {
  
  
    String fecha;
   
    ArrayList<GS_Tareas> Tareas;

    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public pdf(String fecha, ArrayList<GS_Tareas> Tareas) {
        this.fecha = fecha;
        this.Tareas = Tareas;
        documento = new Document();
        titulo = new Paragraph("Comprobante de Tareas de la semana ");
    }
     

      
    
        public void crearReporte() {
        try {
            archivo = new FileOutputStream("Comprobante de tareas" + ".pdf");
            PdfWriter.getInstance(documento, archivo);

            documento.open();
            titulo.setAlignment(1);
            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);

            PdfPCell Fecha = new PdfPCell(new Phrase("Fecha de la tarea"));
            Fecha.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Nombre_Tarea = new PdfPCell(new Phrase("Nombre de la tarea"));
            Nombre_Tarea.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell Encargado_Tarea = new PdfPCell(new Phrase("Encargado de la tarea"));
            Encargado_Tarea.setBackgroundColor(BaseColor.LIGHT_GRAY);
             documento.add(Chunk.NEWLINE);

            tabla.addCell(Fecha);
            tabla.addCell(Nombre_Tarea);
            tabla.addCell(Encargado_Tarea);
            

            for (GS_Tareas i : Tareas) {
                tabla.addCell(i.getFecha());
                tabla.addCell(i.getNombreTarea() + "");
                tabla.addCell(i.getEncargado() + "");
                

            }

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha" + fecha));

            documento.close();

            JOptionPane.showMessageDialog(null, "Su reporte han sido procesado satisfactoriamente");

        } catch (Exception e) {
        }
    }
}
