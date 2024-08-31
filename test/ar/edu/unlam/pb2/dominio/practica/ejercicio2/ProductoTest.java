package ar.edu.unlam.pb2.dominio.practica.ejercicio2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductoTest {
	
	@Test
	public void dadoQueExisteUnProductoQueCuesta100YEsteEsElectronicoEntoncesCuandoConsultoPorSuPrecioFinalEs115() {
		
		// Preparacion
		
		String nombre = "Heladera";
		Double precio = 100D;
		String descripcion = "Modelo: 1234";
		
		Producto productoElectronico = new ProductoElectronico(nombre, precio, descripcion);
		
		// Ejecucion
		
		Double precioFinalObtenido =productoElectronico.calcularPrecioFinal();
		
		// Verificacion
		
		
		Double precioFinalEsperado = 115D;
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
		
	}
	
	@Test
	public void dadoQueExisteUnProductoQueCuesta100YEsteEsAlimenticioEntoncesCuandoConsultoPorSuPrecioFinalEs1107con5() {
		
		// Preparacion
		
		String nombre = "Caja de Patys";
		Double precio = 100D;
		String descripcion = "Marca: Paty | 4 unidades";
		
		Producto productoAlimenticio = new ProductoAlimenticio(nombre, precio, descripcion);
		
		// Ejecucion
		
		Double precioFinalObtenido = productoAlimenticio.calcularPrecioFinal();
		
		// Verificacion
		
		
		Double precioFinalEsperado = 1107.5D;
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
		
	}
	
	@Test
	public void dadoQueExisteUnProductoQueCuesta100YEsteEsDeRopaEntoncesCuandoConsultoPorSuPrecioFinalEs105() {
		
		// Preparacion
		
		String nombre = "Air Force 1";
		Double precio = 100D;
		String descripcion = "Marca: Nike | Calzado";
		
		Producto productoRopa = new ProductoRopa(nombre, precio, descripcion);
		
		// Ejecucion
		
		Double precioFinalObtenido = productoRopa.calcularPrecioFinal();
		
		// Verificacion
		
		Double precioFinalEsperado = 105D;
		
		assertEquals(precioFinalEsperado, precioFinalObtenido);
		
	}

}
