package ar.edu.unlam.pb2.dominio.servicios;

import ar.edu.unlam.pb2.dominio.contratos.TransporteService;
import ar.edu.unlam.pb2.dominio.entidades.Paquete;

public class AutoMovilServiceImpl extends TransporteService {

	private static final Double CAPACIDAD_DE_PESO_MAXIMO_AUTOMOVIL = 500D;
	private static final Double CANTIDAD_MAXIMA_DE_M3_SOPORTADOS_AUTOMOVIL = 2D;

	@Override
	public Boolean puedeLLevar(Paquete paquete) {
		if (this.getPesoActual() + paquete.getPeso() <= CAPACIDAD_DE_PESO_MAXIMO_AUTOMOVIL 
				&& this.getM3OcupadosActuales() + paquete.getVolumen() <= CANTIDAD_MAXIMA_DE_M3_SOPORTADOS_AUTOMOVIL
				&& !this.tieneDestinoRepetido(paquete)) {
			return true;
		}
		return false;
	}

	private Boolean tieneDestinoRepetido(Paquete paquete) {
		
		for (Paquete p : this.getPaquetesAEnviar()) {
			
			if (p.getCiudadDeDestino().equals(paquete.getCiudadDeDestino())) {
				return true;
			}
			
		}
		
		return false;
	}

}
