package ar.edu.unlam.pb2.dominio.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VehiculoTest {
	
	// Auto
	
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
	public void dadoQueExisteUnVehiculoQueEsUnAutoQueEstaYaQuietoCuandoLePidoFrenarEntoncesNoFrena() {
		
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
	public void dadoQueExisteUnVehiculoQueEsUnAutoConUnaVelocidadMayorA0CuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 10;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 1000;
		
		Auto auto = new Auto(velocidadActualDelAuto, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoFrenar = auto.frenar();
		
		// Verificacion
		
		assertTrue(pudoFrenar);
		
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
	
	// Avion
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionCuandoLePidoAcelerarEntoncesAcelera() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 100;
		
		Avion avion = new Avion(velocidadActualDelAvion, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoAcelerar = avion.acelerar();
		
		// Verificacion
		
		assertTrue(pudoAcelerar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionCuandoLePidoAcelerarEntoncesSuVelocidadAumentaA100() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 1000;
		
		Avion avion = new Avion(velocidadActualDelAvion, modelo, color, velocidadMaxima);
		
		avion.acelerar();
		
		// Ejecucion
		
		
		Integer velocidadActualDelAvionObtenida = avion.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDelAvionEsperada = 100;
		
		assertEquals(velocidadActualDelAvionEsperada, velocidadActualDelAvionObtenida);
	
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionEnSuMaximaVelocidadCuandoLePidoAcelerarEntoncesNoPuede() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 1000;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 1000;
		
		Avion avion = new Avion(velocidadActualDelAvion, modelo, color, velocidadMaxima);
	
		// Ejecucion

		Boolean pudoAcelerar = avion.acelerar();
		
		// Verificacion
		
		assertFalse(pudoAcelerar);
		
	}
	
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionQueEstaYaQuietoCuandoLePidoFrenarEntoncesNoFrena() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 1000;
		
		Avion avion = new Avion(velocidadActualDelAvion, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoFrenar = avion.frenar();
		
		// Verificacion
		
		assertFalse(pudoFrenar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionConUnaVelocidadMayorA0CuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 10;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 1000;
		
		Avion avion = new Avion(velocidadActualDelAvion, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoFrenar = avion.frenar();
		
		// Verificacion
		
		assertTrue(pudoFrenar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionConVelocidad200CuandoLePidoFrenarEntoncesSuVelocidadDisminuye100() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 200;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 1000;
		
		Avion avion = new Avion(velocidadActualDelAvion, modelo, color, velocidadMaxima);
		
		avion.frenar();
		
		// Ejecucion
		
		Integer velocidadActualDelAvionObtenida = avion.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDelAvionEsperada = 100;
		
		assertEquals(velocidadActualDelAvionEsperada, velocidadActualDelAvionObtenida);
	
		
	}
	
	// Moto de Agua
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaCuandoLePidoAcelerarEntoncesAcelera() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 10;
		
		MotoDeAgua motoDeAgua = new MotoDeAgua(velocidadActualDeLaMotoDeAgua, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoAcelerar = motoDeAgua.acelerar();
		
		// Verificacion
		
		assertTrue(pudoAcelerar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaCuandoLePidoAcelerarEntoncesSuVelocidadAumentaA1() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 10;
		
		MotoDeAgua motoDeAgua = new MotoDeAgua(velocidadActualDeLaMotoDeAgua, modelo, color, velocidadMaxima);
		
		motoDeAgua.acelerar();
		
		// Ejecucion
		
		
		Integer velocidadActualDeLaMotoDeAguaObtenida = motoDeAgua.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDeLaMotoDeAguaEsperada = 1;
		
		assertEquals(velocidadActualDeLaMotoDeAguaEsperada, velocidadActualDeLaMotoDeAguaObtenida);
	
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaEnSuMaximaVelocidadCuandoLePidoAcelerarEntoncesNoPuede() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 10;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 10;
		
		MotoDeAgua motoDeAgua = new MotoDeAgua(velocidadActualDeLaMotoDeAgua, modelo, color, velocidadMaxima);
	
		// Ejecucion

		Boolean pudoAcelerar = motoDeAgua.acelerar();
		
		// Verificacion
		
		assertFalse(pudoAcelerar);
		
	}
	
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaQueEstaYaQuietoCuandoLePidoFrenarEntoncesNoFrena() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 0;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 10;
		
		MotoDeAgua motoDeAgua = new MotoDeAgua(velocidadActualDeLaMotoDeAgua, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoFrenar = motoDeAgua.frenar();
		
		// Verificacion
		
		assertFalse(pudoFrenar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaConUnaVelocidadMayorA0CuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 10;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 10;
		
		MotoDeAgua motoDeAgua = new MotoDeAgua(velocidadActualDeLaMotoDeAgua, modelo, color, velocidadMaxima);
		
		// Ejecucion

		Boolean pudoFrenar = motoDeAgua.frenar();
		
		// Verificacion
		
		assertTrue(pudoFrenar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaConVelocidad2CuandoLePidoFrenarEntoncesSuVelocidadDisminuye1() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 2;
		String modelo = "1"; 
		String color = "rojo";
		Integer velocidadMaxima = 10;
		
		MotoDeAgua motoDeAgua = new MotoDeAgua(velocidadActualDeLaMotoDeAgua, modelo, color, velocidadMaxima);
		
		motoDeAgua.frenar();
		
		// Ejecucion
		
		Integer velocidadActualDeLaMotoDeAguaObtenida = motoDeAgua.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDeLaMotoDeAguaEsperada = 1;
		
		assertEquals(velocidadActualDeLaMotoDeAguaEsperada, velocidadActualDeLaMotoDeAguaObtenida);
	
		
	}
	
}
