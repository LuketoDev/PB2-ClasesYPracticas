package ar.edu.unlam.pb2.dominio.practica.ejercicio4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		
		Double epsilon = 0.0001D;  // Margen de error permitido
		
		assertEquals(precioUnitarioFinalEsperado, precioUnitarioFinalObtenido, epsilon);
		
	}
	
	@Test
	public void dadoQueExisteUnProductoNoPerecederoConPrecioUnitarioInicialDe0Con1Y200DeCantidadCuandoPreguntoPorSuPrecioUnitarioAEsteSeLeAplica7PorcientoDeAgregadoEntoncesElPrecioUnitarioFinalEsDe21con40() {
		
		//Preparacion
		
		String nombre = "CajaDeTornillos";
		Integer cantidad = 200;
		Double precioUnitario = 0.1D;
		String garantia = "6 meses";
		
		Producto productoNoPerecedero = new ProductoNoPerecedero(nombre, cantidad, precioUnitario, garantia);
		
		// Ejecucion
		
		Double precioUnitarioFinalObtenido = productoNoPerecedero.obtenerPrecio();
		
		// Verificacion
		
		Double precioUnitarioFinalEsperado = 21.40D;
		
		Double epsilon = 0.0001D;  // Margen de error permitido
		
		assertEquals(precioUnitarioFinalEsperado, precioUnitarioFinalObtenido, epsilon);
		
	}
	
	@Test
	public void dadoQueExisteUnaTiendaConProductosCuandoIntentoAgregarUnProductoALaListaEntoncesLoAgrega() {
	
		// Preparacion
		SistemaDeControlDeInventario tienda = new SistemaDeControlDeInventario();
		
		Producto producto = new Producto("Iphone 8", 1, 100D);
	
		// Ejecucion
		
		Boolean seAgrego = tienda.agregarProducto(producto);
		
		// Verificacion
		
		assertTrue(seAgrego);
		
	}
	
	
	@Test
	public void dadoQueExisteUnaTiendaCon2ProductosPerecederosConPrecioUnitario100Y1EnCantidadY1NoPedecederoDe50Y2EnCantidadCuandoLePidoALaTiendaElValorTotalDeLosProductosQueContieneConElPorcentajeAgregadoDeCadaUnoEntoncesObtengo307() {
	
		// Preparacion
		SistemaDeControlDeInventario tienda = new SistemaDeControlDeInventario();
		
		Producto productoPerecedero1 = new ProductoPerecedero("Leche", 1, 100D, LocalDate.parse("2024-09-02"));
		Producto productoPerecedero2 = new ProductoPerecedero("Bebida Energetica", 1, 100D, LocalDate.parse("2025-09-30"));
		Producto productoNoPerecedero = new ProductoNoPerecedero("Heladera", 2, 50D, "12 meses");
		
		tienda.agregarProducto(productoPerecedero1);
		tienda.agregarProducto(productoPerecedero2);
		tienda.agregarProducto(productoNoPerecedero);
		
		// Ejecucion
		
		Double precioTotalObtenido = tienda.obtenerElPrecioTotalDeTodosLosProductos();
		
		// Verificacion
		
		Double precioTotalEsperado = 317D;
		Double margenAceptable = 0.0001D;
		
		assertEquals(precioTotalEsperado, precioTotalObtenido, margenAceptable);
		
	}
	
	@Test
	public void dadoQueExisteUnaTiendaCon2ProductosPerecederosConPrecioUnitario100Y1EnCantidadY1NoPedecederoDe50Y2EnCantidadCuandoLePidoALaTiendaElValorTotalDeLosProductosPerecederosQueContieneConElPorcentajeAgregadoDeCadaUnoEntoncesObtengo110() {
		
		// Preparacion
		SistemaDeControlDeInventario tienda = new SistemaDeControlDeInventario();
		
		Producto productoPerecedero1 = new ProductoPerecedero("Leche", 1, 100D, LocalDate.parse("2024-09-02"));
		Producto productoPerecedero2 = new ProductoPerecedero("Bebida Energetica", 1, 100D, LocalDate.parse("2025-09-30"));
		Producto productoNoPerecedero = new ProductoNoPerecedero("Heladera", 2, 50D, "12 meses");
		
		tienda.agregarProducto(productoPerecedero1);
		tienda.agregarProducto(productoPerecedero2);
		tienda.agregarProducto(productoNoPerecedero);
		
		// Ejecucion
		
		Double precioTotalObtenido = tienda.obtenerElPrecioTotalDeTodosLosProductosPerecederos();
		
		// Verificacion
		
		Double precioTotalEsperado = 210D;
		Double margenAceptable = 0.0001D;
		
		assertEquals(precioTotalEsperado, precioTotalObtenido, margenAceptable);
		
	}
	
	@Test
	public void dadoQueExisteUnaTiendaCon2ProductosPerecederosConPrecioUnitario100Y1EnCantidadY1NoPedecederoDe50Y2EnCantidadCuandoLePidoALaTiendaElValorTotalDeLosProductosNoPerecederosQueContieneConElPorcentajeAgregadoDeCadaUnoEntoncesObtengo107() {
		
		// Preparacion
		
		SistemaDeControlDeInventario tienda = new SistemaDeControlDeInventario();
		
		Producto productoPerecedero1 = new ProductoPerecedero("Leche", 1, 100D, LocalDate.parse("2024-09-02"));
		Producto productoPerecedero2 = new ProductoPerecedero("Bebida Energetica", 1, 100D, LocalDate.parse("2025-09-30"));
		Producto productoNoPerecedero = new ProductoNoPerecedero("Heladera", 2, 50D, "12 meses");
		
		tienda.agregarProducto(productoPerecedero1);
		tienda.agregarProducto(productoPerecedero2);
		tienda.agregarProducto(productoNoPerecedero);
		
		// Ejecucion
		
		Double precioTotalObtenido = tienda.obtenerElPrecioTotalDeTodosLosProductosNoPerecederos();
		
		// Verificacion
		
		Double precioTotalEsperado = 107D;
		Double margenAceptable = 0.0001D;
		
		assertEquals(precioTotalEsperado, precioTotalObtenido, margenAceptable);
		
	}
	
	
	
}
