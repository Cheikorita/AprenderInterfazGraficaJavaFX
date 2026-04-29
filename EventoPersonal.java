package Agenda;

	public class EventoPersonal extends Evento {
		
		private String ubicacion;
		
		public EventoPersonal(String titulo, String fecha, String ubicacion) {
		super(titulo, fecha);
		this.ubicacion = ubicacion;
	}
	
	@Override
	public String getDetalles() {
		return "Ubicación: " + ubicacion;
	}
}
