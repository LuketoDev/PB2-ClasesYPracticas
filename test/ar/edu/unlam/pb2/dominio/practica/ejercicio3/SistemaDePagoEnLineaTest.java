package ar.edu.unlam.pb2.dominio.practica.ejercicio3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SistemaDePagoEnLineaTest {
	
	@Test
	public void dadoQueExisteUnMetodoDePagoQueEsTransferenciaBancariaCuandoProcesoUnPagoDe100001DeMontoEntoncesSeAgregaEl1PorcientoDeCostoDeTrassaccionYElPagoFinalEs101000con01(){
		
		//Preparacion
		
		MetodoPago metodoTransferenciaBancaria = new TransferenciaBancaria();
		
		Double monto = 100001D;
		
		//Ejecucion
		
		Double montoObtenido = metodoTransferenciaBancaria.procesarPago(monto);
		
		//Verificacion
		
		Double montoEsperado = 101001.01D;
		
		assertEquals(montoEsperado, montoObtenido);
		
		
	}
	
	@Test
	public void dadoQueExisteUnMetodoDePagoQueEsTransferenciaBancariaCuandoProcesoUnPagoDe100DeMontoEntoncesNoSeAgregaCostoDeTrassaccionYElPagoFinalEs100(){
		
		//Preparacion
		
		MetodoPago metodoTransferenciaBancaria = new TransferenciaBancaria();
		
		Double monto = 100D;
		
		//Ejecucion
		
		Double montoObtenido = metodoTransferenciaBancaria.procesarPago(monto);
		
		//Verificacion
		
		Double montoEsperado = 100D;
		
		assertEquals(montoEsperado, montoObtenido);
		
		
	}
	
	@Test
	public void dadoQueExisteUnMetodoDePagoQueEsMercadoPagoCuandoProcesoUnPagoDe100DeMontoEntoncesSeAgregaElRecargoDe12PorcientoYElPagoFinalEs112(){
		
		//Preparacion
		
		MetodoPago metodoMercadoPago = new MercadoPago();
		
		Double monto = 100D;
		
		//Ejecucion
		
		Double montoObtenido = metodoMercadoPago.procesarPago(monto);
		
		//Verificacion
		
		Double montoEsperado = 112D;
		
		assertEquals(montoEsperado, montoObtenido);
		
	}
	
	@Test
	public void dadoQueExisteUnMetodoDePagoQueEsTarjetaDeCreditoQuePosee150DeCreditoCuandoProcesoUnPagoDe100DeMontoEntoncesSeAgregaElRecargoDe22con7PorcientoYElPagoFinalEs112(){
		
		//Preparacion
		
		
		Double creditoDisponible = 150D;
		MetodoPago metodoTarjetaCredito = new TarjetaCredito(creditoDisponible);
		
		Double monto = 100D;
		
		//Ejecucion
		
		Double montoObtenido = metodoTarjetaCredito.procesarPago(monto);
		
		//Verificacion
		
		Double montoEsperado = 122.7D;
		
		assertEquals(montoEsperado, montoObtenido);
		
	}
	
	@Test
	public void dadoQueExisteUnMetodoDePagoQueEsTarjetaDeCreditoQuePosee100DeCreditoCuandoProcesoUnPagoDe100DeMontoEntoncesNoSePuedeProcesarElPago(){
		
		//Preparacion
		
		
		Double creditoDisponible = 100D;
		MetodoPago metodoTarjetaCredito = new TarjetaCredito(creditoDisponible);
		
		Double monto = 100D;
		
		//Ejecucion
		
		Double montoObtenido = metodoTarjetaCredito.procesarPago(monto);
		
		//Verificacion
		
		// no deberia usar Boolean??
		
		Double montoEsperado = null; // que no procese el pago
		
		assertEquals(montoEsperado, montoObtenido);
		
	}

}
