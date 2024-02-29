package com.example.tap2024.modelos;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Connection {
    private static final String PWD = "123";
    static private String DB= "taqueria";
    static private  String USER= "adminTacos";
    static private String PWN ="1234";
    static public  Connection connection;


    void  crearConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306"+DB+"?allwPublicKeyRetrivieal=true&useSSL=false",USER,PWD);


        }catch (Exception e ){

        }


    }

}
