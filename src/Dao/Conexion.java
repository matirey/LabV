package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Matias on 04/04/2018.
 */
public class Conexion {

    private Connection conn;
    private static Conexion instance;

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Conexion() {
        try {
            this.verificarDriver();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void conectar() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3", "root", "matipc");
        } catch (SQLException e) {
            System.err.println("SQLexception: " + e.getMessage());
            throw e;
        }
    }

    private void verificarDriver() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
            throw e;
        }
    }

    public void desconectar() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public Connection getConn() {
        return conn;
    }
}
