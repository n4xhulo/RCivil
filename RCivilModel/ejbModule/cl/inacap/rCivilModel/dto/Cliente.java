package cl.inacap.rCivilModel.dto;

public class Cliente {
	
	private String rut;
	private String nombre;
	private String tipoSolicitud;
	private int numSolicitud;
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumSolicitud() {
		return numSolicitud;
	}
	public void setNumSolicitud(int numSolicitud) {
		this.numSolicitud = numSolicitud;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

}
