package Agenda;

public class EventoFormacion extends Evento {
	
	private int duracionHoras;
	
	public EventoFormacion(String titulo, String fecha, int duracionHoras) {
		super(titulo, fecha);
		this.duracionHoras = duracionHoras;
	}
	
	@Override
	public String getDetalles() {
		return "Duración: " + duracionHoras + " horas";
	}
}