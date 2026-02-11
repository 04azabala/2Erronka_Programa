package erronka2;

import java.time.LocalDate;

public class berriak {
	
	private int id;
	private String berria_izena;
	private LocalDate data;
	private String berria;
	private String berri_argazkia;
	private String garrantzi_maila;
	
	public berriak(int id, String berria_izena, LocalDate data, String berria, String berri_argazkia, String garrantzi_maila) {
		this.id = id;
		this.berria_izena = berria_izena;
		this.data = data;
		this.berria = berria;
		this.berri_argazkia = berri_argazkia;
		this.garrantzi_maila = garrantzi_maila;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBerriaIzena() {
		return berria_izena;
	}
	
	public void setBerriaIzena(String berria_izena) {
		this.berria_izena = berria_izena;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getBerria() {
		return berria;
	}
	
	public void setBerria(String berria) {
		this.berria = berria;
	}
	
	public String getBerriArgazkia() {
		return berri_argazkia;
	}
	
	public String getGarrantziMaila() {
		return garrantzi_maila;
	}
	
	public void setGarrantziMaila(String garrantzi_maila) {
		this.garrantzi_maila = garrantzi_maila;
	}
	
}
