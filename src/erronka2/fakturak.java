package erronka2;

import java.time.LocalDate;

public class fakturak {
	
	private int id;
	private LocalDate data;
	private double totala;
	
	public fakturak(int id, LocalDate data, double totala) {
		this.id = id;
		this.data = data;
		this.totala = totala;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
}
