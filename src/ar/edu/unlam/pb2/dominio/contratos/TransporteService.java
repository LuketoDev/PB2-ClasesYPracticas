package ar.edu.unlam.pb2.dominio.contratos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.pb2.dominio.entidades.Paquete;

public abstract class TransporteService implements Comparable<TransporteService> {
	
	
	private static Long proximoId = 0L; 
	
	private Long id;
	private Double pesoActual;
	private Double m3OcupadosActuales;
	private Integer cantidadDePaquetesActuales;
	private List<Paquete> paquetesAEnviar;
	
	
	public TransporteService() {
		this.id = ++proximoId;
		this.pesoActual = 0D;
		this.cantidadDePaquetesActuales = 0;
		this.m3OcupadosActuales = 0D;
		this.paquetesAEnviar = new ArrayList<>();
	}
	
	
	// Metodos Abstractos
	
	
	public abstract Boolean puedeLLevar(Paquete paquete);
	

	// Metodos comunes

	@Override
	public int compareTo(TransporteService otroTransporte) {
		return this.id.compareTo(otroTransporte.getId());
	}
	
	public Boolean agregar(Paquete paquete) {
		
		if (this.puedeLLevar(paquete)) {
			this.pesoActual += paquete.getPeso();
			this.m3OcupadosActuales += paquete.getVolumen();
			this.cantidadDePaquetesActuales++;
			return this.getPaquetesAEnviar().add(paquete);
		}
		return false;
	}
	
	public Boolean entregar(Paquete paquete) {
		
		if (this.estaEnLaListaDePaquetesAEnviar(paquete)) {
			this.pesoActual -= paquete.getPeso();
			this.m3OcupadosActuales -= paquete.getVolumen();
			return this.paquetesAEnviar.remove(paquete);
		}
		
		return false;
	}

	public boolean estaEnLaListaDePaquetesAEnviar(Paquete paquete) {
		
		for (Paquete p : this.paquetesAEnviar) {
			
			if (p.equals(paquete))
				return true;
			
		}
		
		return false;
	}


	private Long getId() {
		return this.id;
	}


	public Double getPesoActual() {
		return pesoActual;
	}

	
	public Double getM3OcupadosActuales() {
		return m3OcupadosActuales;
	}


	public Integer getCantidadDePaquetesActuales() {
		return cantidadDePaquetesActuales;
	}


	public List<Paquete> getPaquetesAEnviar() {
		return paquetesAEnviar;
	}


	
	
	
	
	

}
