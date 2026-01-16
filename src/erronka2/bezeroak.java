package erronka2;

public class bezeroak {
	
	private int id;
	private String izena;
	private String abizena;
	private String rola;
	private String pasahitza;
	private String email;
	
	public bezeroak(int id, String izena, String abizena, String rola, String pasahitza, String email) {
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
		this.rola = rola;
		this.pasahitza = pasahitza;
		this.email = email;
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
	
	public String getRola() {
		return rola;
	}
	
	public void setRola(String rola) {
		this.rola = rola;
	}
	
	public String getPasahitza() {
		return pasahitza;
	}
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
