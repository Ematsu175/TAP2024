package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class CuadroMagico extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private GridPane gdpTablero;
    private TextField txtPantalla;
    private Button boton;
    private HBox hContenedor;
    public CuadroMagico(){
        this.setTitle("Cuadro Magico");
        CrearUI();
        this.setScene(escena);
        this.show();
    }

    private void CrearUI(){
        txtPantalla = new TextField();
        gdpTablero = new GridPane();
        hContenedor = new HBox();
        boton = new Button("Calcular");
        boton.setOnAction(event -> CrearTablero(txtPantalla.getText()));
        hContenedor = new HBox(txtPantalla, boton);
        vContenedor = new VBox(hContenedor, gdpTablero);
        vContenedor.setSpacing(10);
        escena = new Scene(vContenedor);
        escena.getStylesheets().add(getClass().getResource("/estilos/cuadroMagico.css").toString());
    }

    private void CrearTablero(String v) {
        if (v.matches("\\d+")) {
            int valor = Integer.valueOf(v);
            System.out.println("El valor es: " + valor);
            if (valor>=3){
                if ((valor % 2) != 0) {
                    gdpTablero.getChildren().clear();

                    for (int i = 0; i < valor; i++) {
                        for (int j = 0; j < valor; j++) {
                            Label label = new Label(" ");
                            label.setPrefSize(50, 50);
                            label.setId("marco_labels");
                            gdpTablero.add(label, j, i);
                        }
                    }
                    // Ajusta según el tamaño multiplicando la cantidad que hay de anho y se le añade un 20 para que haya un espacio adicional
                    double newWidth = valor * 50 + 20;
                    // Ajusta según el tamaño multiplicando la cantidad que hay de alto y se le añade un 20 para que haya un espacio adicional
                    double newHeight = valor * 50 + 80;
                    this.setWidth(newWidth);
                    this.setHeight(newHeight);
                } else {
                    txtPantalla.setText("Coloque numero impar");
                }
            } else {
                txtPantalla.setText("Valor debe ser mayor a 3");
            }
        } else {
            txtPantalla.setText("Coloque numeros");
        }
    }
}
//git pull se pone solo cuando se usa de manera colaborativa
//git status
//git add .
//git commit -a -m "Screen cuadro magico"
//git push origin main
