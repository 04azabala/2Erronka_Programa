package erronka2;

import java.time.LocalDate;

public class konponketak {
	
	private int id;
	private String konponketen_egoera;
	private String konponketen_xehetasuna;
	private String konponketen_beharra;
	private String hasierako_egoera;
	private LocalDate amaiera_data;
	private LocalDate sarrera_data;
	private produktuak produktua;
	private String azken_emaitza;
	
	public konponketak(int id, String konponketen_egoera, String konponketen_xehetasuna, String konponketen_beharra, String hasierako_egoera, LocalDate amaiera_data, LocalDate sarrera_data, produktuak produktua, String azken_emaitza) {
		this.id = id;
		this.konponketen_egoera = konponketen_egoera;
		this.konponketen_xehetasuna = konponketen_xehetasuna;
		this.konponketen_beharra = konponketen_beharra;
		this.hasierako_egoera = hasierako_egoera;
		this.amaiera_data = amaiera_data;
		this.sarrera_data = sarrera_data;
		this.produktua = produktua;
		this.azken_emaitza = azken_emaitza;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getKonponketenEgoera() {
		return konponketen_egoera;
	}
	
	public void setKonponketenEgoera(String konponketen_egoera) {
		this.konponketen_egoera = konponketen_egoera;
	}
	
	public String getKonponketenXehetasuna() {
		return konponketen_xehetasuna;
	}
	
	public void setKonponketenXehetasuna(String konponketen_xehetasuna) {
		this.konponketen_xehetasuna = konponketen_xehetasuna;
	}
	
	public String getKonponketenBeharra() {
		return konponketen_beharra;
	}
	
	public void setKonponketenBeharra(String konponketen_beharra) {
		this.konponketen_beharra = konponketen_beharra;
	}
	
	public String getHasierakoEgoera() {
		return hasierako_egoera;
	}
	
	public void setHasierakoEgoera(String hasierako_egoera) {
		this.hasierako_egoera = hasierako_egoera;
	}
	
	public LocalDate getAmaieraData() {
		return amaiera_data;
	}
	
	public void setAmaieraData(LocalDate amaiera_data) {
		this.amaiera_data = amaiera_data;
	}
	
	public LocalDate getSarreraData() {
		return sarrera_data;
	}
	
	public void setSarreraData(LocalDate sarrera_data) {
		this.sarrera_data = sarrera_data;
	}
	
	public produktuak getProduktuak() {
		return produktua;
	}
	
	public void setProduktuak(produktuak produktua) {
		this.produktua = produktua;
	}
	
	public String getAzkenEmaitza() {
		return azken_emaitza;
	}
	
	public void setAzkenEmaitza(String azken_emaitza) {
		this.azken_emaitza = azken_emaitza;
	}
}
