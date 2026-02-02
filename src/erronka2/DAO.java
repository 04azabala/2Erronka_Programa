package erronka2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                    rs.getDate("data").toLocalDate(),
                    rs.getDouble("totala")
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
    
    public ArrayList<formularioKonponketa> getFormularioKonponketa() {
        ArrayList<formularioKonponketa> formularioKonponketaZerrenda = new ArrayList<>();

        try {
            Connection con = konexioa.konektatu();
            String sql = "SELECT * FROM formulario_konponketa";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                formularioKonponketa f = new formularioKonponketa(
                    rs.getInt("id"),
                    rs.getString("izena"),
                    rs.getString("kontaktu_izena"),
                    rs.getString("email"),
                    rs.getString("telefonoa"),
                    rs.getString("helbidea")
                );
                formularioKonponketaZerrenda.add(f);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return formularioKonponketaZerrenda;
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
            	
                konponketak k = new konponketak(
                    rs.getInt("id"),
                    new langileak(rs.getInt("id_langilea")),
                    rs.getDate("sarrera_data").toLocalDate(),
                    rs.getDate("amaiera_data").toLocalDate(),
                    rs.getString("hasierako_egoera"),
                    rs.getString("konponketen_beharra"),
                    new bezeroak(rs.getInt("bezero_id")),
                    rs.getString("azken_emaitza"),
                    rs.getString("proba_emaitza"),
                    rs.getString("konponenten_xehetasunak"),
                    rs.getString("konponenten_egoera")
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
                    new produktuak(rs.getInt("id_produktua")),
                    new fakturak(rs.getInt("id_faktura")),
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
}
