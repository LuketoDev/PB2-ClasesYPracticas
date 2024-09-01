package ar.edu.unlam.pb2.dominio.practica.ejercicio4;


public class Producto {

	private String nombre;
	private Integer cantidad;
	private Double precioUnitario;

	public Producto(String nombre, Integer cantidad, Double precioUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public Double obtenerPrecio() {
		// TODO Auto-generated method stub
		return precioUnitario * cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
}
