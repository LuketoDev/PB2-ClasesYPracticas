package ar.edu.unlam.pb2.dominio.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VehiculoTest {
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoAcelerarEntoncesAcelera() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 100;
		
		Auto auto = new Auto(velocidadActualDelAuto, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoAcelerar = auto.acelerar();
		
		// Verificacion
		
		assertTrue(pudoAcelerar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoAcelerarEntoncesSuVelocidadAumentaA10() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 100;
		
		Auto auto = new Auto(velocidadActualDelAuto, modelo, color, velocidadMaxima);
		
		auto.acelerar();
		
		// Ejecucion
		
		
		Integer velocidadActualDelAutoObtenida = auto.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDelAutoEsperada = 10;
		
		assertEquals(velocidadActualDelAutoEsperada, velocidadActualDelAutoObtenida);
	
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoEnSuMaximaVelocidadCuandoLePidoAcelerarEntoncesNoPuede() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 100;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 100;
		
		Auto auto = new Auto(velocidadActualDelAuto, modelo, color, velocidadMaxima);
	
		// Ejecucion

		Boolean pudoAcelerar = auto.acelerar();
		
		// Verificacion
		
		assertFalse(pudoAcelerar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 100;
		
		Auto auto = new Auto(velocidadActualDelAuto, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoFrenar = auto.frenar();
		
		// Verificacion
		
		assertFalse(pudoFrenar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoFrenarEntoncesSuVelocidadDisminuye10() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 100;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 100;
		
		Auto auto = new Auto(velocidadActualDelAuto, modelo, color, velocidadMaxima);
		
		auto.frenar();
		
		// Ejecucion
		
		Integer velocidadActualDelAutoObtenida = auto.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDelAutoEsperada = 90;
		
		assertEquals(velocidadActualDelAutoEsperada, velocidadActualDelAutoObtenida);
	
		
	}
	
}
