package ar.edu.unlam.pb2.dominio.servicios;

import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.pb2.dominio.contratos.TransporteService;
import ar.edu.unlam.pb2.dominio.entidades.Paquete;

public class EmpresaDeTransporteService {

	private Set<Paquete> paquetes;
	private Set<TransporteService> transportes;
	
	public EmpresaDeTransporteService() {
		this.paquetes = new TreeSet<>();
		this.transportes = new TreeSet<>();
	}

	public Boolean agregar(Paquete paquete) {
		return this.paquetes.add(paquete);
	}
	
	public Boolean agregar(TransporteService transporte) {
		return this.transportes.add(transporte);
	}

	public Boolean armarEnvio(Paquete paquete, TransporteService transporte) {
		
		if (this.estaDentroDeLaEmpresa(paquete) && this.estaDentroDeLaEmpresa(transporte) ) {
			
			return transporte.agregar(paquete);
			
		}
		
		return false;
	}
	
	public Boolean concretarEnvio(Paquete paquete, TransporteService transporte) {
		
		if (this.estaDentroDeLaEmpresa(paquete) && this.estaDentroDeLaEmpresa(transporte) ) {
			
			return transporte.entregar(paquete);
			
		}
		
		return false;

	}

	private boolean estaDentroDeLaEmpresa(TransporteService transporte) {
		
		for (TransporteService t : this.transportes) {
			
			if (t.equals(transporte))
				return true;
		}
		
		return false;
	}

	private boolean estaDentroDeLaEmpresa(Paquete paquete) {
		for (Paquete p : this.paquetes) {
			
			if (p.equals(paquete))
				return true;
		}
		
		return false;
	}
	
	public Set<Paquete> obtenerPaquetes() {
		return this.paquetes;
	}

	public Set<TransporteService> obtenerTransportes() {
		
		return this.transportes;
	}

}
