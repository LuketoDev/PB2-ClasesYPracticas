package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.contratos.TransporteService;
import ar.edu.unlam.pb2.dominio.entidades.Paquete;
import ar.edu.unlam.pb2.dominio.servicios.AutoMovilServiceImpl;
import ar.edu.unlam.pb2.dominio.servicios.BicicletaServiceImpl;
import ar.edu.unlam.pb2.dominio.servicios.CamionServiceImpl;
import ar.edu.unlam.pb2.dominio.servicios.EmpresaDeTransporteService;

public class EmpresaDeTransporteServiceTest {
	
	EmpresaDeTransporteService empresaDeTransporte;
	
	@Before
	public void init() {
		empresaDeTransporte = new EmpresaDeTransporteService();
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaDeTransporteCuandoAgregoUnPaqueteALaListaDePaquetesDeLaEmpresaEntoncesSeAgregaElPaqueteDentroDeLaEmpresa() {
		
		// Preparacion
		
		Paquete paquete = new Paquete("", 0D, 0D, 0D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = empresaDeTransporte.agregar(paquete);
		
		// Verificacion
		
		assertTrue(seAgregoElPaquete);
		
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaDeTransporteCuandoAgregoDosPaquetesALaListaDePaquetesDeLaEmpresaEntoncesHay2PaquetesDentroDeLaEmpresa() {
		
		// Preparacion
		
		Paquete paquete = new Paquete("", 0D, 0D, 0D, 0D);
		Paquete paquete2 = new Paquete("", 0D, 0D, 0D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = empresaDeTransporte.agregar(paquete);
		Boolean seAgregoElPaquete2 = empresaDeTransporte.agregar(paquete2);
		
		// Verificacion
		
		Set<Paquete> paquetesObtenidos = empresaDeTransporte.obtenerPaquetes();
		Integer cantidadDePaquetesEsperados = 2;
		
		assertTrue(seAgregoElPaquete);
		assertTrue(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesObtenidos.size());
		
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaDeTransporteCuandoAgregoUnTransporteQueEsUnaBicicletaALaListaDeTransportesDeLaEmpresaEntoncesSeAgregaElTransporteDentroDeLaEmpresa() {
		
		// Preparacion
		
		TransporteService transporte = new BicicletaServiceImpl();
		
		// Ejecucion
		
		Boolean seAgregoElTransporte = empresaDeTransporte.agregar(transporte);
		
		// Verificacion
		
		assertTrue(seAgregoElTransporte);
		
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaDeTransporteCuandoAgregoTresTransportesQueSonUnaBicicletaUnAutomovilYUnCamionALaListaDeTransportesDeLaEmpresaEntoncesHay3TransportesDentroDeLaEmpresa() {
		
		// Preparacion
		
		TransporteService bicicleta = new BicicletaServiceImpl();
		TransporteService automovil = new AutoMovilServiceImpl();
		TransporteService camion = new CamionServiceImpl();
		
		// Ejecucion
		
		Boolean seAgregoElTransporte = empresaDeTransporte.agregar(bicicleta);
		Boolean seAgregoElTransporte2 = empresaDeTransporte.agregar(automovil);
		Boolean seAgregoElTransporte3 = empresaDeTransporte.agregar(camion);
		
		// Verificacion
		
		Set<TransporteService> TransportesObtenidos = empresaDeTransporte.obtenerTransportes();
		Integer cantidadDeTransportesEsperados = 3;
		
		assertTrue(seAgregoElTransporte);
		assertTrue(seAgregoElTransporte2);
		assertTrue(seAgregoElTransporte3);
		assertEquals(TransportesObtenidos.size(), cantidadDeTransportesEsperados.intValue());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteDeLaEmpresaCuandoLePidoLLevarUnPaqueteQueNoEstaDentroDeLosPaquetesDeLaEmpresaEntoncesNoSePuedeRealizarElEnvio() {
		
		// Preparacion
		
		TransporteService camionDeLaEmpresa = new CamionServiceImpl();
		
		empresaDeTransporte.agregar(camionDeLaEmpresa);
		
		Paquete paqueteFueraDeLaEmpresa = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		// Ejecucion
		
		Boolean seArmaElEnvio = empresaDeTransporte.armarEnvio(paqueteFueraDeLaEmpresa, camionDeLaEmpresa);
		
		// Verificacion
		
		assertFalse(seArmaElEnvio);
	
	}
	
	@Test
	public void dadoQueExisteUnPaqueteDeLaEmpresaCuandoLePidoAUnTransporteFueraDeLaEmpresaLLevarElPaqueteEntoncesNoSePuedeRealizarElEnvio() {
		
		// Preparacion
		
		Paquete paqueteDeLaEmpresa = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		empresaDeTransporte.agregar(paqueteDeLaEmpresa);
		
		TransporteService camionFueraDeLaEmpresa = new CamionServiceImpl();
		
		// Ejecucion
		
		Boolean seArmaElEnvio = empresaDeTransporte.armarEnvio(paqueteDeLaEmpresa, camionFueraDeLaEmpresa);
		
		// Verificacion
		
		assertFalse(seArmaElEnvio);
	
	}
	
	@Test
	public void dadoQueExisteUnPaqueteDeLaEmpresaCuandoLePidoAUnTransporteDeLaEmpresaLLevarElPaqueteEntoncesSePuedeRealizarElEnvio() {
		
		// Preparacion
		
		Paquete paqueteDeLaEmpresa = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		TransporteService camionDeLaEmpresa = new CamionServiceImpl();
		
		empresaDeTransporte.agregar(paqueteDeLaEmpresa);
		empresaDeTransporte.agregar(camionDeLaEmpresa);
		
		
		
		// Ejecucion
		
		Boolean seArmaElEnvio = empresaDeTransporte.armarEnvio(paqueteDeLaEmpresa, camionDeLaEmpresa);
		
		// Verificacion
		
		assertTrue(seArmaElEnvio);
	
	}
	
	@Test
	public void dadoQueExisteUnUnTransporteDeLaEmpresaCuandoLePidoQueEntregueUnPaqueteQueNoEsDeLaEmpresaEntoncesNoSeConcretaElEnvio() {
		
		// Preparacion
		
		Paquete paqueteFueraDeLaEmpresa = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		TransporteService camionDeLaEmpresa = new CamionServiceImpl();
		
		empresaDeTransporte.agregar(camionDeLaEmpresa);
	
		
		// Ejecucion
		
		Boolean seConcretoElEnvio = empresaDeTransporte.concretarEnvio(paqueteFueraDeLaEmpresa, camionDeLaEmpresa);
		
		// Verificacion
		
		assertFalse(seConcretoElEnvio);
	
	}
	
	@Test
	public void dadoQueExisteUnTransporteDeLaEmpresaConUnPaqueteDeLaEmpresaCargadoCuandoLePidoQueEntregueUnPaqueteQueNoTieneElTransporteEntoncesNoSeConcretaElEnvio() {
		
		// Preparacion
		
		TransporteService camionDeLaEmpresa = new CamionServiceImpl();
		Paquete paqueteDeLaEmpresa1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		Paquete paqueteDeLaEmpresa2 = new Paquete("San Justo", 0D, 0D, 0D, 0D);
		
		empresaDeTransporte.agregar(camionDeLaEmpresa);
		empresaDeTransporte.agregar(paqueteDeLaEmpresa1);
		empresaDeTransporte.agregar(paqueteDeLaEmpresa2);
		
		empresaDeTransporte.armarEnvio(paqueteDeLaEmpresa1, camionDeLaEmpresa);
		
		// Ejecucion
		
		Boolean seConcretoElEnvio = empresaDeTransporte.concretarEnvio(paqueteDeLaEmpresa2, camionDeLaEmpresa);
		
		// Verificacion
		
		assertFalse(seConcretoElEnvio);
	
	}
	
	@Test
	public void dadoQueExisteUnPaqueteDeLaEmpresaConUnTransporteDeLaEmpresaAsignadoParaElEnvioCuandoLePidoQueEntregueElPaqueteConOtroTransporteEntoncesNoSeConcretaElEnvio() {
		
		// Preparacion
		
		Paquete paqueteDeLaEmpresa = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		TransporteService camionDeLaEmpresa = new CamionServiceImpl();
		TransporteService automovilDeLaEmpresa = new AutoMovilServiceImpl();
		
		empresaDeTransporte.agregar(paqueteDeLaEmpresa);
		empresaDeTransporte.agregar(camionDeLaEmpresa);
		empresaDeTransporte.agregar(automovilDeLaEmpresa);
		
		empresaDeTransporte.armarEnvio(paqueteDeLaEmpresa, camionDeLaEmpresa);
		
		// Ejecucion
		
		Boolean seConcretoElEnvio = empresaDeTransporte.concretarEnvio(paqueteDeLaEmpresa, automovilDeLaEmpresa);
		
		// Verificacion
		
		assertFalse(seConcretoElEnvio);
	
	}
	
	@Test
	public void dadoQueExisteUnPaqueteDeLaEmpresaConUnTransporteDeLaEmpresaAsignadoParaElEnvioCuandoLePidoQueEntregueElPaqueteAElTransporteCorrespondienteEntoncesSeConcretaElEnvio() {
		
		// Preparacion
		
		Paquete paqueteDeLaEmpresa = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		TransporteService bicicletaDeLaEmpresa = new BicicletaServiceImpl();
		
		empresaDeTransporte.agregar(paqueteDeLaEmpresa);
		empresaDeTransporte.agregar(bicicletaDeLaEmpresa);
		
		empresaDeTransporte.armarEnvio(paqueteDeLaEmpresa, bicicletaDeLaEmpresa);
		
		// Ejecucion
		
		Boolean seConcretoElEnvio = empresaDeTransporte.concretarEnvio(paqueteDeLaEmpresa, bicicletaDeLaEmpresa);
		
		// Verificacion
		
		assertTrue(seConcretoElEnvio);
	
	}
	
	
	

}
