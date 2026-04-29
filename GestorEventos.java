package Agenda;

import java.util.ArrayList;

public class GestorEventos implements Gestionable {
	
	private ArrayList<Evento> eventos;
	
	public GestorEventos() {
		eventos = new ArrayList<>();
	}
	
	@Override
	public void agregarEvento(Evento e) {
		eventos.add(e);
	}
	
	@Override
	public void eliminarEvento(int indice) {
		if (indice >= 0 && indice < eventos.size()) {
			eventos.remove(indice);
		} else {
			System.out.println("Índice no válido.");
		}
	}
	
	@Override
	public ArrayList<Evento> listarEventos() {
		return eventos;
	}
	
	public void marcarEventoComoCompletado(int indice) {
		if (indice >= 0 && indice < eventos.size()) {
			eventos.get(indice).marcarComoCompletado();
		} else {
			System.out.println("Índice no válido.");
		}
	
	}
	
	public ArrayList<Evento> filtrarCompletados(boolean completados) {
		ArrayList<Evento> resultado = new ArrayList<>();
		
		for (Evento e : eventos) {
			if (e.isCompletado() == completados) {
				resultado.add(e);
			}
		}
		
		return resultado;
	}
}