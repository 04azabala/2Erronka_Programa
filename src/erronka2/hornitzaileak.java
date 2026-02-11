package erronka2;

public class hornitzaileak {
	
	private int id;
	private String izena;
	private String kontaktu_izena;
	private String pasahitza;
	private String email;
	private String helbidea;
	private String telefonoa;
	
	public hornitzaileak(int id) {
		this.id = id;
	}
	
	public hornitzaileak(int id, String kontaktu_izena){
		this.id = id;
		this.kontaktu_izena = kontaktu_izena;
	}
	
	public hornitzaileak(int id, String izena, String kontaktu_izena, String email, String pasahitza, String helbidea, String telefonoa) {
		this.id = id;
		this.izena = izena;
		this.kontaktu_izena = kontaktu_izena;
		this.email = email;
		this.pasahitza = pasahitza;
		this.helbidea = helbidea;
		this.telefonoa = telefonoa;
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
	
	public String getKontaktuIzena() {
		return kontaktu_izena;
	}
	
	public void setKontaktuIzena(String kontaktu_izena) {
		this.kontaktu_izena = kontaktu_izena;
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
	
	public String getHelbidea() {
		return helbidea;
	}
	
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	
	public String getTelefonoa() {
		return telefonoa;
	}
	
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	public String toString() {
		return String.valueOf(id);
	}

}
