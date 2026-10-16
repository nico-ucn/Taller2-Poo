package taller2;

public class Choripan extends Consumo{
private int largo;
private int ancho;

public Choripan(String consumidor, String fecha, int largo, int ancho) {
	super(consumidor, fecha);
	this.largo = largo;
	this.ancho = ancho;
}

public int getLargo() {
	return largo;
}

public void setLargo(int largo) {
	this.largo = largo;
}

public int getAncho() {
	return ancho;
}

public void setAncho(int ancho) {
	this.ancho = ancho;
}

@Override
public double calcularCalorias() {
	return (largo*ancho)/3.0;
}

@Override
public String getTipo() {
    return "Choripan";
}


}
