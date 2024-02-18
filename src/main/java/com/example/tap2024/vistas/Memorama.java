package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Timer;

public class Memorama extends Stage {
    private Scene escena;
    private HBox ventana;
    private HBox ventana2;
    private HBox ventana3;
    private HBox ventana4;
    private HBox ventana5;
    private VBox vContenedor;
    private GridPane tecladoMemorama;
    private Button[][] arrBotones = new Button[4][4];
    private char[] arrEtiquetas = {'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};

    public Memorama() {
        CrearUI();
        this.setTitle("Cuadro Mágico");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tecladoMemorama = new GridPane();
        vContenedor = new VBox();
        vContenedor.setSpacing(10);
        ventana = new HBox();
        ventana2 = new HBox();
        ventana3 = new HBox();
        ventana4 = new HBox();
        ventana5 = new HBox();
        escena = new Scene(vContenedor, 500, 500);
        CrearEncabezado();
        CrearTablero();
        CrearJugadores();
    }

    private void CrearEncabezado() {
        Label noPares = new Label("No. Pares:");
        HBox.setHgrow(noPares, Priority.ALWAYS);

        TextField cantPares = new TextField();
        HBox.setHgrow(cantPares, Priority.ALWAYS);

        Button revolver = new Button("Revolver");
        HBox.setHgrow(revolver, Priority.ALWAYS);

        Label tiempo = new Label("00:00");
        HBox.setHgrow( tiempo, Priority.ALWAYS);

        ventana.getChildren().addAll(noPares, cantPares, revolver, tiempo);

        vContenedor.getChildren().add(ventana);
    }

    private void CrearTablero() {
        int pos = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrBotones[i][j] =  new Button(arrEtiquetas[pos]+"");
                arrBotones[i][j].setPrefSize(50,50);
                tecladoMemorama.add(arrBotones[i][j],j,i);

                if(arrEtiquetas[pos] == '+' || arrEtiquetas[pos] == '-' || arrEtiquetas[pos] == '*' || arrEtiquetas[pos] == '/')
                    arrBotones[i][j].setId("color-operador");
                pos++;
            }
        }

        ventana2.getChildren().addAll(tecladoMemorama);
    }

    private void CrearJugadores(){
        Label primerJugador = new Label("Jugador 1");
        HBox.setHgrow(primerJugador, Priority.ALWAYS);

        Label contPrimerJugador = new Label("#");
        HBox.setHgrow(contPrimerJugador, Priority.ALWAYS);

        ventana3.getChildren().addAll(primerJugador, contPrimerJugador);

        Label segundoJugador = new Label("Jugador 2");
        HBox.setHgrow(segundoJugador, Priority.ALWAYS);

        Label contSegundoJugador = new Label("#");
        HBox.setHgrow(contSegundoJugador, Priority.ALWAYS);

        ventana4.getChildren().addAll(segundoJugador, contSegundoJugador);

        ventana5.getChildren().addAll(ventana2, ventana3, ventana4);
        vContenedor.getChildren().addAll(ventana5);
    }
}



