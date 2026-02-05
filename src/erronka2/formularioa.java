package erronka2;

public class formularioa {
	
	private int id;
	private String bezero_mota;
	private String izena;
	private String abizena;
	private String harremanetako_pertsona;
	private String posta_elektronikoa;
	private String telefonoa;
	private String enpresaren_izena;
	private String produktu_mota;
	private String produktu_marka;
	private String produktua;
	private int produktu_kopurua;
	private String produktuaren_deskribapena;
	private String oharrak;
	
	
	public formularioa(int id, String bezero_mota, String izena, String abizena, String harremanetako_pertsona, String posta_elektronikoa, String telefonoa, String enpresaren_izena, String produktu_mota, String produktu_marka, String produktua, int produktu_kopurua, String produktuaren_deskribapena, String oharrak) {
		this.id = id;
		this.bezero_mota = bezero_mota;
		this.izena = izena;
		this.abizena = abizena;
		this.harremanetako_pertsona = harremanetako_pertsona;
		this.posta_elektronikoa = posta_elektronikoa;
		this.telefonoa = telefonoa;
		this.enpresaren_izena = enpresaren_izena;
		this.produktu_mota = produktu_mota;
		this.produktu_marka = produktu_marka;
		this.produktua = produktua;
		this.produktu_kopurua = produktu_kopurua;
		this.produktuaren_deskribapena = produktuaren_deskribapena;
		this.oharrak = oharrak;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBezeroMota() {
		return bezero_mota;
	}
	
	public void setBezeroMota(String bezero_mota) {
		this.bezero_mota = bezero_mota;
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
	
	public String getHerramanetakoPertsona() {
		return harremanetako_pertsona;
	}
	
	public void setHarremanetakoPersona(String harremanetako_pertsona) {
		this.harremanetako_pertsona = harremanetako_pertsona;
	}
	
	public String getPostaElektronikoa() {
		return posta_elektronikoa;
	}
	
	public void setPostaElektronikoa(String posta_elektronikoa) {
		this.posta_elektronikoa = posta_elektronikoa;
	}
	
	public String getTelefonoa() {
		return telefonoa;
	}
	
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	public String getEnpresarenIzena() {
		return enpresaren_izena;
	}
	
	public void setEnpresarenIzena(String enpresaren_izena) {
		this.enpresaren_izena = enpresaren_izena;
	}
	
	public String getProduktuMota() {
		return produktu_mota;
	}
	
	public void setProduktuMota(String produktu_mota) {
		this.produktu_mota = produktu_mota;
	}
	
	public String getProduktuMarka() {
		return produktu_marka;
	}
	
	public void setProduktuMarka(String produktu_marka) {
		this.produktu_marka = produktu_marka;
	}
	
	public String getProduktua() {
		return produktua;
	}
	
	public void setProduktua(String produktua) {
		this.produktua = produktua;
	}
	
	public int getProduktuKopurua() {
		return produktu_kopurua;
	}
	
	public void setProduktuKopurua(int produktu_kopurua) {
		this.produktu_kopurua = produktu_kopurua;
	}
	
	public String getProduktuarenDeskribapena() {
		return produktuaren_deskribapena;
	}
	
	public void setProduktuarenDeskribapena(String produktuaren_deskribapena) {
		this.produktuaren_deskribapena = produktuaren_deskribapena;
	}
	
	public String getOharrak() {
		return oharrak;
	}
	
	public void setOharrak(String oharrak) {
		this.oharrak = oharrak;
	}
	

}
