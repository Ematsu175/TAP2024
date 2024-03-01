package com.example.tap2024.modelos;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    //private static final String PWD = "123";
    static private String DB= "taqueria";
    static private  String USER= "adminTacos";
    static private String PWN ="123";
    //static public  Connection connection;
    static public Connection conexion;

    public static void crearConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+DB+"?allowPublicKeyRetrivieal=true&useSSL=false",USER,PWN);
            System.out.println("Conexion establecida con exito");
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

}
