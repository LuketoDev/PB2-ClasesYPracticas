package ar.edu.unlam.pb2.dominio.practica.ejercicio4;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class SistemaDeControlDeInventarioTest {
	
	@Test
	public void dadoQueExisteUnProductoPerecederoConPrecioUnitarioInicialDe100CuandoPreguntoPorSuPrecioUnitarioAEsteSeLeAplica5PorcientoDeAgregadoEntoncesElPrecioUnitarioFinalEsDe105() {
		
		//Preparacion
		
		String nombre = "Leche";
		Integer cantidad = 1;
		Double precioUnitario = 100D;
		LocalDate fechaDeVencimiento = LocalDate.parse("2024-10-05");
		
		Producto productoPerecedero = new ProductoPerecedero(nombre, cantidad, precioUnitario, fechaDeVencimiento);
		
		// Ejecucion
		
		Double precioUnitarioFinalObtenido = productoPerecedero.obtenerPrecio();
		
		// Verificacion
		
		Double precioUnitarioFinalEsperado = 105D;
		
		assertEquals(precioUnitarioFinalEsperado, precioUnitarioFinalObtenido);
		
	}
	
	@Test
	public void dadoQueExisteUnProductoNoPerecederoConPrecioUnitarioInicialDe100CuandoPreguntoPorSuPrecioUnitarioAEsteSeLeAplica7PorcientoDeAgregadoEntoncesElPrecioUnitarioFinalEsDe107() {
		
		//Preparacion
		
		String nombre = "Lampara de mesa";
		Integer cantidad = 1;
		Double precioUnitario = 100D;
		String garantia = "6 meses";
		
		Producto productoNoPerecedero = new ProductoNoPerecedero(nombre, cantidad, precioUnitario, garantia);
		
		// Ejecucion
		
		Double precioUnitarioFinalObtenido = productoNoPerecedero.obtenerPrecio();
		
		// Verificacion
		
		Double precioUnitarioFinalEsperado = 107D;
		
		assertEquals(precioUnitarioFinalEsperado, precioUnitarioFinalObtenido);
		
	}

}
