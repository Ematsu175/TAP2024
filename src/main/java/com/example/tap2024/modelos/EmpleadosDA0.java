package com.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadosDA0 {
    int idEmpleado;
    String nomEmpleado;
    String rfcEmpleado;
    float salario;
    String telefono;
    String direccion;



    public  void INSERTAR (){
        String query = "INSERT INTO empleado(nomEmpleado, rfc, salario, telefono, direccion) "
                +"values('"+nomEmpleado+"','"+rfcEmpleado+"',"+salario+",'"+telefono+"','"+direccion+"')";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ACTUALIZAR(){
        String query = "UPDATE empleado set nomEmpleado='"+nomEmpleado+"', rfc='"+rfcEmpleado+ "'" +
                ", salario="+salario+", telefono='"+telefono+"', direccion='"+direccion+"'" +
                " where idEmpleado = "+idEmpleado;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ELIMINAR(){
        String query = "DELETE from empleado where idEmpleado="+idEmpleado;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ObservableList<EmpleadosDA0> CONSULTAR(){
        ObservableList<EmpleadosDA0> listaEmp = FXCollections.observableArrayList();
        String query = "Select * from empleado";
        try {
            EmpleadosDA0 objEmp;
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objEmp = new EmpleadosDA0();
                objEmp.idEmpleado = res.getInt("id_empleado");
                objEmp.nomEmpleado = res.getString("nomEmpleado");
                objEmp.rfcEmpleado = res.getString("rfc");
                objEmp.salario = res.getFloat("salario");
                objEmp.telefono = res.getString("telefono");
                objEmp.direccion = res.getString("direccion");
                listaEmp.add(objEmp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return listaEmp;
    }
}
// Table view con botones anidados
// verticalBox, tableView,
