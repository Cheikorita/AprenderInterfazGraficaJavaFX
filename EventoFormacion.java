package Agenda;

public class EventoFormacion extends Evento {
    private int duracionHoras;

    public EventoFormacion(String titulo, String fecha, String prioridad, int duracionHoras) {
        super(titulo, fecha, prioridad);
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String getDetalles() {
        return "Duración: " + duracionHoras + " horas";
    }
}