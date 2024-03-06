package com.example.tap2024.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class EmpleadosDA0 {
    private int idEmpleado;
    private String nomEmpleado;
    private String rfcEmpleado;
    private float salario;
    private String telefono;
    private String direccion;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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
                " where id_empleado = "+idEmpleado;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ELIMINAR(){
        String query = "DELETE from empleado where id_empleado="+idEmpleado;
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
