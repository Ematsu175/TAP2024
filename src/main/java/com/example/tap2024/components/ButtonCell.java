package com.example.tap2024.components;

import com.example.tap2024.modelos.EmpleadosDA0;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<EmpleadosDA0, String> {
    Button btnCelda;

    public ButtonCell(){
        btnCelda = new Button("Editar");

    }
    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            this.setGraphic(btnCelda);
    }

}