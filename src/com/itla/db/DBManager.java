package com.itla.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DBManager {

    private Connection con;
    private Statement stmnt;

    private final String url = "jdbc:mysql://localhost/db_final";
    private final String user = "final";
    private final String password = "123456";

    public void conectarDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmnt = con.createStatement();

            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectarDB() {
        try {
            if (con != null) {
                con.close();
            }
            System.out.println("Desconectado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
