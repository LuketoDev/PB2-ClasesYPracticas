package ar.edu.unlam.pb2.dominio.practica.ejercicio1;

import java.util.List;

public class Auto extends Vehiculo {

	public Auto(String patente, Integer pesoMaximo, Integer capacidadMaximaDePasajeros) {
		super(patente, pesoMaximo, capacidadMaximaDePasajeros);
	}
	

	@Override
	public Boolean cargarPasajero(Pasajero pasajeroASubir) {
		
		Boolean sePudoCargar = null;
		
		if (this.getPesoActual() + pasajeroASubir.getPeso() <= this.obtenerPesoMaximo() 
				&& this.getPasajeros().size() < this.obtenerCapacidadMaximaDePasajeros()) {
			
			sePudoCargar = this.getPasajeros().add(pasajeroASubir);
			this.setPesoActual(this.getPesoActual() + pasajeroASubir.getPeso());
			
		}
		return sePudoCargar;
	}
	
	@Override
	public void cargarPasajeros(List<Pasajero> pasajerosASubir) {
		
		for (Pasajero pasajero : pasajerosASubir) {
			
			this.cargarPasajero(pasajero);
			
		}
		
	}

}
