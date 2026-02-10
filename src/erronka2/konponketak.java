package erronka2;

import java.time.LocalDate;

public class konponketak {
	
	private int id;
	private langileak langilea;
	private bezeroak bezero;
	private hornitzaileak hornitzaile;
	private LocalDate sarrera_data;
	private LocalDate amaiera_data;
	private String hasierako_egoera;
	
	
	
	
	
	
	public konponketak(int id, langileak langilea , bezeroak bezero, hornitzaileak hornitzaile, LocalDate sarrera_data, LocalDate amaiera_data, String hasierako_egoera ) {
		this.id = id;
		this.langilea = langilea;
		this.bezero = bezero;
		this.hornitzaile = hornitzaile;
		this.sarrera_data = sarrera_data;
		this.amaiera_data = amaiera_data;
		this.hasierako_egoera = hasierako_egoera;
	
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
	
	public hornitzaileak getHornitzaile() {
		return hornitzaile;
	}
	
	public void setHornitzaileIzena(hornitzaileak hornitzaile) {
		this.hornitzaile = hornitzaile;
	}
	
	public bezeroak getBezero() {
		return bezero;
	}
	
	public void setBezeroa(bezeroak bezero) {
		this.bezero = bezero;
	}
	
	
	
}
