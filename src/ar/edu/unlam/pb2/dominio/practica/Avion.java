package ar.edu.unlam.pb2.dominio.practica;

public class Avion extends Vehiculo {
	
	public Avion(Integer velocidadActual, String modelo, String color, Integer velocidadMaxima) {
		super(velocidadActual, modelo, color, velocidadMaxima);
			
	}
	
	@Override
	public Boolean acelerar() {
		
		return null;
	}
	
	@Override
	public Boolean frenar() {
		return null;
	}

}
