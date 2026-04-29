package Agenda;

public abstract class Evento {
	protected String titulo;
	protected String fecha;
	protected boolean completado;
	
	public Evento(String titulo, String fecha) {
	this.titulo = titulo;
	this.fecha = fecha;
	this.completado = false;
	}
	
	public void marcarComoCompletado() {
	this.completado = true;
	}
	
	public boolean isCompletado() {
	return completado;
	}
	
	public String getTitulo() {
	return titulo;
	}
	
	public String getFecha() {
	return fecha;
	}
	
	public abstract String getDetalles();
	@Override
	public String toString() {
	return titulo + " (" + fecha + ") - " + (completado ? "✔" : "Pendiente");
	}
}