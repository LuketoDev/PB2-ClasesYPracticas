package ar.edu.unlam.pb2.dominio.practica.ejercicio4;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto {

	private static final Double PORCENTAJE_DE_AGREGADO_PERECEDERO = 5D;
	private LocalDate fechaDeVencimiento;

	public ProductoPerecedero(String nombre, Integer cantidad, Double precioUnitario, LocalDate fechaDeVencimiento) {
		// TODO Auto-generated constructor stub
		super(nombre, cantidad, precioUnitario);
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	
	@Override
	public Double obtenerPrecio() {
		
		return (this.getPrecioUnitario() + (this.getPrecioUnitario() * PORCENTAJE_DE_AGREGADO_PERECEDERO / 100)) * this.getCantidad();
	}
	
}
