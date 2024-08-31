package ar.edu.unlam.pb2.dominio.practica.ejercicio3;

public class TransferenciaBancaria extends MetodoPago {
	
	private static final Integer MONTO_LIMITE_SIN_COSTO_DE_TRANSACCION = 100000;
	private static final Double PORCENTAJE_COSTO_DE_TRANSACCION = 1D;

	@Override
	public Double procesarPago(Double monto) {
		// TODO Auto-generated method stub
		
		if (monto > MONTO_LIMITE_SIN_COSTO_DE_TRANSACCION) {
			return monto + ((monto * PORCENTAJE_COSTO_DE_TRANSACCION) / 100); 
		}
		
		return monto;
		
	}

}
