package ar.edu.unlam.pb2.dominio.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class VehiculoTest {
	
	private static final Integer VELOCIDAD_MAXIMA_AUTO = 100;
	private static final Integer VELOCIDAD_MAXIMA_AVION = 1000;
	private static final Integer VELOCIDAD_MAXIMA_MOTO_DE_AGUA = 10;

	private static final Integer VELOCIDAD_DE_VEHICULO_QUIETO = 0;
	
	private Integer velocidadActual;
	private String modelo;
	private String color;
	private Integer velocidadMaxima;
	
	private Vehiculo auto;
	private Vehiculo avion;
	private Vehiculo motoDeAgua;
	
	
	@Before
	public void init() {
		
		// valores genericos para los atributos en comun de los vehiculos
		
		this.modelo = "1";
		this.color = "rojo";
		
		// init del auto
		
		this.velocidadActual = VELOCIDAD_DE_VEHICULO_QUIETO;
		this.velocidadMaxima = VELOCIDAD_MAXIMA_AUTO;
		
		this.auto = new Auto(velocidadActual, modelo, color, velocidadMaxima);
		
		// init del avion
		
		this.velocidadActual = VELOCIDAD_DE_VEHICULO_QUIETO;
		this.velocidadMaxima = VELOCIDAD_MAXIMA_AVION;
		
		this.avion = new Avion(velocidadActual, modelo, color, velocidadMaxima);
		
		// init de la motoDeAgua
		
		this.velocidadActual = VELOCIDAD_DE_VEHICULO_QUIETO;
		this.velocidadMaxima = VELOCIDAD_MAXIMA_MOTO_DE_AGUA;
				
		this.motoDeAgua = new MotoDeAgua(velocidadActual, modelo, color, velocidadMaxima);
		
		
		
	}
	
	// Auto
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoAcelerarEntoncesAcelera() {
		
		// Preparacion
		
		// echa en el init();
		
		// Ejecucion

		Boolean pudoAcelerar = auto.acelerar();
		
		// Verificacion
		
		assertTrue(pudoAcelerar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoAcelerarEntoncesSuVelocidadAumentaA10() {
		
		// Preparacion
		
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
		
		auto.setVelocidadActual(VELOCIDAD_MAXIMA_AUTO);
	
		// Ejecucion

		Boolean pudoAcelerar = auto.acelerar();
		
		// Verificacion
		
		assertFalse(pudoAcelerar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoQueEstaYaQuietoCuandoLePidoFrenarEntoncesNoFrena() {
		
		// Preparacion
		
		auto.setVelocidadActual(VELOCIDAD_DE_VEHICULO_QUIETO);
		
		// Ejecucion

		Boolean pudoFrenar = auto.frenar();
		
		// Verificacion
		
		assertFalse(pudoFrenar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoConUnaVelocidadMayorA0CuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDelAuto = 10;
		
		auto.setVelocidadActual(velocidadActualDelAuto);
		
		// Ejecucion

		Boolean pudoFrenar = auto.frenar();
		
		// Verificacion
		
		assertTrue(pudoFrenar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAutoCuandoLePidoFrenarEntoncesSuVelocidadDisminuye10() {
		
		// Preparacion
		
		auto.setVelocidadActual(VELOCIDAD_MAXIMA_AUTO);
		
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
		
		// echa en el init();
		
		// Ejecucion

		Boolean pudoAcelerar = avion.acelerar();
		
		// Verificacion
		
		assertTrue(pudoAcelerar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionCuandoLePidoAcelerarEntoncesSuVelocidadAumentaA100() {
		
		// Preparacion
		
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
		
		avion.setVelocidadActual(VELOCIDAD_MAXIMA_AVION);
	
		// Ejecucion

		Boolean pudoAcelerar = avion.acelerar();
		
		// Verificacion
		
		assertFalse(pudoAcelerar);
		
	}
	
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionQueEstaYaQuietoCuandoLePidoFrenarEntoncesNoFrena() {
		
		// Preparacion
		
		avion.setVelocidadActual(VELOCIDAD_DE_VEHICULO_QUIETO);
		
		// Ejecucion

		Boolean pudoFrenar = avion.frenar();
		
		// Verificacion
		
		assertFalse(pudoFrenar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionConUnaVelocidadMayorA0CuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 100;
		
		avion.setVelocidadActual(velocidadActualDelAvion);
		
		// Ejecucion

		Boolean pudoFrenar = avion.frenar();
		
		// Verificacion
		
		assertTrue(pudoFrenar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnAvionConVelocidad200CuandoLePidoFrenarEntoncesSuVelocidadDisminuye100() {
		
		// Preparacion
		
		Integer velocidadActualDelAvion = 200;
		
		avion.setVelocidadActual(velocidadActualDelAvion);
	
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
		
		// Hecha en el init();
		
		// Ejecucion

		Boolean pudoAcelerar = motoDeAgua.acelerar();
		
		// Verificacion
		
		assertTrue(pudoAcelerar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaCuandoLePidoAcelerarEntoncesSuVelocidadAumentaA1() {
		
		// Preparacion
		
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
		
		motoDeAgua.setVelocidadActual(VELOCIDAD_MAXIMA_MOTO_DE_AGUA);
		
		// Ejecucion

		Boolean pudoAcelerar = motoDeAgua.acelerar();
		
		// Verificacion
		
		assertFalse(pudoAcelerar);
		
	}
	
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaQueEstaYaQuietoCuandoLePidoFrenarEntoncesNoFrena() {
		
		// Preparacion
		
		motoDeAgua.setVelocidadActual(VELOCIDAD_DE_VEHICULO_QUIETO);
		
		// Ejecucion

		Boolean pudoFrenar = motoDeAgua.frenar();
		
		// Verificacion
		
		assertFalse(pudoFrenar);
		
	}
	
	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaConUnaVelocidadMayorA0CuandoLePidoFrenarEntoncesFrena() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 1;
		
		motoDeAgua.setVelocidadActual(velocidadActualDeLaMotoDeAgua);
		
		// Ejecucion

		Boolean pudoFrenar = motoDeAgua.frenar();
		
		// Verificacion
		
		assertTrue(pudoFrenar);
		
	}

	@Test
	public void dadoQueExisteUnVehiculoQueEsUnaMotoDeAguaConVelocidad2CuandoLePidoFrenarEntoncesSuVelocidadDisminuye1() {
		
		// Preparacion
		
		Integer velocidadActualDeLaMotoDeAgua = 2;
		
		motoDeAgua.setVelocidadActual(velocidadActualDeLaMotoDeAgua);
		
		motoDeAgua.frenar();
		
		// Ejecucion
		
		Integer velocidadActualDeLaMotoDeAguaObtenida = motoDeAgua.getVelocidadActual();
		
		// Verificacion
		
		Integer velocidadActualDeLaMotoDeAguaEsperada = 1;
		
		assertEquals(velocidadActualDeLaMotoDeAguaEsperada, velocidadActualDeLaMotoDeAguaObtenida);
	
		
	}
	
}
