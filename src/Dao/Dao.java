package Dao;

import Model.Jugador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Matias on 04/04/2018.
 */
public class Dao {
    private Conexion conn= Conexion.getInstance();

    public void generarJuego(String nombre){
        String dml = "insert into juegos (mesa) values (?);";
        try {
            conn.conectar();
            PreparedStatement st = conn.getConn().prepareStatement(dml);
            st.setString(1, nombre);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarGanador(Jugador jugador){
        String dml = "insert into ganador values ((select max(id) from juegos), ?,?);";
        try {
            conn.conectar();
            PreparedStatement st = conn.getConn().prepareStatement(dml);
            st.setString(1, jugador.getName());
            st.setInt(2,jugador.cantCartas());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
