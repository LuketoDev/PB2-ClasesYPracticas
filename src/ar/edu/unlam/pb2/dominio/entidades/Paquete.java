package ar.edu.unlam.pb2.dominio.entidades;

public class Paquete implements Comparable<Paquete>{

	private static Long proximoId = 0L; 
	
	private Long id;
	private String ciudadDeDestino;
	private Double volumen;
	private Double peso;
	
	
	public Paquete(String ciudadDeDestino, Double alto, Double ancho, Double profundo, Double peso) {
		this.id = ++proximoId;
		this.ciudadDeDestino = ciudadDeDestino;
		this.volumen = alto * ancho * profundo;
		this.peso = peso;
	}

	@Override
	public int compareTo(Paquete otroPaquete) {
		// TODO Auto-generated method stub
		return this.id.compareTo(otroPaquete.getId());
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getCiudadDeDestino() {
		// TODO Auto-generated method stub
		return this.ciudadDeDestino;
	}

	public Double getVolumen() {
		return volumen;
	}

	public Double getPeso() {
		return peso;
	}
	

}
