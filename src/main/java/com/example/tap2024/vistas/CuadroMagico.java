package com.example.tap2024.vistas;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class CuadroMagico extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private GridPane gdpTablero;
    private TextField txtPantalla;
    private Button boton, botonArch;
    private HBox hContenedor;
    private Label label;
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
        botonArch = new Button("Archivo");
        boton.setOnAction(event -> CrearTablero(txtPantalla.getText()));
        botonArch.setOnAction(event -> guardarContenidoEnArchivo("C:\\Users\\emyva\\OneDrive\\Escritorio\\8vo semestre\\Topicos Avanzados de Programacion\\ArchivoCuadroMagico",gdpTablero));
        label = new Label();
        hContenedor = new HBox(txtPantalla, boton , botonArch);
        vContenedor = new VBox(hContenedor, gdpTablero);
        vContenedor.setSpacing(10);
        escena = new Scene(vContenedor);
        escena.getStylesheets().add(getClass().getResource("/estilos/cuadroMagico.css").toString());

    }

    private void CrearTablero(String v) {
        int cont = 1;

        if (v.matches("\\d+")) {
            int valor = Integer.valueOf(v);
            System.out.println("El valor es: " + valor);
            if (valor>=3){
                if ((valor % 2) != 0) {
                    gdpTablero.getChildren().clear();
                    for (int i = 0; i < valor; i++) {
                        for (int j = 0; j < valor; j++) {
                            label = new Label();
                            label.setPrefSize(50, 50);
                            label.setId("marco_labels");
                            //label.setText(String.valueOf(cont));
                            gdpTablero.add(label, j, i);
                            cont ++;
                        }
                    }

                    System.out.println("La cntidad de casillas es: "+cont);
                    // Ajusta según el tamaño multiplicando la cantidad que hay de anho y se le añade un 20 para que haya un espacio adicional
                    double newWidth = valor * 50 + 20;
                    // Ajusta según el tamaño multiplicando la cantidad que hay de alto y se le añade un 20 para que haya un espacio adicional
                    double newHeight = valor * 50 + 80;
                    this.setWidth(newWidth);
                    this.setHeight(newHeight);
                    // Resolucion
                    double vd=Double.parseDouble(v);
                    int tam=Integer.valueOf(v)-1;
                    int r=0,c= (int) Math.ceil(vd/2)-1;
                    int id=1;
                    int rant,cant;

                    while(id<=((tam+1)*(tam+1))){
                        System.out.println("id-> "+id+" r -> "+r+"   c-> "+c);
                        Node nodo= getNodeByRowColumnIndex(r,c,gdpTablero);
                        Label label = (Label) nodo;
                        label.setText(String.valueOf(id));
                        id++;
                        rant=r;
                        cant=c;
                        if (r==0) {
                            r = tam;
                        } else {
                            r= r-1;
                        }
                        if(c==tam){
                            c=0;
                        } else {
                            c=c+1;
                        }
                        nodo= getNodeByRowColumnIndex(r,c,gdpTablero);
                        label = (Label) nodo;
                        System.out.println("Valor de label ->" +label.getText());
                        if (  !label.getText().isEmpty()) {
                            System.out.println("Pos Actual label  r -> " + r + "   c-> " + c);
                            r=r-1;
                            if (r<=0) {
                                if (tam==2)
                                    r=tam;
                                else {
                                    r = rant+1;
                                    c = cant+1;
                                }
                            } else {
                                if (tam>2)
                                    r = rant+1;
                            }
                            c=c-1;
                            if (c<0) c=tam;
                            System.out.println("Tiene Valor label  r -> "+r+"   c-> "+c);
                        }

                    }
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
    private void guardarContenidoEnArchivo(String rutaCompleta, GridPane gridPane) {
        File file = new File(rutaCompleta);
        // Eliminar el archivo anterior si existe
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo anterior eliminado: " + rutaCompleta);
            } else {
                System.err.println("No se pudo eliminar el archivo anterior: " + rutaCompleta);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Node node : gridPane.getChildren()) {
                if (node instanceof Label) {
                    Label label = (Label) node;
                    String contenido = label.getText();
                    writer.write(contenido + ", ");
                }
            }
            System.out.println("Contenido guardado en el archivo: " + rutaCompleta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

}
//git pull se pone solo cuando se usa de manera colaborativa
//git status
//git add .
//git commit -a -m "Screen cuadro magico"
//git push origin main
