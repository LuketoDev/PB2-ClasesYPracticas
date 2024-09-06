package ar.edu.unlam.pb2.dominio.practica;

public class Auto extends Vehiculo{

	private static final int ACELERACION_AUTO = 10;
	private static final int FRENADO_AUTO = 10;

	public Auto(Integer velocidadActual, String modelo, String color, Integer velocidadMaxima) {
		super(velocidadActual, modelo, color, velocidadMaxima);
			
	}
	
	@Override
	public Boolean acelerar() {
		
		if (this.getVelocidadActual() < this.getVelocidadMaxima()) {
		
			this.setVelocidadActual(this.getVelocidadActual() + ACELERACION_AUTO);  
			
			return true;
			
		}
	
		return false;
	}
	
	@Override
	public Boolean frenar() {
		
		if (this.getVelocidadActual() > 0) {
			
			this.setVelocidadActual(this.getVelocidadActual() - FRENADO_AUTO);
			
			return true;
			
		}
		
		return false;
	}
	
}
