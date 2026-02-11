package erronka2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class DAO {

    public ArrayList<langileak> getLangileak() {
        ArrayList<langileak> langileZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM langileak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                langileak l = new langileak(
                    rs.getInt("id"),
                    rs.getString("izena"),
                    rs.getString("abizena"),
                    rs.getString("erabiltzailea"),
                    rs.getString("pasahitza"),
                    rs.getString("rola")
                );
                langileZerrenda.add(l);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return langileZerrenda;
    }
    
    public ArrayList<berriak> getBerriak() {
        ArrayList<berriak> berriZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM berriak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                berriak b = new berriak(
                    rs.getInt("id"),
                    rs.getString("berria_izena"),
                    rs.getDate("berria_data").toLocalDate(),
                    rs.getString("berria"),
                    rs.getString("berria_argazkia"),
                    rs.getString("garrantzi_maila")
                );
                berriZerrenda.add(b);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return berriZerrenda;
    }
    
    public ArrayList<bezeroak> getBezeroak() {
        ArrayList<bezeroak> bezeroZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM bezeroak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bezeroak b = new bezeroak(
                    rs.getInt("id"),
                    rs.getString("NAN"),
                    rs.getString("izena"),
                    rs.getString("abizena"),
                    rs.getString("email"),
                    rs.getString("pasahitza")
                );
                bezeroZerrenda.add(b);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bezeroZerrenda;
    }
    
    public bezeroak getBezeroa(int id) {
        bezeroak b = null;  

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM bezeroak WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {  
                b = new bezeroak(
                    rs.getInt("id"),
                    rs.getString("NAN"),
                    rs.getString("izena"),
                    rs.getString("abizena"),
                    rs.getString("email"),
                    rs.getString("pasahitza")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }
    
    public hornitzaileak getHornitzailea(int id) {
        hornitzaileak h = null; 

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM hornitzaileak WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {  
                h = new hornitzaileak(
                    rs.getInt("id"),
                    rs.getString("izena"),
                    rs.getString("kontaktu_izena"),
                    rs.getString("email"),
                    rs.getString("pasahitza"),
                    rs.getString("helbidea"),
                    rs.getString("telefonoa")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return h;
    }

    
    public produktuak getProduktua(int id) {
        produktuak p = null;  // Declarar fuera para poder retornarlo

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM produktuak WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {  // Solo un registro
                p = new produktuak(
                    rs.getInt("id"),
                    rs.getString("izena"),
                    rs.getDouble("prezioa"),
                    rs.getInt("stock"),
                    rs.getString("egoera"),
                    rs.getString("konponketa"),
                    rs.getString("mota")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
    
    public saskia getSaski(int id) {
        saskia s = null;  // Declarar fuera para poder retornarlo

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM erosketa WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {  // Solo un registro
                s = new saskia(
                    rs.getInt("id"),
                    new bezeroak(rs.getInt("id_bezeroa")),
                    new hornitzaileak(rs.getInt("id_hornitzailea")),
                    new produktuak(rs.getInt("id_produktua")),
                    rs.getDouble("totala"),
                    rs.getDate("data").toLocalDate(),
                    rs.getInt("zenbatekoa")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
    
    
    public ArrayList<fakturak> getFakturak() {
        ArrayList<fakturak> fakturaZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM fakturak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fakturak f = new fakturak(
                    rs.getInt("id"),
                    new bezeroak(rs.getInt("id_bezeroa")),
                    new hornitzaileak(rs.getInt("id_hornitzailea")),
                    new produktuak(rs.getInt("id_produktua")),
                    new saskia(rs.getInt("id_saskia")),
                    rs.getDate("data").toLocalDate(),
                    rs.getDouble("totala"),
                    rs.getInt("zenbatekoa"),
                    rs.getString("faktura_ruta")
                );
                fakturaZerrenda.add(f);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fakturaZerrenda;
    }
    
    
    
    public ArrayList<hornitzaileak> getHornitzaileak() {
        ArrayList<hornitzaileak> hornitzaileZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM hornitzaileak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hornitzaileak h = new hornitzaileak(
                    rs.getInt("id"),
                    rs.getString("izena"),
                    rs.getString("kontaktu_izena"),
                    rs.getString("pasahitza"),
                    rs.getString("email"),
                    rs.getString("helbidea"),
                    rs.getString("telefonoa")
                );
                hornitzaileZerrenda.add(h);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hornitzaileZerrenda;
    }
    
    public ArrayList<produktuak> getProduktuak() {
        ArrayList<produktuak> produktuZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM produktuak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                produktuak p = new produktuak(
                    rs.getInt("id"),
                    rs.getString("izena"),
                    rs.getDouble("prezioa"),
                    rs.getInt("stock"),
                    rs.getString("egoera"),
                    rs.getString("konponketa"),
                    rs.getString("mota")
                );
                produktuZerrenda.add(p);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produktuZerrenda;
    }
    
    public ArrayList<konponketak> getKonponketak() {
        ArrayList<konponketak> konponketaZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM konponketak";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Date amaieraSql = rs.getDate("amaiera_data");
                LocalDate amaieraData = (amaieraSql != null) ? amaieraSql.toLocalDate() : null;

                konponketak k = new konponketak(
                    rs.getInt("id"),
                    new langileak(rs.getInt("id_langilea")),
                    new bezeroak (rs.getInt("bezero_id")),
                    new hornitzaileak(rs.getInt("hornitzaile_id")),
                    rs.getDate("sarrera_data").toLocalDate(),
                    amaieraData,
                    rs.getString("hasierako_egoera")
                );
                konponketaZerrenda.add(k);
            }


            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return konponketaZerrenda;
    }
    
    public ArrayList<saskia> getSaskia() {
        ArrayList<saskia> saskiZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM erosketa";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	
                saskia s = new saskia(
                    rs.getInt("id"),
                    new bezeroak(rs.getInt("id_bezeroa")),
                    new hornitzaileak(rs.getInt("id_hornitzailea")),
                    new produktuak(rs.getInt("id_produktua")),
                    rs.getDouble("totala"),
                    rs.getDate("data").toLocalDate(),
                    rs.getInt("zenbatekoa")
                    
                );
                saskiZerrenda.add(s);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return saskiZerrenda;
    }
    
    public ArrayList<formularioa> getFormularioa() {
        ArrayList<formularioa> FormularioZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM formularioa";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	
                formularioa s = new formularioa(
                    rs.getInt("id"),
                    new bezeroak(rs.getInt("bezero_id")),
                    new hornitzaileak(rs.getInt("hornitzaile_id")),
                    rs.getString("Bezero_mota"),
                    rs.getString("Izena"),
                    rs.getString("Abizena"),
                    rs.getString("Harremanetako_pertsona"),
                    rs.getString("Posta_elektronikoa"),
                    rs.getString("Telefonoa"),
                    rs.getString("Enpresaren_izena"),
                    rs.getString("Produktu_mota"),
                    rs.getString("Produktu_marka"),
                    rs.getString("Produktua"),
                    rs.getInt("Produktu_kopurua"),
                    rs.getString("Produktuaren_deskribapena"),
                    rs.getString("Oharrak")                    
                );
                FormularioZerrenda.add(s);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return FormularioZerrenda;
    }
    
    public fakturak getFacturaPorId(int id) {
        fakturak f = null;
        try (Connection con = konexioa.konektatu()) {
            String sql = "SELECT * FROM fakturak WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            

            if (rs.next()) {
            	
            	
            	
            	bezeroak b = getBezeroa(rs.getInt("id_bezeroa"));
                hornitzaileak h = getHornitzailea(rs.getInt("id_hornitzailea"));
                produktuak p = getProduktua(rs.getInt("id_produktua"));
                saskia s = getSaski(rs.getInt("id_saskia"));
                
                
            	f = new fakturak(
                    rs.getInt("id"),
                    b,
                    h,
                    p,
                    s,
                    rs.getDate("data").toLocalDate(),
                    rs.getDouble("totala"),
                    rs.getInt("zenbatekoa"),
                    rs.getString("faktura_ruta")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
