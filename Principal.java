package Agenda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{

    @Override
    public void start(Stage ventanaPrincipal) {
    	// Instanciamos y creamos la clase dde diseño
    	GUIApp gui = new GUIApp();                     // NOMBRE
    	
    	// Creamos la escena o ventana con sus ancho y alto
    	Scene escena = new Scene(gui.getRaiz(), 800, 600);
    	
    	ventanaPrincipal.setTitle("Gestor de Los Hombres Grises");
    	ventanaPrincipal.setScene(escena);
    	ventanaPrincipal.show();
    }
    
    
	public static void main(String[] args) {
        launch(args);
    }
    

    
}