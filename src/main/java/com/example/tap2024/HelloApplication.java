package com.example.tap2024;

import com.example.tap2024.components.Hilo;
import com.example.tap2024.modelos.Conexion;
import com.example.tap2024.vistas.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    private MenuBar mnbPrincipal;
    private Menu menParcial1, menParcial2, menSalir;
    private MenuItem mitCalculadora, mitSalir, mitCuadroMagico, mitMemorama, mitEmpleado, mitPista;
    private BorderPane bdpPanel;
    @Override
    public void start(Stage stage) throws IOException {
        CrearMenu();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        bdpPanel =  new BorderPane();
        bdpPanel.setTop(mnbPrincipal);
        Scene scene = new Scene(bdpPanel);
        scene.getStylesheets().add(getClass().getResource("/estilos/main.css").toString());
        stage.setTitle("TAP2024");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

        Conexion.crearConexion();
    }

    private void CrearMenu() {

        // Primer Parcial
        mitCalculadora = new MenuItem("Calculadora");
        mitCalculadora.setOnAction(event -> new Calculadora());

        mitCuadroMagico = new MenuItem("Cuadro Magico");
        mitCuadroMagico.setOnAction(event -> new CuadroMagico());

        mitMemorama = new MenuItem("Memorama");
        mitMemorama.setOnAction(event -> new Memorama());

        mitEmpleado=new MenuItem("Empleado Taqeria");
        mitEmpleado.setOnAction(event -> new EmpleadoTaqueria());

        mitPista = new MenuItem("Manejo de Hilos");
        mitPista.setOnAction(event -> new Pista());

        menParcial1 = new Menu("Primer parcial");
        menParcial1.getItems().addAll(mitCalculadora);
        menParcial1.getItems().addAll(mitCuadroMagico);
        menParcial1.getItems().addAll(mitMemorama);
        menParcial1.getItems().addAll(mitEmpleado);

        // Segundo Parcial
        menParcial2 = new Menu("segundo parcial");
        menParcial2.getItems().addAll(mitPista);

        // menu salir
        mitSalir = new MenuItem("Salir");
        menSalir = new Menu("Salir");
        menSalir.getItems().add(mitSalir);
        mitSalir.setOnAction(event -> System.exit(0));

        mnbPrincipal = new MenuBar();
        mnbPrincipal.getMenus().addAll(menParcial1, menParcial2, menSalir);
    }

    public static void main(String[] args) {
        launch();
    }
}