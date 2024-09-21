package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.contratos.TransporteService;
import ar.edu.unlam.pb2.dominio.entidades.Paquete;
import ar.edu.unlam.pb2.dominio.servicios.AutoMovilServiceImpl;
import ar.edu.unlam.pb2.dominio.servicios.BicicletaServiceImpl;
import ar.edu.unlam.pb2.dominio.servicios.CamionServiceImpl;

public class TransporteServiceTest {
	
	TransporteService bicicleta;
	TransporteService automovil;
	TransporteService camion;
	
	@Before
	public void init() {
		
		bicicleta = new BicicletaServiceImpl();
		
		automovil = new AutoMovilServiceImpl();
		
		camion = new CamionServiceImpl();
		
	}
	
	/// |TEST DE BICICLETA| ///
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaQueNoPoseeCiudadDondeCirculaCuandoLeAgregoUnPaqueteQuePuedeLlevarEntoncesLaBicicletaTendraComoCiudadDondeCirculaLaCiudadDelDestinoDelPaquete() {
		
		// Preparacion
		Paquete paqueteConDestinoRamosMejia = new Paquete ("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		
		// Ejecucion
		
		bicicleta.agregar(paqueteConDestinoRamosMejia);
		
		// Verificacion
		
		String ciudadDeCirculacionDeLaBiciEsperada = "Ramos Mejia";
		
		assertEquals(ciudadDeCirculacionDeLaBiciEsperada, ((BicicletaServiceImpl)bicicleta).getCiudadDondeCircula());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaQuePoseeLaCiudadDeSuPrimerPaqueteCuandoLeAgregoUnSegundoPaqueteConCiudadDiferenteEntoncesLaBicicletaNoPuedeAgregarElPaquete() {
		
		// Preparacion
		Paquete paqueteConDestinoRamosMejia = new Paquete ("Ramos Mejia", 0D, 0D, 0D, 0D);
		bicicleta.agregar(paqueteConDestinoRamosMejia);
		Paquete paqueteConSanJusto = new Paquete ("San Justo", 0D, 0D, 0D, 0D);
		// Ejecucion
		
		Boolean seAgrego = bicicleta.agregar(paqueteConSanJusto);
		
		
		// Verificacion
		
		assertFalse(seAgrego);
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaQuePoseeYaDosPaquetesCuandoLeIntentoAgregarUnoMasEntoncesNoMeDejaAgregarlo() {
		
		// Preparacion
		Paquete paqueteConDestinoRamosMejia = new Paquete ("Ramos Mejia", 0D, 0D, 0D, 0D);
		Paquete paquete2ConDestinoRamosMejia = new Paquete ("Ramos Mejia", 0D, 0D, 0D, 0D);
		Paquete paquete3ConDestinoRamosMejia = new Paquete ("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		bicicleta.agregar(paqueteConDestinoRamosMejia);
		bicicleta.agregar(paquete2ConDestinoRamosMejia);
		
		
		// Ejecucion
		
		Boolean seAgrego = bicicleta.agregar(paquete3ConDestinoRamosMejia);
		
		
		// Verificacion
		
		assertFalse(seAgrego);
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaCuandoLePidoAgregarUnPaqueteDe20KgEntoncesElPaqueteNoEsAgregado() {
		
		// Preparacion
		
		
		Paquete paqueteDe20Kg = new Paquete("Ramos Mejia", 0D, 0D, 0D, 20D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = bicicleta.agregar(paqueteDe20Kg);		
		
		// Validacion
		
		assertFalse(seAgregoElPaquete);
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaCuandoLePidoAgregarUnPaqueteDe1M3EntoncesElPaqueteNoEsAgregado() {
		
		// Preparacion
		
		Paquete paqueteDe1M3 = new Paquete("Ramos Mejia", 1D, 1D, 1D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = bicicleta.agregar(paqueteDe1M3);		
		
		// Validacion
		
		assertFalse(seAgregoElPaquete);
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaCuandoLePidoAgregarUnPaqueteDe0Punto125M3Y15KgEntoncesElPaqueteEsAgregado() {
		
		// Preparacion
	
		Paquete paqueteDe2M3Y250Kg = new Paquete("Ramos Mejia", 0.5D, 0.5D, 0.5D, 15D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = bicicleta.agregar(paqueteDe2M3Y250Kg);		
		
		// Validacion
		List<Paquete> paquetesDeBicicletaObtenidos = bicicleta.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDeBicicletaObtenidos.size());
		
		
	}
	

	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaCuandoLePidoAgregar2PaquetesDe10KgEntoncesAceptaSoloUnPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 10D);
		Paquete paquete2 = new Paquete("San Justo", 0D, 0D, 0D, 10D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = bicicleta.agregar(paquete1);
		Boolean seAgregoElPaquete2 = bicicleta.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDeBicicletaObtenidos = bicicleta.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDeBicicletaObtenidos.size());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnaBicicletaCuandoLePidoAgregar2PaquetesDe0punto100M3EntoncesAceptaSoloUnPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 1D, 1D, 0.100D, 0D);
		Paquete paquete2 = new Paquete("San Justo", 1D, 1D, 0.100D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = bicicleta.agregar(paquete1);
		Boolean seAgregoElPaquete2 = bicicleta.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDeBicicletaObtenidos = bicicleta.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDeBicicletaObtenidos.size());
		
	}
	
	/// |TEST DE AUTOMOVIL| ///
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregarUnPaqueteDe550KgEntoncesElPaqueteNoEsAgregado() {
		
		// Preparacion
		
		
		Paquete paqueteDe550Kg = new Paquete("Ramos Mejia", 0D, 0D, 0D, 550D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = automovil.agregar(paqueteDe550Kg);		
		
		// Validacion
		
		assertFalse(seAgregoElPaquete);
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregarUnPaqueteDe4M3EntoncesElPaqueteNoEsAgregado() {
		
		// Preparacion
		
		Paquete paqueteDe4M3 = new Paquete("Ramos Mejia", 1D, 2D, 2D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = automovil.agregar(paqueteDe4M3);		
		
		// Validacion
		
		assertFalse(seAgregoElPaquete);
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregarUnPaqueteDe2M3Y250KgEntoncesElPaqueteEsAgregado() {
		
		// Preparacion
	
		Paquete paqueteDe2M3Y250Kg = new Paquete("Ramos Mejia", 1D, 1D, 2D, 250D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete = automovil.agregar(paqueteDe2M3Y250Kg);		
		
		// Validacion
		List<Paquete> paquetesDelAutomovilObtenidos = automovil.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelAutomovilObtenidos.size());
		
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregar2PaquetesConDestinoARamosMejiaEntoncesSoloAceptaElPrimerPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		Paquete paquete2 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = automovil.agregar(paquete1);
		Boolean seAgregoElPaquete2 = automovil.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDelAutomovilObtenidos = automovil.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);

		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelAutomovilObtenidos.size());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregar2PaquetesConDestinosDiferentesEntoncesAceptaLos2Paquetes() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		Paquete paquete2 = new Paquete("San Justo", 0D, 0D, 0D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = automovil.agregar(paquete1);
		Boolean seAgregoElPaquete2 = automovil.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDelAutomovilObtenidos = automovil.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 2;
		
		assertTrue(seAgregoElPaquete1);
		assertTrue(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelAutomovilObtenidos.size());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregar2PaquetesDe300KgEntoncesAceptaSoloUnPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 300D);
		Paquete paquete2 = new Paquete("San Justo", 0D, 0D, 0D, 300D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = automovil.agregar(paquete1);
		Boolean seAgregoElPaquete2 = automovil.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDelAutomovilObtenidos = automovil.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelAutomovilObtenidos.size());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnAutoMovilCuandoLePidoAgregar2PaquetesDe2M3EntoncesAceptaSoloUnPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 1D, 1D, 2D, 0D);
		Paquete paquete2 = new Paquete("San Justo", 1D, 1D, 2D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = automovil.agregar(paquete1);
		Boolean seAgregoElPaquete2 = automovil.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDelAutomovilObtenidos = automovil.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelAutomovilObtenidos.size());
		
	}
	
	/// |TEST DE CAMION| ///
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnCamionCuandoLePidoAgregarUnPaqueteDe20ToneladasEntoncesElPaqueteNoEsAgregado() {
		
		//Preparacion
		Paquete paqueteDe20Toneladas = new Paquete("Ramos Mejia", 0D, 0D, 0D, 20000D);
		
		// Ejecucion
		
		Boolean sePudoAgregar = camion.agregar(paqueteDe20Toneladas);
		
		// Validacion
		
		assertFalse(sePudoAgregar);
		
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnCamionCuandoLePidoAgregarUnPaqueteCon27M3EntoncesElPaqueteNoEsAgregado() {
		
		//Preparacion
		
		Paquete paqueteDe27M3= new Paquete("Ramos Mejia", 3D, 3D, 3D, 1000D);
		
		// Ejecucion
		
		Boolean sePudoAgregar = camion.agregar(paqueteDe27M3);
		
		// Validacion
		
		assertFalse(sePudoAgregar);
		
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnCamionCuandoLePidoAgregarUnPaqueteCon8M3Y1ToneladaEntoncesSeAgregaUnPedido() {
		
		//Preparacion
		
		Paquete paqueteAdecuado= new Paquete("Ramos Mejia", 2D, 2D, 2D, 1000D);
		
		// Ejecucion
		
		Boolean sePudoAgregar = camion.agregar(paqueteAdecuado);
		
		// Validacion
		List<Paquete> paquetesDelCamionObtenidos = camion.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		
		assertTrue(sePudoAgregar);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelCamionObtenidos.size());
		
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnCamionCuandoLePidoAgregar2PaquetesDe15ToneladasEntoncesAceptaSoloUnPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 15000D);
		Paquete paquete2 = new Paquete("San Justo", 0D, 0D, 0D, 15000D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = camion.agregar(paquete1);
		Boolean seAgregoElPaquete2 = camion.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDelCamionObtenidos = camion.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelCamionObtenidos.size());
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteQueEsUnCamionCuandoLePidoAgregar2PaquetesDe15M3EntoncesAceptaSoloUnPaquete() {
		
		// Preparacion
	
		Paquete paquete1 = new Paquete("Ramos Mejia", 1D, 3D, 5D, 0D);
		Paquete paquete2 = new Paquete("San Justo", 1D, 3D, 5D, 0D);
		
		// Ejecucion
		
		Boolean seAgregoElPaquete1 = camion.agregar(paquete1);
		Boolean seAgregoElPaquete2 = camion.agregar(paquete2);
		
		// Validacion
		List<Paquete> paquetesDelCamionObtenidos = camion.getPaquetesAEnviar();
		Integer cantidadDePaquetesEsperados = 1;
		
		assertTrue(seAgregoElPaquete1);
		assertFalse(seAgregoElPaquete2);
		assertEquals(cantidadDePaquetesEsperados.intValue(), paquetesDelCamionObtenidos.size());
		
	}

	/// |TEST GENERALES| ///
	
	@Test
	public void dadoQueExisteUnTransporteCon2PaquetesYaCargadosCuandoLePidoEntregar1PaqueteEntoncesElTransportePasaATenerUnUnicoPedidoAEnviar() {
		
		// usamos la bicicleta ya que no se puede instanciar una clase abstracta*
		
		// Preparacion 
		
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		Paquete paquete2 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 0D);
		
		bicicleta.agregar(paquete1);
		bicicleta.agregar(paquete2);
		
		// Ejecucion
		
		Boolean sePudoEntregar = bicicleta.entregar(paquete2);
		
		// Validacion
		
		List<Paquete> paquetesDelTransporteObtenidos = bicicleta.getPaquetesAEnviar();
		Integer cantidadDePaquetesAEnviarEsperados = 1;
		
		assertTrue(sePudoEntregar);
		assertEquals(cantidadDePaquetesAEnviarEsperados.intValue(), paquetesDelTransporteObtenidos.size());		
		
		
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteCon2PaquetesDe100KgYaCargadosCuandoLePidoEntregar1PaqueteEntoncesElTransportePasaAPesar100kg() {
		
		// usamos el camion ya que no se puede instanciar una clase abstracta*
		
		// Preparacion 
		
		Paquete paquete1 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 100D);
		Paquete paquete2 = new Paquete("Ramos Mejia", 0D, 0D, 0D, 100D);
		
		camion.agregar(paquete1);
		camion.agregar(paquete2);
		
		// Ejecucion
		
		camion.entregar(paquete2);
		
		// Validacion
		
		Double cantidadDePesoActualEsperado = 100D;
		
		assertEquals(cantidadDePesoActualEsperado, camion.getPesoActual());		
		
		
		
	}
	
	@Test
	public void dadoQueExisteUnTransporteCon2PaquetesDe1M3YaCargadosCuandoLePidoEntregar1PaqueteEntoncesElTransportePasaATener1M3OcupadoActualmente() {
		
		// usamos el automovil ya que no se puede instanciar una clase abstracta*
		
		// Preparacion 
		
		Paquete paquete1 = new Paquete("Ramos Mejia", 1D, 1D, 1D, 0D);
		Paquete paquete2 = new Paquete("San Justo", 1D, 1D, 1D, 0D);
		
		automovil.agregar(paquete1);
		automovil.agregar(paquete2);
		
		// Ejecucion
		
		automovil.entregar(paquete2);
		
		// Validacion
		
		Double cantidadDeM3OcupadosActualmenteDelTransporteEsperada = 1D;
		
		assertEquals(cantidadDeM3OcupadosActualmenteDelTransporteEsperada, automovil.getM3OcupadosActuales());		

	}
	
	@Test
	public void dadoQueExisteUnTransporteConNingunPaqueteAEnviarCuandoLePidoEntregarAlgunPaqueteEntoncesElTransporteNoPuedeEntregarElPaquete() {
		
		// usamos el automovil ya que no se puede instanciar una clase abstracta*
		
		// Preparacion 
		
		Paquete paquete1 = new Paquete("Ramos Mejia", 1D, 1D, 1D, 0D);

		// Ejecucion
		
		Boolean sePudoEntregarElPaquete = automovil.entregar(paquete1);
		
		// Validacion
		
		assertFalse(sePudoEntregarElPaquete);		

	}
}
