package ar.edu.unlam.pb2.dominio.practica.ejercicio2;

public class ProductoRopa extends Producto {
	
	private static final Double PORCENTAJE_RECARGO_PRODUCTO_ROPA = 5D;

	public ProductoRopa(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
	}
	
	@Override
	public Double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return this.getPrecio() + ((this.getPrecio() * PORCENTAJE_RECARGO_PRODUCTO_ROPA) / 100); 
	}

}
