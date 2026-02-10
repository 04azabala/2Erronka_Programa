package erronka2;

import java.time.LocalDate;

public class saskia {
	
	private int id;
	private bezeroak bezeroak;
	private hornitzaileak hornitzaile;
	private produktuak produktuak;
	private fakturak faktura;
	private double totala;
	private LocalDate data;
	private int zenbatekoa;
	
	public saskia(int id, bezeroak bezeroak, hornitzaileak hornitzaile , produktuak produktuak, fakturak faktura , double totala,LocalDate data, int zenbatekoa) {
		this.id = id;
		this.bezeroak = bezeroak;
		this.hornitzaile = hornitzaile;
		this.produktuak = produktuak;
		this.faktura = faktura;
		this.totala = totala;
		this.data = data;
		this.zenbatekoa = zenbatekoa;		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public produktuak getProduktuak() {
		return produktuak;
	}
	
	public void setProduktuak(produktuak produktuak) {
		this.produktuak = produktuak;
	}
	
	public bezeroak getBezeroak() {
		return bezeroak;
	}
	
	public void setBezeroak(bezeroak bezeroak) {
		this.bezeroak = bezeroak;
	}
	
	public hornitzaileak getHornitzaile() {
		return hornitzaile;
	}
	
	public void setHornitzaile(hornitzaileak hornitzaile) {
		this.hornitzaile = hornitzaile;
	}
	
	public fakturak getFaktura() {
		return faktura;
	}
	
	public void setFaktura(fakturak faktura) {
		this.faktura = faktura;
	}
	
	public double getTotala() {
		return totala;
	}
	
	public void setTotala(double totala) {
		this.totala = totala;
	}
	
	public int getZenbatekoa() {
		return zenbatekoa;
	}
	
	public void setZenbatekoa(int zenbatekoa) {
		this.zenbatekoa = zenbatekoa;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}

}
