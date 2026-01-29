package erronka2;

public class langileak {
	
	private int id;
	private String izena;
	private String abizena;
	private String erabiltzailea;
	private String pasahitza;
	private String rola;
	
	public langileak(int id, String izena, String abizena, String erabiltzailea, String pasahitza, String rola) {
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.rola = rola;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIzena() {
		return izena;
	}
	
	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	public String getAbizena() {
		return abizena;
	}
	
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	
	public String getErabiltzailea() {
		return erabiltzailea;
	}
	
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	
	public String getPasahitza() {
		return pasahitza;
	}
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	
	public String getRola() {
		return rola;
	}
	
	public void setRola(String rola) {
		this.rola = rola;
	}
}
