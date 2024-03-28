package com.example.tap2024.vistas;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class Memorama extends Stage {
    private Scene escena;
    private HBox ventana;
    private HBox ventana2;
    private HBox ventana3;
    private HBox ventana4;
    private HBox ventana5;
    private VBox vContenedor;
    private GridPane tecladoMemorama;
    private Label contPrimerJugador = new Label("00:00");
    private Label contSegundoJugador = new Label("00:00");
    private int minutos = 0;
    private int segundos = 0;
    private Button[][] arrBotones = new Button[2][4];
    String[] arrImages = {"calavera.jpg", "dragon.png", "gota.png", "minion.png","dona.png","galleta.png","hamburguesa.png",
            "helado.png","naruto.png","palomitas.png","papas.png","pez.png","pizza.png","sopa.png","taco.png"};
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

        revolver.setOnAction( event -> {
            int numPares =  Integer.parseInt((cantPares.getText()));
            revolverCartas(numPares);
        });

        ventana.getChildren().addAll(noPares, cantPares, revolver, tiempo);

        vContenedor.getChildren().add(ventana);
    }

    private void CrearTablero() {

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

        HBox.setHgrow(contPrimerJugador, Priority.ALWAYS);

        ventana3.getChildren().addAll(primerJugador, contPrimerJugador);

        Label segundoJugador = new Label("Jugador 2");
        HBox.setHgrow(segundoJugador, Priority.ALWAYS);

        HBox.setHgrow(contSegundoJugador, Priority.ALWAYS);

        ventana4.getChildren().addAll(segundoJugador, contSegundoJugador);

        ventana5.getChildren().addAll(ventana2, ventana3, ventana4);
        vContenedor.getChildren().addAll(ventana5);
    }

    private Button boton1Seleccionado = null;
    private Button boton2Seleccionado = null;

    private void revolverCartas(int numeroPares) {
        // Limpiar el GridPane antes de agregar nuevas imágenes
        tecladoMemorama.getChildren().clear();

        // Generar una lista de índices de imágenes aleatorias
        ArrayList<Integer> indicesImagenesAleatorias = new ArrayList<>();
        for (int i = 0; i < numeroPares; i++) {
            indicesImagenesAleatorias.add(i % arrImages.length);
        }

        // Mezclar la lista de índices aleatorios
        Collections.shuffle(indicesImagenesAleatorias);

        // Crear los botones y asignarles las imágenes correspondientes
        ArrayList<Button> botones = new ArrayList<>();
        for (int i = 0; i < numeroPares * 2; i++) {
            Button boton = new Button();
            int indiceImagen = indicesImagenesAleatorias.get(i / 2);
            ImageView imagen = new ImageView(new Image(getClass().getResource("/images/" + arrImages[indiceImagen]).toString()));
            imagen.setFitWidth(100);
            imagen.setFitHeight(100);
            boton.setGraphic(imagen);

            // Establecer un evento de clic para mostrar u ocultar la imagen
            boton.setOnAction(event -> {
                if (boton1Seleccionado == null) {
                    boton1Seleccionado = boton;
                    imagen.setVisible(true);
                } else if (boton1Seleccionado != boton && boton2Seleccionado == null) {
                    boton2Seleccionado = boton;
                    imagen.setVisible(true);
                    // Verificar si las imágenes son iguales
                    if (boton1Seleccionado.getGraphic().equals(boton2Seleccionado.getGraphic())) {
                        // Si son iguales, mantenerlas visibles y restablecer los botones seleccionados
                        boton1Seleccionado = null;
                        boton2Seleccionado = null;
                    } else {
                        // Si no son iguales, ocultar las imágenes después de un breve retraso
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Platform.runLater(() -> {
                                    boton1Seleccionado.getGraphic().setVisible(false);
                                    boton2Seleccionado.getGraphic().setVisible(false);
                                    boton1Seleccionado = null;
                                    boton2Seleccionado = null;
                                });
                                timer.cancel();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                }
            });

            // Ocultar las imágenes por defecto
            imagen.setVisible(false);
            botones.add(boton);
        }

        // Mezclar aleatoriamente la lista de botones
        Collections.shuffle(botones);

        // Agregar los botones al GridPane en un orden aleatorio
        for (int i = 0; i < botones.size(); i++) {
            tecladoMemorama.add(botones.get(i), i % 6, i / 6);
        }
    }


}



