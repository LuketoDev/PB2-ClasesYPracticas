package ar.edu.unlam.pb2.dominio.practica.ejercicio4;


public class ProductoNoPerecedero extends Producto {
	
	private static final Double PORCENTAJE_DE_AGREGADO_NO_PERECEDERO = 7D;
	private String garantia;
	

	public ProductoNoPerecedero(String nombre, Integer cantidad, Double precioUnitario, String garantia) {
		// TODO Auto-generated constructor stub
		super(nombre, cantidad, precioUnitario);
		this.garantia = garantia;
	}
	
	@Override
	public Double obtenerPrecio() {
		return (this.getPrecioUnitario() + (this.getPrecioUnitario() * PORCENTAJE_DE_AGREGADO_NO_PERECEDERO / 100)) * this.getCantidad();
	}

}
