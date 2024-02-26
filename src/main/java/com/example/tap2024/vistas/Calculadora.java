package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.auth.callback.ConfirmationCallback;
import java.util.Timer;

public class Calculadora extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private VBox contenedorMensaje;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button[][] arrBotones = new Button[4][4];
    private char[] arrEtiquetas = {'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};
    private String[] arrOperadores = new String[100];
    int arrCont=0;
    String token="";
    private char operador;
    private double valorAnterior=0;
    private String numero1, numero2;
    private float n1, n2, resultado;
    public Calculadora() {
        CrearUI();
        this.setTitle("Calculadora");
        this.setScene(escena);
        this.show();
    }
    //... en java significa que se espera un arreglo
    private void CrearUI(){
        txtPantalla = new TextField();
        gdpTeclado = new GridPane();
        CrearTeclado();
        vContenedor = new VBox(txtPantalla, gdpTeclado);
        vContenedor.setSpacing(5);
        escena = new Scene(vContenedor, 200,200);
        escena.getStylesheets().add(getClass().getResource("/estilos/calculadora.css").toString());
    }

    private void CrearTeclado() {
        int cont = 0;
        int pos = 0;
        char simbolo;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrBotones[i][j] =  new Button(arrEtiquetas[pos]+"");
                arrBotones[i][j].setPrefSize(50,50);
                int finalPos = pos;
                arrBotones[i][j].setOnAction(event -> escritura(String.valueOf(arrEtiquetas[finalPos])));
                //arrBotones[i][j].setOnAction(event -> setValue(arrEtiquetas[finalPos]));
                gdpTeclado.add(arrBotones[i][j],j,i);

                if(arrEtiquetas[pos] == '+' || arrEtiquetas[pos] == '-' || arrEtiquetas[pos] == '*' || arrEtiquetas[pos] == '/')
                    arrBotones[i][j].setId("color-operador");

                pos++;
            }
        }
    }
    private void setValue(char simbolo) {
        txtPantalla.appendText(simbolo + "");
    }
    private String escritura(String v){
        System.out.println("Entra al metodo escritura: "+ v);
        switch (v){
            case "0":
                token+="0";
                txtPantalla.setText(token);
                break;
            case "1":
                System.out.println("Entramos al case 1");
                token+="1";
                txtPantalla.setText(token);
                break;
            case "2":
                token+="2";
                txtPantalla.setText(token);
                break;
            case "3":
                token+="3";
                txtPantalla.setText(token);
                break;
            case "4":
                token+="4";
                txtPantalla.setText(token);
                break;
            case "5":
                token+="5";
                txtPantalla.setText(token);
                break;
            case "6":
                token+="6";
                txtPantalla.setText(token);
                break;
            case "7":
                System.out.println("Estamos en el case 7");
                token+="7";
                txtPantalla.setText(token);
                break;
            case "8":
                token+="8";
                txtPantalla.setText(token);
                break;
            case "9":
                token+="9";
                txtPantalla.setText(token);
                break;
            case ".":
                token+=".";
                txtPantalla.setText(token);
                break;
            case "+":
                System.out.println("Entramos al case +  token -" + token + "-");
                arrOperadores[arrCont] = token;
                if (arrCont>0 && arrOperadores[arrCont].equals("")) {
                    txtPantalla.setText("No se puede poner doble operador");
                }
                arrCont++;
                arrOperadores[arrCont] = "+";
                arrCont++;
                for (int i = 0; i < arrOperadores.length; i++) {
                    if(arrOperadores[i] != null)
                        System.out.println("Valor - "+arrOperadores[i]);
                }
                token="";
                //txtPantalla.clear();
                break;
            case "-":
                System.out.println("Entramos al case -");
                arrOperadores[arrCont] = token;
                if (arrCont>0 && arrOperadores[arrCont].equals("")) {
                    txtPantalla.setText("No se puede poner doble operador");
                }
                arrCont++;
                arrOperadores[arrCont] = "-";
                arrCont++;
                for (int i = 0; i < arrOperadores.length; i++) {
                    if(arrOperadores[i] != null)
                        System.out.println(arrOperadores[i]);
                }
                token="";
                //txtPantalla.clear();
                break;
            case "*":
                System.out.println("Entramos al case *");
                arrOperadores[arrCont] = token;
                if (arrCont>0 && arrOperadores[arrCont].equals("")) {
                    txtPantalla.setText("No se puede poner doble operador");
                }
                arrCont++;
                arrOperadores[arrCont] = "*";
                arrCont++;
                for (int i = 0; i < arrOperadores.length; i++) {
                    if(arrOperadores[i] != null)
                        System.out.println(arrOperadores[i]);
                }
                token="";
                //txtPantalla.clear();
                break;
            case "/":
                System.out.println("Entramos al case /");
                arrOperadores[arrCont] = token;
                if (arrCont>0 && arrOperadores[arrCont].equals("")) {
                    txtPantalla.setText("No se puede poner doble operador");
                }
                arrCont++;
                arrOperadores[arrCont] = "/";
                arrCont++;
                for (int i = 0; i < arrOperadores.length; i++) {
                    if(arrOperadores[i] != null)
                        System.out.println(arrOperadores[i]);
                }
                token="";
                //txtPantalla.clear();
                break;
            case "=":
                arrOperadores[arrCont] = token;
                arrCont++;
                arrOperadores[arrCont] = "=";
                double total=0;
                double numero=0;

                total = Double.parseDouble(arrOperadores[0]);
                System.out.println("Total: "+ total);
                String operador = "";
                for (int i = 1; i < arrOperadores.length; i++) {
                    if (arrOperadores[i] != null && !arrOperadores[i].equals("+") && !arrOperadores[i].equals("-")
                            && !arrOperadores[i].equals("*") && !arrOperadores[i].equals("/"))  {
                        if ( !arrOperadores[i].equals("=")) {
                            numero = Double.parseDouble(arrOperadores[i]);
                        }
                        switch (operador) {
                            case "+":
                                total = total + numero ;
                                numero = 0;
                                operador = "";
                                System.out.println("Total case: "+ total);
                                break;
                            case "-":
                                total = total - numero;
                                numero = 0;
                                operador = "";
                                System.out.println("Total case: "+ total);
                                break;
                            case "*":
                                total = total * numero;
                                numero = 0;
                                operador = "";
                                System.out.println("Total case: "+ total);
                                break;
                            case "/":
                                if (numero == 0) {
                                    txtPantalla.setText("No se puede dividir entre 0");
                                    return v;
                                }
                                total = total / numero;
                                numero = 0;
                                operador = "";
                                System.out.println("Total case: " + total);
                                break;
                        }
                    } else {
                        System.out.println("operador: "+operador);
                        operador = arrOperadores[i];

                    }
                }
                token=String.valueOf(total);
                System.out.println(token);
                txtPantalla.setText(token);
                break;
        }
        //System.out.println("Token: "+token);
        //txtPantalla.setText(token);
        return v;
    }

}
