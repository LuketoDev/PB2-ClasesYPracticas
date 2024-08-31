package ar.edu.unlam.pb2.dominio.practica.ejercicio2;

public class ProductoElectronico extends Producto {

	private static final Double PORCENTAJE_RECARGO_PRODUCTO_ELECTRONICO = 15D;

	public ProductoElectronico(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
	}
	
	@Override
	public Double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return this.getPrecio() + ((this.getPrecio() * PORCENTAJE_RECARGO_PRODUCTO_ELECTRONICO) / 100); 
	}

}
