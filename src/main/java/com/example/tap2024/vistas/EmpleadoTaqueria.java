package com.example.tap2024.vistas;

import com.example.tap2024.modelos.EmpleadosDA0;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmpleadoTaqueria extends Stage {
    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private TableView<EmpleadosDA0> tbvEmpleados;
    private Scene escena;
    public EmpleadoTaqueria(){
        CrearUI();
        this.setTitle("Taqueria Los Inges :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tlbMenu = new ToolBar();
        CrearTabla();
        vbxPrincipal = new VBox(tlbMenu, tbvEmpleados);
        escena = new Scene(vbxPrincipal, 300, 200);

    }

    private void CrearTabla(){
        tbvEmpleados = new TableView<EmpleadosDA0>();
        TableColumn<EmpleadosDA0, String> tbcNomEmp = new TableColumn<>("Empleado");
        TableColumn<EmpleadosDA0, String> tbcRfcEmp = new TableColumn<>("rfc");
        TableColumn<EmpleadosDA0, Float> tbcSueldo = new TableColumn<>("Sueldo");
        TableColumn<EmpleadosDA0, String> tbcTelEmp = new TableColumn<>("Telefono");
        TableColumn<EmpleadosDA0, String> tbcDir = new TableColumn<>("Direccion");

        tbvEmpleados.getColumns().addAll(tbcNomEmp, tbcRfcEmp, tbcSueldo, tbcTelEmp, tbcDir);

    }

}
