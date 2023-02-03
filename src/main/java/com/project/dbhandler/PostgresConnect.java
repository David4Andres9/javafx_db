package com.project.dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnect {
    private final String HOST = "localhost";
    private final String PORT = "5432";
    private final String DB = "javafxdb";
    private final String USER = "David";
    private final String PASSWORD = "David@Puce22";

    public Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+ HOST + ":" + PORT + "/" + DB;
            connection = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Accion ejecutada correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
