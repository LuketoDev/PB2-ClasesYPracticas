package ar.edu.unlam.pb2.dominio.practica.ejercicio1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SistemaDeTransporteTest {
	
	
	@Test
	public void dadoQueExisteUnVehiculoConPatente123PesoMaximo20kgYCapacidadDeCargaDe4PersonasCuandoPreguntoPorLasCaracteristicasDelVehiculoEntoncesMeDevuelveLosValoresYaDichos() {
		
		// Preparacion
		
		String patente = "123";
		Integer pesoMaximo = 20;
		Integer capacidadMaximaDePasajeros = 4;
		
		Vehiculo vehiculo = new Vehiculo (patente, pesoMaximo, capacidadMaximaDePasajeros);
		
		// Ejecucion
		
		String patenteObtenida = vehiculo.getPatente();
		Integer pesoMaximoObtenido = vehiculo.obtenerPesoMaximo();
		Integer capacidadMaximaDePasajerosObtenidos = vehiculo.obtenerCapacidadMaximaDePasajeros();
		
		// Verificacion
		
		assertEquals(patente, patenteObtenida);
		assertEquals(pesoMaximo, pesoMaximoObtenido);
		assertEquals(capacidadMaximaDePasajeros, capacidadMaximaDePasajerosObtenidos);
	}
	
	@Test
	public void dadoQueExisteUnVehiculoCuandoSubo1PasajeroEntoncesElPasajeroSePuedeSubir() {
		
		// Preparacion
		
		String patente = "123";
		Integer pesoMaximo = 20;
		Integer capacidadMaximaDePasajeros = 4;
		
		Vehiculo vehiculo = new Vehiculo (patente, pesoMaximo, capacidadMaximaDePasajeros);
		
		Pasajero pasajeroASubir = new Pasajero(20);
		
		// Ejecucion
		
		Boolean sePudoSubir = vehiculo.cargarPasajero(pasajeroASubir);
		
		// Verificacion
		
		//Integer cantidadDePasajerosEsperados = 1;
		//assertEquals(cantidadDePasajerosEsperados, vehiculo.getPasajeros().size()); // caso raro, porque no funciona?
		
		assertTrue(sePudoSubir);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoCuandoSubo1PasajeroEntoncesElVehiculoTieneAdentro1Pasajero() {
		
		// Preparacion
		
		String patente = "123";
		Integer pesoMaximo = 20;
		Integer capacidadMaximaDePasajeros = 4;
		
		Vehiculo vehiculo = new Vehiculo (patente, pesoMaximo, capacidadMaximaDePasajeros);
		
		Pasajero pasajeroASubir = new Pasajero(20);
		
		// Ejecucion
		
		vehiculo.cargarPasajero(pasajeroASubir);
		
		// Verificacion
		
		//Integer cantidadDePasajerosEsperados = 1;
		//assertEquals(cantidadDePasajerosEsperados, vehiculo.getPasajeros().size()); // caso raro, porque no funciona?
		
		assertEquals(1, vehiculo.getPasajeros().size());
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoCuandoSubo2PasajerosEntoncesElVehiculoTieneAdentro2Pasajeros() {
		
		// Preparacion
		
		String patente = "123";
		Integer pesoMaximo = 20;
		Integer capacidadMaximaDePasajeros = 4;
		
		Vehiculo vehiculo = new Vehiculo (patente, pesoMaximo, capacidadMaximaDePasajeros);
		
		Pasajero pasajero1 = new Pasajero(20);
		Pasajero pasajero2 = new Pasajero(25);
		
		// hago lista porque es para desarrollar el metodo cargarPasajeros() del vehiculo (es en plurar asi que recibira una coleccion)
		List<Pasajero> pasajerosASubir = new ArrayList<>();
		
		pasajerosASubir.add(pasajero1);
		pasajerosASubir.add(pasajero2);
		
		
		// Ejecucion
		
		vehiculo.cargarPasajeros(pasajerosASubir);
	
		// Verificacion
		
		assertEquals(pasajerosASubir.size(), vehiculo.getPasajeros().size());
		
	}
	

}
