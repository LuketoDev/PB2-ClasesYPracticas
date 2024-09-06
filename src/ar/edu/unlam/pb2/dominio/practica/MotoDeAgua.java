package ar.edu.unlam.pb2.dominio.practica;

public class MotoDeAgua extends Vehiculo{
	
	private static final Integer ACELERACION_MOTO_DE_AGUA = 1;
	private static final Integer FRENADO_MOTO_DE_AGUA = 1;
	
	public MotoDeAgua(Integer velocidadActual, String modelo, String color, Integer velocidadMaxima) {
		super(velocidadActual, modelo, color, velocidadMaxima);
			}
	
	@Override
	public Boolean acelerar() {
		
		if (this.getVelocidadActual() < this.getVelocidadMaxima()) {
		
			this.setVelocidadActual(this.getVelocidadActual() + ACELERACION_MOTO_DE_AGUA);  
			
			return true;
			
		}
	
		return false;
	}
	
	@Override
	public Boolean frenar() {
		
		if (this.getVelocidadActual() > 0) {
			
			this.setVelocidadActual(this.getVelocidadActual() - FRENADO_MOTO_DE_AGUA);
			
			return true;
			
		}
		
		return false;
	}

}
