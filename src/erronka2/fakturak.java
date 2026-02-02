package erronka2;

import java.time.LocalDate;

public class fakturak {
	
	private int id;
	private bezeroak bezeroa;
	private LocalDate data;
	private double totala;
	
	public fakturak(int id) {
		this.id = id;
	}
	
	public fakturak(int id, bezeroak bezeroa, LocalDate data, double totala) {
		this.id = id;
		this.bezeroa = bezeroa;
		this.data = data;
		this.totala = totala;
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
