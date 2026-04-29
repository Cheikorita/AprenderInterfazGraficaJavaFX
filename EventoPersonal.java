package Agenda;

public class EventoPersonal extends Evento {
    private String ubicacion;

    public EventoPersonal(String titulo, String fecha, String prioridad, String ubicacion) {
        super(titulo, fecha, prioridad);
        this.ubicacion = ubicacion;
    }

    @Override
    public String getDetalles() {
        return "Ubicación: " + ubicacion;
    }
}
