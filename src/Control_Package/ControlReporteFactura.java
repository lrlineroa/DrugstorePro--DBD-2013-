package Control_Package;

import DAOS.DAOFactory;
import Entities.Views.ViewFacturaTotal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Edward
 */
public class ControlReporteFactura {

    public void generarFactura(Integer idFactura) throws DocumentException, FileNotFoundException, IOException {
        List<ViewFacturaTotal> factura = searchFacturaTotalById(idFactura);

        BussinesControl control = new BussinesControl();

        Document documento = new Document();

        FileOutputStream ficheroPdf = new FileOutputStream("Factura " + idFactura + ".pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
        documento.open();

        documento.addTitle(control.searchDrogueriaById(LoginControl.usuarioActivo.getIdDrogueria()).getNombreDrogueria());
        final Paragraph pdrog = new Paragraph(control.searchDrogueriaById(LoginControl.usuarioActivo.getIdDrogueria()).getNombreDrogueria());
        pdrog.setAlignment(1);
        documento.add(pdrog);
        final Paragraph pfact = new Paragraph("Factura No. " + idFactura);
        pfact.setAlignment(1);
        documento.add(pfact);
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        final Paragraph pdate = new Paragraph(format.format(factura.get(0).getFechaFactura()));
        pdate.setAlignment(1);
        documento.add(pdate);
        documento.add(new Paragraph(" "));
        documento.add(new Paragraph(" "));
        PdfPTable tabla = new PdfPTable(5);

        tabla.addCell("Id Producto");
        tabla.addCell("Producto");
        tabla.addCell("Precio Unitario");
        tabla.addCell("Cantidad");
        tabla.addCell("Precio Total");
        for (ViewFacturaTotal fact : factura) {
            tabla.addCell(new Integer(fact.getIdProducto()).toString());
            tabla.addCell(fact.getNombreProducto());
            tabla.addCell(fact.getPrecioProducto().toString());
            tabla.addCell(fact.getCantidadVendida().toString());
            tabla.addCell(fact.getTotalProducto().toString());
        }
        documento.add(tabla);
        documento.add(new Paragraph(" "));

        float sumWithoutIVA = factura.get(0).getTotalFactura() * 0.84f;
        float IVA = factura.get(0).getTotalFactura() * 0.16f;
        final Paragraph psub = new Paragraph("SubTotal: " + sumWithoutIVA);
        psub.setAlignment(2);
        documento.add(psub);
        final Paragraph piva = new Paragraph("IVA: " + IVA);
        piva.setAlignment(2);
        documento.add(piva);
        final Paragraph ptotal = new Paragraph("Total: " + factura.get(0).getTotalFactura());
        ptotal.setAlignment(2);
        documento.add(ptotal);

        documento.addAuthor(LoginControl.usuarioActivo.getNombreDeUsuario());
        documento.addCreationDate();

        documento.close();
        ficheroPdf.close();

        File path = new File("Factura " + idFactura + ".pdf");
        Desktop.getDesktop().open(path);

    }

    public List<ViewFacturaTotal> searchFacturaTotalById(Integer idFactura) {
        return DAOFactory.getInstance().getViewFacturaTotalDAO().findFacturaTotalListByIdFactura(idFactura);
    }
}
