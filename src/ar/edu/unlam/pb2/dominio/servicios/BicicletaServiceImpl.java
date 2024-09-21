package ar.edu.unlam.pb2.dominio.servicios;

import ar.edu.unlam.pb2.dominio.contratos.TransporteService;
import ar.edu.unlam.pb2.dominio.entidades.Paquete;

public class BicicletaServiceImpl extends TransporteService {
	
	

	private static final Double MAXIMO_DE_M3_ADMITIDO_DE_LA_BICICLETA = 0.125D;

	private static final Double CAPACIDAD_DE_PESO_MAXIMO_DE_BICICLETA = 15D;

	private static final Integer CAPACIDAD_MAXIMA_DE_PAQUETES_DE_LA_BICICLETA = 2;
	
	private String ciudadDondeCircula;
	

	public BicicletaServiceImpl() {
		super();
		this.ciudadDondeCircula = null;
		
	}

	@Override
	public Boolean puedeLLevar(Paquete paquete) {
	
		Boolean puedeLlevar = false;
		
		if (this.getPesoActual() + paquete.getPeso() <= CAPACIDAD_DE_PESO_MAXIMO_DE_BICICLETA 
				&& this.getM3OcupadosActuales() + paquete.getVolumen() <= MAXIMO_DE_M3_ADMITIDO_DE_LA_BICICLETA 
				&& this.getCantidadDePaquetesActuales() < CAPACIDAD_MAXIMA_DE_PAQUETES_DE_LA_BICICLETA){
			
			if (this.ciudadDondeCircula == null) {
				this.ciudadDondeCircula = paquete.getCiudadDeDestino();
				puedeLlevar = true;
			} else if (this.ciudadDondeCircula.equals(paquete.getCiudadDeDestino())) {
				puedeLlevar = true;
			}
		}
		return puedeLlevar;
	}

	public String getCiudadDondeCircula() {
		return ciudadDondeCircula;
	}

}
