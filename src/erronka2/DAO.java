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
                    rs.getDate("data").toLocalDate(),
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
                    rs.getString("Nana"),
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
}
