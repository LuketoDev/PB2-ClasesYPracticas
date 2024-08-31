package ar.edu.unlam.pb2.dominio.practica.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

	private String pantente; // String porque puede tener letras
	private Integer pesoMaximo; // en kg
	private Integer pesoActual;
	private Integer capacidadMaximaDePasajeros;
	private List<Pasajero> pasajeros;

	public Vehiculo(String patente, Integer pesoMaximo, Integer capacidadMaximaDePasajeros) {
		// TODO Auto-generated constructor stub
		this.pantente = patente;
		this.pesoMaximo = pesoMaximo;
		this.pesoActual = 0;
		this.capacidadMaximaDePasajeros = capacidadMaximaDePasajeros;
		this.pasajeros = new ArrayList<>();
		
	}

	public String getPatente() {
		// TODO Auto-generated method stub
		return this.pantente;
	}

	public Integer obtenerPesoMaximo() {
		// TODO Auto-generated method stub
		return this.pesoMaximo;
	}

	public Integer obtenerCapacidadMaximaDePasajeros() {
		// TODO Auto-generated method stub
		return this.capacidadMaximaDePasajeros;
	}

	public void cargarPasajeros(List<Pasajero> pasajerosASubir) {
		
		for (Pasajero pasajero : pasajerosASubir) {
			
			this.cargarPasajero(pasajero);
			
		}
		
	}
	
	public Boolean cargarPasajero(Pasajero pasajeroASubir) {
		return this.pasajeros.add(pasajeroASubir);
	}

	public List<Pasajero> getPasajeros() {
		// TODO Auto-generated method stub
		return this.pasajeros;
	}

	public Integer getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(Integer pesoActual) {
		this.pesoActual = pesoActual;
	}
	
	

	

}
