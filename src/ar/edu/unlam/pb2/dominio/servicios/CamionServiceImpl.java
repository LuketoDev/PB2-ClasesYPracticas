package ar.edu.unlam.pb2.dominio.servicios;

import ar.edu.unlam.pb2.dominio.contratos.TransporteService;
import ar.edu.unlam.pb2.dominio.entidades.Paquete;

public class CamionServiceImpl extends TransporteService {

	private static final Double CAPACIDAD_DE_PESO_MAXIMO_DE_CAMION = 16000D; // 16 toneladas
	private static final Double MAXIMO_DE_M3_ADMITIDO_DE_CAMION = 20D;

	@Override
	public Boolean puedeLLevar(Paquete paquete) {
		
		if (this.getPesoActual() + paquete.getPeso() <= CAPACIDAD_DE_PESO_MAXIMO_DE_CAMION 
				&& this.getM3OcupadosActuales() + paquete.getVolumen() <= MAXIMO_DE_M3_ADMITIDO_DE_CAMION) {
			return true;
		}
	

		return false;
	}


}
