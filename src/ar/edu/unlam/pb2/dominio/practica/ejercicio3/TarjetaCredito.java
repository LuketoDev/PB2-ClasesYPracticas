package ar.edu.unlam.pb2.dominio.practica.ejercicio3;

public class TarjetaCredito extends MetodoPago {

	private static final Double PORCENTAJE_RECARGO_TARJETA_DE_CREDITO = 22.7D;
	private Double creditoDisponible;

	public TarjetaCredito(Double creditoDisponible) {
		this.creditoDisponible = creditoDisponible;
	}
	
	
	@Override
	public Double procesarPago(Double monto) {
		// TODO Auto-generated method stub
		
		Double montoFinal = monto + ((monto * PORCENTAJE_RECARGO_TARJETA_DE_CREDITO) / 100);
		
		if (this.creditoDisponible > montoFinal) {
			return montoFinal;
		}
		
//		} else if (this.creditoDisponible <= montoFinal && this.creditoDisponible >= monto) {
//			return monto; 
//		} // no deberia hacerse el pago si no hay credito disponible para cubrir el monto y su recargo.
	
		return null; // no se pudo procesar el pago
	}
}
