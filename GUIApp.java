package Agenda;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUIApp {
    
    /**
     *  Creamos el gestor para que sea accesible en toda la clase
     */
    private GestorEventos gestor = new GestorEventos();
    private ListView<Evento> vistaLista = new ListView<>();
    private BorderPane raiz; // Atributo para que el contenido persista en la memoria para que lo pueda devolver a Pincipal cuando lo necesite

    // Hago una constructora
    public GUIApp() {
        // --- ZONA DERECHA ---
        VBox zonaDerecha = new VBox(10);
        zonaDerecha.setAlignment(Pos.CENTER);
        zonaDerecha.getChildren().add(new Label("Detalles del Evento"));

        HBox zonaCentral = new HBox(vistaLista, zonaDerecha);
        vistaLista.prefWidthProperty().bind(zonaCentral.widthProperty().divide(2));
        zonaDerecha.prefWidthProperty().bind(zonaCentral.widthProperty().divide(2));

        // --- BOTONES INFERIORES ---
        Button btnAdd = new Button("Añadir");
        Button btnRemove = new Button("Eliminar");
        Button btnCompletar = new Button("Completar");

        // Acción del botón Añadir: Llama a otro método 
        btnAdd.setOnAction(e -> abrirVentanaFormulario());
        
     // --- ACCIÓN ELIMINAR ---
        btnRemove.setOnAction(e -> {
            // Obtenemos el índice del elemento seleccionado en la lista
            int indice = vistaLista.getSelectionModel().getSelectedIndex();
            
            if (indice >= 0) {
                gestor.eliminarEvento(indice); // Llama a tu lógica de GestorEventos
                actualizarLista(); // Refresca la pantalla
            } else {
                mostrarAlerta("Selecciona un evento para eliminar");
            }
        });

        // --- ACCIÓN COMPLETAR ---
        btnCompletar.setOnAction(e -> {
            int indice = vistaLista.getSelectionModel().getSelectedIndex();
            
            if (indice >= 0) {
                gestor.marcarEventoComoCompletado(indice); // Llama a tu lógica
                actualizarLista(); // Refresca para que el "Pendiente" cambie a "✔"
            } else {
                mostrarAlerta("Selecciona un evento para completarlo");
            }
        });

        HBox botonera = new HBox(15, btnAdd, btnRemove, btnCompletar);
        botonera.setAlignment(Pos.CENTER);
        botonera.setStyle("-fx-padding: 15;");

        // --- LAYOUT PRINCIPAL ---
        this.raiz = new BorderPane();
        this.raiz.setCenter(zonaCentral);
        this.raiz.setBottom(botonera);

    }

    /**
     * Crea la nueva ventana
     * Ventana de formulario para el usuario
     */
    private void abrirVentanaFormulario() {
        Stage nuevaVentana = new Stage();
        nuevaVentana.setTitle("Nuevo Evento");

        // 1. Cuadros de texto y Desplegable
        TextField txtTitulo = new TextField();
        txtTitulo.setPromptText("Título");
        
        TextField txtFecha = new TextField();
        txtFecha.setPromptText("Fecha");

        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Trabajo", "Personal", "Formación");
        comboTipo.setPromptText("Selecciona tipo");
        
        ComboBox<String> comboPrioridad = new ComboBox<>();
        comboPrioridad.getItems().addAll("😱", "🤷", " 🐢");
        comboPrioridad.setPromptText("Grado de Procrastinación");

        TextField txtDetalleVariable = new TextField();
        txtDetalleVariable.setPromptText("Dato específico...");

        // Botón Guardar
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            Evento nuevo = null;
            String t = txtTitulo.getText();
            String f = txtFecha.getText();
            String det = txtDetalleVariable.getText();
            String prisaQLlevas = comboPrioridad.getValue();

            
            if ("Trabajo".equals(comboTipo.getValue())) {
                nuevo = new EventoTrabajo(t, f, prisaQLlevas, det);
            } else if ("Personal".equals(comboTipo.getValue())) {
                nuevo = new EventoPersonal(t, f,prisaQLlevas, det);
            } else if ("Formación".equals(comboTipo.getValue())) {
                nuevo = new EventoFormacion(t, f, prisaQLlevas, Integer.parseInt(det));
            }

            if (nuevo != null) {
                gestor.agregarEvento(nuevo);
                // Actualizamos la lista visualmente
                vistaLista.getItems().setAll(gestor.listarEventos());
                nuevaVentana.close();
            }
        });

        VBox layout = new VBox(10, new Label("Nuevo Evento"), txtTitulo, txtFecha, comboTipo, txtDetalleVariable, comboPrioridad, btnGuardar);
        layout.setStyle("-fx-padding: 20;");
        
        nuevaVentana.setScene(new Scene(layout, 300, 350));
        nuevaVentana.show();
    }
    
    private void actualizarLista() {
        // Borra la lista visual y la recarga desde el ArrayList del gestor
        vistaLista.getItems().setAll(gestor.listarEventos());
    }

    // Alerta de errores
    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setContentText(mensaje);
        alerta.show();
    }
    
    /**
     * Este método permite que la clase Principal obtenga el diseño 
     * completo para ponerlo dentro de la ventana.
     */
    public BorderPane getRaiz() {
        return raiz;
    }

}
