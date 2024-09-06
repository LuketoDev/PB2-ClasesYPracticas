package ar.edu.unlam.pb2.dominio.practica;

public abstract class Vehiculo {

	private Integer velocidadActual;
	private String modelo;
	private String color;
	private Integer velocidadMaxima;
	
	
	public Vehiculo(Integer velocidadActual, String modelo, String color, Integer velocidadMaxima) {
		this.velocidadActual = velocidadActual;
		this.modelo = modelo;
		this.color = color;
		this.velocidadMaxima = velocidadMaxima;
	}

	
	// Metodos abstractos -> hacen que la clase sea abstracta
	
	public abstract Boolean acelerar();
	
	public abstract Boolean frenar();
	
	/////////////////////////////////////////////////////////
	
	// Metodos normales -> seran heredados con su comportamiento fijo a las subclases
	
	public Integer getVelocidadActual() {
		return velocidadActual;
	}

	
	public void setVelocidadActual(Integer velocidadActual) {
		this.velocidadActual = velocidadActual;
	}


	public String getModelo() {
		return modelo;
	}

	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public String getColor() {
		return color;
	}

	
	public void setColor(String color) {
		this.color = color;
	}

	
	public Integer getVelocidadMaxima() {
		return velocidadMaxima;
	}

	
	public void setVelocidadMaxima(Integer velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	
	
	
}
