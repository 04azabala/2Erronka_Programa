package erronka2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient; 
import org.apache.commons.net.ftp.FTPReply;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class fakturaPDF {

    public static void generarFactura(int id, bezeroak bezero, hornitzaileak hornitzaile, produktuak produktu, saskia saski, LocalDate data, double totala, int zenbatekoa) {
        String nombreArchivo = "faktura_" + id + ".pdf";
        File tempFile = new File(nombreArchivo);

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);
            
            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 16);
                cs.newLineAtOffset(50, 750);
                cs.showText("FAKTURA ZENBAKIA: " + id);
                cs.newLineAtOffset(0, -30);
                cs.setFont(PDType1Font.HELVETICA, 12);
                String nombre = (bezero != null) ? bezero.getIzena() + " " + bezero.getAbizena() : (hornitzaile != null ? hornitzaile.getIzena() : "Ezezaguna");
                cs.showText("Bezeroa: " + nombre);
                cs.newLineAtOffset(0, -20);
                cs.showText("Produktua: " + (produktu != null ? produktu.getIzena() : "Hainbat"));
                cs.newLineAtOffset(0, -20);
                cs.showText("Zenbatekoa: " + zenbatekoa);
                cs.newLineAtOffset(0, -20);
                cs.showText("Totala: " + totala + " €");
                cs.newLineAtOffset(0, -20);
                cs.showText("Data: " + data.toString());
                cs.endText();
            }
            doc.save(tempFile);
            
            if (subirArchivoFTP(tempFile, nombreArchivo)) {
                actualizarRutaEnDB(id, "fakturak/" + nombreArchivo);
                System.out.println("ONDO! Bidalia zerbitzarira.");
            } else {
                System.err.println("ERROREA: Ezin izan da zerbitzarira igo.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tempFile.exists()) tempFile.delete();
        }
    }

    private static boolean subirArchivoFTP(File archivo, String nombreRemoto) {
        FTPClient ftpClient = new FTPClient();
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        try {
            ftpClient.connect("192.168.115.171", 21); 
            
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                ftpClient.disconnect();
                return false;
            }

            if (!ftpClient.login("user1", "123")) return false;

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setControlKeepAliveTimeout(300);

            try (FileInputStream inputStream = new FileInputStream(archivo)) {
                return ftpClient.storeFile(nombreRemoto, inputStream);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) { }
        }
    }

    private static void actualizarRutaEnDB(int id, String ruta) {
        String sql = "UPDATE fakturak SET faktura_ruta = ? WHERE id = ?";
        try (Connection con = konexioa.konektatu();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ruta);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}