package ar.edu.unlam.pb2.dominio.practica.ejercicio2;

public class ProductoAlimenticio extends Producto {

	private static final int VALOR_AGREGADO_PRODUCTO_ALIMENTICIO = 1000;
	private static final Double PORCENTAJE_RECARGO_PRODUCTO_ALIMENTICIO = 7.5D;

	public ProductoAlimenticio(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
	}
	
	@Override
	public Double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return this.getPrecio() + VALOR_AGREGADO_PRODUCTO_ALIMENTICIO + ((this.getPrecio() * PORCENTAJE_RECARGO_PRODUCTO_ALIMENTICIO) / 100); 
	}

}
