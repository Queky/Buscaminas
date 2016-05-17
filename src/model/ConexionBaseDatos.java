package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBaseDatos{
	
	private String puntNivel1;
	private String puntNivel2;
	private String puntNivel3;
	private static ConexionBaseDatos conBD = new ConexionBaseDatos();
	
	public void guardarUsuario(){
		Connection con = null;
		Statement st = null;
		Usuario u = Usuario.getUsuario();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:./BaseDatos/buscaminas.db");
			String sql = "insert into usuarios (nombre, puntuacion, dificultad) values"
						 + " ('"+u.getNombre()+"', "+u.getPuntuacionMaxima()+", "+u.getNivelElegido()+")";
			st = con.createStatement();
			st.executeUpdate(sql);	
			st.close();
			con.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		obtenerPuntuaciones();
	}
	  
	private ConexionBaseDatos() {
		  
	}
	
	public void obtenerPuntuaciones(){
		Connection con = null;
		Statement st = null;
		Usuario.getUsuario();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:./BaseDatos/buscaminas.db");
			String sqlNivel1 = "select nombre, puntuacion from usuarios where dificultad = 1 order by puntuacion desc limit 10";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlNivel1);
			puntNivel1 = "\t\tNivel 1\n\n";
			int pos = 1;
			while(rs.next()){
				puntNivel1 += "\t" +pos+ ".- " + rs.getString("nombre")+ "\t\t" + rs.getString("puntuacion") + "\n";
				pos++;
			}
			
			puntNivel2 = "\t\tNivel 2\n\n";
			String sqlNivel2 = "select nombre as nombre, puntuacion from usuarios where dificultad = 2 limit 10";
			st = con.createStatement();
			rs = st.executeQuery(sqlNivel2);
			pos = 1;
			while(rs.next()){
				puntNivel2 += "\t" +pos+ ".- " + rs.getString("nombre")+ "\t\t" + rs.getString("puntuacion") + "\n";
				pos++;
			}
			
			puntNivel3 = "\t\tNivel 3\n\n";
			String sqlNivel3 = "select nombre as nombre, puntuacion from usuarios where dificultad = 3 limit 10";
			st = con.createStatement();
			rs = st.executeQuery(sqlNivel3);
			pos = 1;
			while(rs.next()){
				puntNivel3 += "\t" +pos+ ".- " + rs.getString("nombre")+ "\t\t" + rs.getString("puntuacion") + "\n";
				pos++;
			}
			st.close();
			con.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
	  
	public static ConexionBaseDatos getConexion(){
		return conBD;
	}
	
	public String getPunt1(){
		return puntNivel1;
	}
	
	public String getPunt2(){
		return puntNivel2;
	}
	
	public String getPunt3(){
		return puntNivel3;
	}
}
