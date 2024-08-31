package ar.edu.unlam.pb2.dominio.practica.ejercicio2;

public class Producto {

	private String nombre;
	private Double precio;
	private String descripcion;

	public Producto(String nombre, Double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public Double calcularPrecioFinal() {
		// TODO Auto-generated method stub
		return this.precio; // la superclase deja el precio tal cual esta.
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
