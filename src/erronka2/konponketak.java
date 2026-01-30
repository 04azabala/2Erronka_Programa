package erronka2;

import java.time.LocalDate;

public class konponketak {
	
	private int id;
	private LocalDate sarrera_data;
	private LocalDate amaiera_data;
	private String hasierako_egoera;
	private String konponenten_beharra;
	private bezeroak bezeroa;
	private String azken_emaitza;
	private String proba_emaitza;
	private String konponenten_xehetasunak;
	private String konponenten_egoera;
	
	
	public konponketak(int id, LocalDate sarrera_data, LocalDate amaiera_data, String hasierako_egoera, String konponenten_beharra, bezeroak bezeroa, String azken_emaitza, String proba_emaitza, String konponenten_xehetasunak, String konponenten_egoera) {
		this.id = id;
		this.sarrera_data = sarrera_data;
		this.amaiera_data = amaiera_data;
		this.hasierako_egoera = hasierako_egoera;
		this.konponenten_beharra = konponenten_beharra;
		this.bezeroa = bezeroa;
		this.azken_emaitza = azken_emaitza;
		this.proba_emaitza = proba_emaitza;
		this.konponenten_xehetasunak = konponenten_xehetasunak;
		this.konponenten_egoera = konponenten_egoera;
	
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getKonponentenBeharra() {
		return konponenten_beharra;
	}
	
	public void setKonponentenBeharra(String konponenten_beharra) {
		this.konponenten_beharra = konponenten_beharra;
	}
	
	public bezeroak getBezeroa() {
		return bezeroa;
	}
	
	public void setBezeroa(bezeroak bezeroa) {
		this.bezeroa = bezeroa;
	}
	
	public String getAzkenEmaitza() {
		return azken_emaitza;
	}
	
	public void setAzkenEmaitza(String azken_emaitza) {
		this.azken_emaitza = azken_emaitza;
	}
	
	public String getProbaEmaitza() {
		return proba_emaitza;
	}
	
	public void setProbaEmaitza(String proba_emaitza) {
		this.proba_emaitza = proba_emaitza;
	}
	
	public String getKonponentenXehetasunak() {
		return konponenten_xehetasunak;
	}
	
	public void setKonponentenXehetasunak(String konponenten_xehetasunak) {
		this.konponenten_xehetasunak = konponenten_xehetasunak;
	}
	
	public String getKonponentenEgoera() {
		return konponenten_egoera;
	}
	
	public void setKonponentenEgoera(String konponenten_egoera) {
		this.konponenten_egoera = konponenten_egoera;
	}
}
