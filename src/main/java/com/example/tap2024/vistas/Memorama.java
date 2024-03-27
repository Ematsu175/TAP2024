package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Button[][] arrBotones = new Button[2][4];
    //private char[] arrEtiquetas = {'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};

    public Memorama() {
        CrearUI();
        this.setTitle("Memorama");
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
        escena = new Scene(vContenedor, 1000, 600);
        CrearTablero();

        CrearEncabezado();
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
        String[] arrImages = {"calavera.jpg", "dragon.png", "gota.png", "minion.png","dona.png","galleta.png","hamburguesa.png",
                "helado.png","naruto.png","palomitas.png","papas.png","pez.png","pizza.png","sopa.png","taco.png"};
        Button[][] arrButtonCartas = new Button[5][6];

        ImageView imvCarta;
        int posx = 0;
        int posy = 0;
        int cont = 0;
        for (int i = 0; i < arrImages.length; ) {
            posx = (int) (Math.random()*5);
            posy = (int) (Math.random()*6);
            if(arrButtonCartas[posx][posy] == null){
                arrButtonCartas[posx][posy] = new Button();
                imvCarta = new ImageView(getClass().getResource("/images/"+arrImages[i]).toString());
                imvCarta.setFitWidth(100);
                imvCarta.setFitHeight(100);
                arrButtonCartas[posx][posy].setGraphic(imvCarta);
                //arrButtonCartas[posx][posy].setPrefSize(100,100);
                tecladoMemorama.add(arrButtonCartas[posx][posy],posy,posx);
                cont++;
                if(cont == 2)  {
                    i++;
                    cont = 0;
                }
            }
        }

        ventana2.getChildren().addAll(tecladoMemorama);
        //vContenedor.getChildren().addAll(ventana2);
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



