package com.example.tap2024.vistas;

import com.example.tap2024.modelos.EmpleadosDA0;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.TabableView;

public class EmpleadosForm extends Stage {
    private TableView<EmpleadosDA0> tbvEmpleados;
    private EmpleadosDA0 objEmp;
    String[] arrProm = {"Nombre del empleado","RFC del empleado","Sueldo del empleado","Telefono del empleado","Direccion del empleado"};
    private Scene escena;
    private TextField[] arrTxtCampos = new TextField[5];
    private Button btnGuardar;
    private VBox vboxPrincipal;
    public EmpleadosForm(TableView<EmpleadosDA0> tbvEmp, EmpleadosDA0 objEmp){
        tbvEmpleados = tbvEmp;
        this.objEmp = (objEmp == null) ? new EmpleadosDA0() : objEmp;
        CrearUI();
        this.setTitle("Insertar Usuarios");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vboxPrincipal = new VBox();
        vboxPrincipal.setSpacing(10);
        vboxPrincipal.setAlignment(Pos.CENTER);
        for (int i = 0; i < arrTxtCampos.length; i++) {
            arrTxtCampos[i] = new TextField();
            arrTxtCampos[i].setPromptText(arrProm[i]);
            vboxPrincipal.getChildren().add(arrTxtCampos[i]);
        }
        LlenarForm();
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> GuardarEmpleado());
        vboxPrincipal.getChildren().add(btnGuardar);
        escena = new Scene(vboxPrincipal, 350, 250);
    }

    private void LlenarForm() {
        arrTxtCampos[0].setText(objEmp.getNomEmpleado());
        arrTxtCampos[1].setText(objEmp.getRfcEmpleado());
        arrTxtCampos[2].setText(String.valueOf(objEmp.getSalario()));
        arrTxtCampos[3].setText(objEmp.getTelefono());
        arrTxtCampos[4].setText(objEmp.getDireccion());
    }

    private void GuardarEmpleado() {
        objEmp.setNomEmpleado(arrTxtCampos[0].getText());
        objEmp.setRfcEmpleado(arrTxtCampos[1].getText());
        objEmp.setSalario(Float.parseFloat(arrTxtCampos[2].getText()));
        objEmp.setTelefono(arrTxtCampos[3].getText());
        objEmp.setDireccion(arrTxtCampos[4].getText());
        if(objEmp.getIdEmpleado() > 0){
            objEmp.ACTUALIZAR();
        } else {
            objEmp.INSERTAR();
        }
        tbvEmpleados.setItems(objEmp.CONSULTAR());
        tbvEmpleados.refresh();

        arrTxtCampos[0].clear();
        arrTxtCampos[1].clear();
        arrTxtCampos[2].clear();
        arrTxtCampos[3].clear();
        arrTxtCampos[4].clear();
    }


}
