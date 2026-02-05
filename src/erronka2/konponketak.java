package erronka2;

import java.time.LocalDate;

public class konponketak {
	
	private int id;
	private langileak langilea;
	private LocalDate sarrera_data;
	private LocalDate amaiera_data;
	private String hasierako_egoera;
	private String hornitzaile_izena;
	private String bezero_izena;
	
	
	
	
	public konponketak(int id, langileak langilea ,LocalDate sarrera_data, LocalDate amaiera_data, String hasierako_egoera, String hornitzaile_izena , String bezero_izena) {
		this.id = id;
		this.langilea = langilea;
		this.sarrera_data = sarrera_data;
		this.amaiera_data = amaiera_data;
		this.hasierako_egoera = hasierako_egoera;
		this.hornitzaile_izena = hornitzaile_izena;
		this.bezero_izena = bezero_izena;
	
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public langileak getLangilea() {
		return langilea;
	}
	
	public void setLangilea(langileak langilea) {
		this.langilea = langilea;
	}
	
	public LocalDate getSarreraData() {
		return sarrera_data;
	}
	
	public void setSarreraData(LocalDate sarrera_data) {
		this.sarrera_data = sarrera_data;
	}
	
	public LocalDate getAmaieraData() {
		return amaiera_data;
	}
	
	public void setAmaieraData(LocalDate amaiera_data) {
		this.amaiera_data = amaiera_data;
	}
	
	public String getHasierakoEgoera() {
		return hasierako_egoera;
	}
	
	public void setHasierakoEgoera(String hasierako_egoera) {
		this.hasierako_egoera = hasierako_egoera;
	}
	
	public String getHornitzaileIzena() {
		return hornitzaile_izena;
	}
	
	public void setHornitzaileIzena(String hornitzaile_izena) {
		this.hornitzaile_izena = hornitzaile_izena;
	}
	
	public String getBezeroIzena() {
		return bezero_izena;
	}
	
	public void setBezeroa(String bezero_izena) {
		this.bezero_izena = bezero_izena;
	}
	
	
	
}
