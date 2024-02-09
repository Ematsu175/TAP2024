package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button[][] arrBotones = new Button[4][4];
    private char[] arrEtiquetas = {'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};
    public Calculadora() {
        CrearUI();
        this.setTitle("Calculadora");
        this.setScene(escena);
        this.show();
    }
    //... en java significa que se espera un arreglo
    private void CrearUI(){
        txtPantalla = new TextField("0");
        gdpTeclado = new GridPane();
        CrearTeclado();
        vContenedor = new VBox(txtPantalla, gdpTeclado);
        vContenedor.setSpacing(5);
        escena = new Scene(vContenedor, 200,200);
    }

    private void CrearTeclado() {
        int pos = 0;
        char simbolo;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrBotones[i][j] =  new Button(arrEtiquetas[pos]+"");
                arrBotones[i][j].setPrefSize(50,50);
                int finalPos = pos;
                arrBotones[i][j].setOnAction(event -> setValue(arrEtiquetas[finalPos]));
                gdpTeclado.add(arrBotones[i][j],j,i);
                pos++;
            }
        }
    }

    private void setValue(char simbolo) {
        txtPantalla.appendText(simbolo+"");
    }
}
