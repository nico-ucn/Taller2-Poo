package taller2;

public class Terremoto extends Consumo{
	
	private double litros;

	public Terremoto(String consumidor, String fecha, double litros) {
		super(consumidor, fecha);
		this.litros = litros;
	}

	public double getLitros() {
		return litros;
	}
	
	
	@Override
    public double calcularCalorias() {
        return (litros * 10) / 3.0;
    }

	@Override
	public String getTipo() {
	    return "Terremoto";
	}
}
