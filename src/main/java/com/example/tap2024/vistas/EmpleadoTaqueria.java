package com.example.tap2024.vistas;

import com.example.tap2024.components.ButtonCell;
import com.example.tap2024.modelos.EmpleadosDA0;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EmpleadoTaqueria extends Stage {
    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private TableView<EmpleadosDA0> tbvEmpleados;
    private Scene escena;
    private Button btnAgregarEmpleado;

    public EmpleadoTaqueria(){
        CrearUI();
        this.setTitle("Taqueria Los Inges :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        ImageView imvEmpleado = new ImageView(getClass().getResource("/images/employee1.png").toString());
        imvEmpleado.setFitHeight(50);
        imvEmpleado.setFitWidth(50);
        btnAgregarEmpleado = new Button();
        btnAgregarEmpleado.setOnAction(event -> new EmpleadosForm(tbvEmpleados));
        btnAgregarEmpleado.setGraphic(imvEmpleado);
        tlbMenu = new ToolBar(btnAgregarEmpleado);

        CrearTabla();
        vbxPrincipal = new VBox(tlbMenu, tbvEmpleados);
        escena = new Scene(vbxPrincipal, 700, 400);

    }

    private void CrearTabla(){
        tbvEmpleados = new TableView<>();
        EmpleadosDA0 objEmpleado = new EmpleadosDA0();

        TableColumn<EmpleadosDA0, String> tbcNomEmp = new TableColumn<>("Empleado");
        tbcNomEmp.setCellValueFactory(new PropertyValueFactory<>("nomEmpleado"));

        TableColumn<EmpleadosDA0, String> tbcRfcEmp = new TableColumn<>("rfc");
        tbcRfcEmp.setCellValueFactory(new PropertyValueFactory<>("rfcEmpleado"));

        TableColumn<EmpleadosDA0, Float> tbcSueldo = new TableColumn<>("salario");
        tbcSueldo.setCellValueFactory(new PropertyValueFactory<>("salario"));

        TableColumn<EmpleadosDA0, String> tbcTelEmp = new TableColumn<>("Telefono");
        tbcTelEmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<EmpleadosDA0, String> tbcDir = new TableColumn<>("Direccion");
        tbcDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<EmpleadosDA0,String> tbcEditar = new TableColumn<EmpleadosDA0,String>("EDITAR");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<EmpleadosDA0, String>, TableCell<EmpleadosDA0, String>>() {
                    @Override
                    public TableCell<EmpleadosDA0, String> call(TableColumn<EmpleadosDA0, String> empleadosDA0StringTableColumn) {
                        return new ButtonCell();
                    }
                }
        );
        //tbvEmpleados.getColumns().addAll(tbcNomEmp, tbcRfcEmp, tbcSueldo, tbcTelEmp, tbcDir);
        tbvEmpleados.getColumns().addAll(tbcNomEmp, tbcRfcEmp, tbcSueldo, tbcTelEmp, tbcDir,tbcEditar);
        tbvEmpleados.setItems(objEmpleado.CONSULTAR());
    }

}
