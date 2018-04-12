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

    public void guardarResultado(Object arg){
        if(arg instanceof Jugador) {
            Jugador j= (Jugador)arg;
            String dml = "insert into resultados values ((select max(id) from juegos), ?,?);";
            try {
                conn.conectar();
                PreparedStatement st = conn.getConn().prepareStatement(dml);
                st.setString(1, j.getNombre());
                st.setInt(2, j.getPuntaje());
                st.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(arg.equals(false)){
            String dml = "insert into resultados values ((select max(id) from juegos), ?,?);";
            try {
                conn.conectar();
                PreparedStatement st= conn.getConn().prepareStatement(dml);
                st.setString(1,"empate");
                st.setInt(2,12);
                st.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
