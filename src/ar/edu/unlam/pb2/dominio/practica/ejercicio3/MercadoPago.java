package ar.edu.unlam.pb2.dominio.practica.ejercicio3;

public class MercadoPago extends MetodoPago {

	private static final Double PORCENTAJE_RECARGO_MERCADO_PAGO = 12D;

	@Override
	public Double procesarPago(Double monto) {
		// TODO Auto-generated method stub
		
		return monto + ((monto * PORCENTAJE_RECARGO_MERCADO_PAGO) / 100); 
		
	}
}
