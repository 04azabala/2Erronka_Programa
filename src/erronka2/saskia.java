package erronka2;

import java.time.LocalDate;

public class saskia {
	
	private int id;
	private bezeroak bezeroak;
	private produktuak produktuak;
	private fakturak faktura;
	private double totala;
	private int zenbatekoa;
	private LocalDate data;
	
	public saskia(int id, bezeroak bezeroak, produktuak produktuak, fakturak faktura , double totala,LocalDate data, int zenbatekoa) {
		this.id = id;
		this.bezeroak = bezeroak;
		this.produktuak = produktuak;
		this.faktura = faktura;
		this.totala = totala;
		this.zenbatekoa = zenbatekoa;
		this.data = data;
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
