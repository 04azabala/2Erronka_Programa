package erronka2;

public class produktuak {
	
	private int id;
	private String izena;
	private double prezioa;
	private int stock;
	private String egoera;
	private String mota;
	
	public produktuak(int id, String izena, double prezioa, int stock, String egoera, String mota) {
		this.id = id;
		this.izena = izena;
		this.prezioa = prezioa;
		this.stock = stock;
		this.egoera = egoera;
		this.mota = mota;
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
	
	public double getPrezioa() {
		return prezioa;
	}
	
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getEgoera() {
		return egoera;
	}
	
	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}
	
	public String getMota() {
		return mota;
	}
	
	public void setMota(String mota) {
		this.mota = mota;
	}

}
