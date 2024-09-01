package ar.edu.unlam.pb2.dominio.practica.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeControlDeInventario {

	
	private List<Producto> productos;

	public SistemaDeControlDeInventario() {
		this.productos = new ArrayList<>();
	}

	public Boolean agregarProducto(Producto producto) {
		return this.productos.add(producto);
	}

	public Double obtenerElPrecioTotalDeTodosLosProductos() {
		
		Double precioTotalDeTodosLosProductos = 0D;
		
		for (Producto productoActual : this.productos) {
			precioTotalDeTodosLosProductos += productoActual.obtenerPrecio();
		}
		
		return precioTotalDeTodosLosProductos;
	}

	public Double obtenerElPrecioTotalDeTodosLosProductosPerecederos() {
		// TODO Auto-generated method stub
		
		Double precioTotalDeTodosLosProductosPerecederos = 0D;
		
		for (Producto productoActual : this.productos) {
			
			if(productoActual instanceof ProductoPerecedero) {
				precioTotalDeTodosLosProductosPerecederos += productoActual.obtenerPrecio();
			}
		
		}
		
		return precioTotalDeTodosLosProductosPerecederos;
	
	}

	public Double obtenerElPrecioTotalDeTodosLosProductosNoPerecederos() {
		Double precioTotalDeTodosLosProductosNoPerecederos = 0D;
		
		for (Producto productoActual : this.productos) {
			
			if(productoActual instanceof ProductoNoPerecedero) {
				precioTotalDeTodosLosProductosNoPerecederos += productoActual.obtenerPrecio();
			}
		
		}
		
		return precioTotalDeTodosLosProductosNoPerecederos;
	
	}

}
