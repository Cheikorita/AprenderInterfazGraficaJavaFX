package Agenda;

public abstract class Evento {
    protected String titulo;
    protected String fecha;
    protected boolean completado;
    protected String prioridad; 
    
    public Evento(String titulo, String fecha, String prioridad) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.completado = false;
        this.prioridad = prioridad;
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
    

    public String getPrioridad() {
		return prioridad;
	}

	@Override
    public String toString() {
        return prioridad + " | " + titulo + " (" + fecha + ") - " + (completado ? "✔" : "Pendiente");
    }
}	