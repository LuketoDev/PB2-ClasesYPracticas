package ar.edu.unlam.pb2.dominio.practica;

public class Avion extends Vehiculo {
	
	private static final Integer ACELERACION_AVION = 100;
	private static final Integer FRENADO_AVION = 100;

	public Avion(Integer velocidadActual, String modelo, String color, Integer velocidadMaxima) {
		super(velocidadActual, modelo, color, velocidadMaxima);
			
	}
	
	@Override
	public Boolean acelerar() {
		
		if (this.getVelocidadActual() < this.getVelocidadMaxima()) {
		
			this.setVelocidadActual(this.getVelocidadActual() + ACELERACION_AVION);  
			
			return true;
			
		}
	
		return false;
	}
	
	@Override
	public Boolean frenar() {
		
		if (this.getVelocidadActual() > 0) {
			
			this.setVelocidadActual(this.getVelocidadActual() - FRENADO_AVION);
			
			return true;
			
		}
		
		return false;
	}

}
