package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CuadroMagico extends Stage {
    private Scene escena;
    public CuadroMagico(){
        this.setTitle("Cuadro Magico");
        this.setScene(new Scene((new Button("Da Click"))));
        this.show();
    }

    private void CrearUI(){
        escena = new Scene(new Button("Da Click"));
    }
}
//git pull se pone solo cuando se usa de manera colaborativa
//git status
//git add .
//git commit -a -m "Screen cuadro magico"
//git push origin main