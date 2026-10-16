package taller2;

public class Consumo {
	
	protected String consumidor;
	protected String fecha;
	
	public Consumo(String consumidor, String fecha) {
		super();
		this.consumidor = consumidor;
		this.fecha = fecha;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(String consumidor) {
		this.consumidor = consumidor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public double calcularCalorias() {
		return 0;
	}

	
	public String getTipo() {
	    return "Consumo";
	}
	
}
