package erronka2;

import java.time.LocalDate;

public class fakturak {
	
	private int id;
	private bezeroak bezeroa;
	private hornitzaileak hornitzaile;
	private produktuak produktu;
	private saskia saski;
	private LocalDate data;
	private double totala;
	private int zenbatekoa;
	
	public fakturak(int id) {
		this.id = id;
	}
	
	public fakturak(int id, bezeroak bezeroa, hornitzaileak hornitzaile, produktuak produktu , saskia saski, LocalDate data, double totala, int zenbatekoa) {
		this.id = id;
		this.bezeroa = bezeroa;
		this.hornitzaile = hornitzaile;
		this.produktu = produktu;
		this.saski = saski;
		this.data = data;
		this.totala = totala;
		this.zenbatekoa = zenbatekoa;
	}
	
	public int getZenbatekoa() {
		return zenbatekoa;
	}
	
	public void setZenbatekoa(int zenbatekoa) {
		this.zenbatekoa = zenbatekoa;
	}
	
	public produktuak getProduktu() {
		return produktu;
	}
	
	public void setProduktu(produktuak produktu) {
		this.produktu = produktu;
	}
	
	public saskia getSaskia() {
		return saski;
	}
	
	public void setSaskia(saskia saski) {
		this.saski = saski;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public bezeroak getBezeroa() {
		return bezeroa;
	}
	
	public void setBezeroa(bezeroak bezeroa) {
		this.bezeroa = bezeroa;
	}
	
	public hornitzaileak getHornitzailea() {
		return hornitzaile;
	}
	
	public void setHornitzailea(hornitzaileak hornitzaile) {
		this.hornitzaile = hornitzaile;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public double getTotala() {
		return totala;
	}
	
	public void setTotala(double totala) {
		this.totala = totala;	
	}
	
	public String toString() {
		return String.valueOf(id);
	}
}
