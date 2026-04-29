package Agenda;

import java.util.ArrayList;

public interface Gestionable {
	public void agregarEvento(Evento e);
	public void eliminarEvento(int indice);
	public ArrayList<Evento> listarEventos();
}
