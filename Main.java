package Agenda;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	GestorEventos gestor = new GestorEventos();
	
	int opcion;
	
	do {
		System.out.println("\n--- GESTOR DE EVENTOS ---");
		System.out.println("1. Añadir evento");
		System.out.println("2. Listar eventos");
		System.out.println("3. Eliminar evento");
		System.out.println("4. Marcar como completado");
		System.out.println("0. Salir");
		System.out.print("Opción: ");
		
		opcion = sc.nextInt();
		sc.nextLine(); // limpiar buffer
		
		switch (opcion) {
			case 1:
				System.out.println("Tipo (1-Trabajo, 2-Personal, 3-Formación): ");
				int tipo = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Título: ");
				String titulo = sc.nextLine();
				
				System.out.print("Fecha: ");
				String fecha = sc.nextLine();
				
				Evento evento = null;
				
				if (tipo == 1) {
					System.out.print("Cliente: ");
					String cliente = sc.nextLine();
					evento = new EventoTrabajo(titulo, fecha, cliente);
				} else if (tipo == 2) {
					System.out.print("Ubicación: ");
					String ubicacion = sc.nextLine();
					evento = new EventoPersonal(titulo, fecha, ubicacion);
				} else if (tipo == 3) {
					System.out.print("Duración (horas): ");
					int duracion = sc.nextInt();
					evento = new EventoFormacion(titulo, fecha, duracion);
				}
				if (evento != null) {
					gestor.agregarEvento(evento);
				}
				break;
				
			case 2:
				for (int i = 0; i < gestor.listarEventos().size(); i++) {
					Evento e = gestor.listarEventos().get(i);
					System.out.println(i + ". " + e);
					System.out.println(" " + e.getDetalles());
				}
				break;
				
			case 3:
				System.out.print("Índice a eliminar: ");
				int eliminar = sc.nextInt();
				gestor.eliminarEvento(eliminar);
				break;
				
			case 4:
				System.out.print("Índice a completar: ");
				int completar = sc.nextInt();
				gestor.marcarEventoComoCompletado(completar);
				break;
		}
	} while (opcion != 0);
	
	sc.close(); 
	
	}
}
