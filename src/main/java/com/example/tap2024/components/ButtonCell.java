package com.example.tap2024.components;

import com.example.tap2024.modelos.EmpleadosDA0;
import com.example.tap2024.vistas.EmpleadosForm;
import javafx.scene.control.*;

import java.util.Optional;

public class ButtonCell extends TableCell<EmpleadosDA0, String> {
    Button btnCelda;
    int opc;
    EmpleadosDA0 objEmp;

    public ButtonCell(int opc){
        this.opc=opc;
        String txtButton = (opc == 1) ? "Editar" : "Eliminar";
        btnCelda = new Button(txtButton);
        btnCelda.setOnAction(event -> AccionBoton(opc));
    }

    private void AccionBoton(int opc) {
        TableView<EmpleadosDA0> tbvEmpleados = ButtonCell.this.getTableView();
        objEmp = tbvEmpleados.getItems().get(ButtonCell.this.getIndex());
        if(opc == 1){
            //Editar
            new EmpleadosForm(tbvEmpleados, objEmp);
        } else {
            //Eliminar
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje del sistema");
            alert.setHeaderText("Confirmacion de Accion");
            alert.setContentText("¿Deseas borrar el empleado:"+objEmp.getNomEmpleado()+" ?");
            Optional<ButtonType> resul = alert.showAndWait();
            if(resul.get() == ButtonType.OK){
                objEmp.ELIMINAR();
                tbvEmpleados.setItems(objEmp.CONSULTAR());
                tbvEmpleados.refresh();
            }

        }
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            this.setGraphic(btnCelda);
    }

}
