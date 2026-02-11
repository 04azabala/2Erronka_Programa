package erronka2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class fakturaPDF {


    public static void generarFactura(int id, bezeroak bezero, hornitzaileak hornitzaile,produktuak produktu,saskia saski, LocalDate data, double totala, int zenbatekoa) {
    	
    	
    	String bezeroIzena = (bezero != null) ? bezero.getIzena() : "Ezezaguna";
    	String bezeroAbizena = (bezero != null) ? bezero.getAbizena() : "";
    	String hornitzaileIzena = (hornitzaile != null) ? hornitzaile.getKontaktuIzena() : "Ezezaguna";
    	String produktuIzena = (produktu != null) ? produktu.getIzena() : "Ezezaguna";
    	int saskiZenbatekoa = (saski != null) ? saski.getZenbatekoa() : 0;
    	double saskiTotala = (saski != null) ? saski.getTotala() : 0.0;
    	LocalDate saskiData = saski.getData();

	


        File carpeta = new File("fakturak");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        
        
        String fitxategiIzena = "fakturak/faktura_" + id + ".pdf";

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream cs = new PDPageContentStream(doc, page);

            // Encabezado
            cs.setFont(PDType1Font.HELVETICA_BOLD, 18);
            cs.beginText();
            cs.newLineAtOffset(50, 750);
            cs.showText("FAKTURA ZENBAKIA " + id);
            cs.endText();

            // Información cliente/factura
            cs.setFont(PDType1Font.HELVETICA, 12);
            cs.beginText();
            cs.newLineAtOffset(50, 720);
            if(bezeroIzena.equals("Ezezaguna")) {
            cs.showText("Hornitzailea: " + hornitzaileIzena);
            cs.newLineAtOffset(0, -20);
            }
            if(hornitzaileIzena.equals("Ezezaguna")) {
            cs.showText("Bezeroa: " + bezeroIzena + " " + bezeroAbizena);
            cs.newLineAtOffset(0, -20);
            }
            cs.showText("Produktua: " + produktuIzena);
            cs.newLineAtOffset(0, -20);
            cs.showText("Zenbatekoa: " + saskiZenbatekoa);
            cs.newLineAtOffset(0, -20);
            cs.showText("Totala: " + saskiTotala + " €");
            cs.newLineAtOffset(0, -20);
            cs.showText("Data: " + saskiData);
            cs.endText();

            cs.close();

            // Guardar PDF
            doc.save(fitxategiIzena);

            System.out.println("PDF-a sortuta: " + fitxategiIzena);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
