package Agenda;

public class EventoTrabajo extends Evento {
	private String cliente;

		public EventoTrabajo(String titulo, String fecha, String cliente) {
				super(titulo, fecha);
					this.cliente = cliente;
		}

	@Override
	public String getDetalles() {
		return "Trabajo para cliente: " + cliente;
	}
}
