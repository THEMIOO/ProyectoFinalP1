package com.itla.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBManager {

    private Connection con;
    private Statement stmnt;

    private final String url = "jdbc:mysql://localhost/db_final";
    private final String user = "final";
    private final String password = "123456";

    public void conectarDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return con;
    }
    
    }
