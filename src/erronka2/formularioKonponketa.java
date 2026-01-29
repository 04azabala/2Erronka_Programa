package erronka2;

public class formularioKonponketa {
	
	public formularioKonponketa(int id, String izena, String kontaktu_izena, String email, String telefonoa, String helbidea) {
		this.id = id;
		this.izena = izena;
		this.kontaktu_izena = kontaktu_izena;
		this.email = email;
		this.telefonoa = telefonoa;
		this.helbidea = helbidea;
	}
	
	private int id;
	private String izena;
	private String kontaktu_izena;
	private String email;
	private String telefonoa;
	private String helbidea;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefonoa() {
		return telefonoa;
	}
	
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	public String getHelbidea() {
		return helbidea;
	}
	
	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
}
