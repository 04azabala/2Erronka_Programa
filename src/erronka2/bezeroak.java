package erronka2;

public class bezeroak {
	
	private int id;
	private String izena;
	private String abizena;
	private String NAN;
	private String pasahitza;
	private String email;
	
	public bezeroak(int id) {
		this.id = id;
	}
	
	public bezeroak(int id, String izena) {
		this.id = id;
		this.izena = izena;
	}
	
	public bezeroak(int id, String NAN, String izena, String abizena, String email, String pasahitza) {
		this.id = id;
		this.NAN = NAN;
		this.izena = izena;
		this.abizena = abizena;
		this.email = email;
		this.pasahitza = pasahitza;
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
	
	public String getNAN() {
		return NAN;
	}
	
	public void setNAN(String NAN) {
		this.NAN = NAN;
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
	
	public String toString() {
	    return this.izena;
	}

}
