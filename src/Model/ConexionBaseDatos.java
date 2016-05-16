package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBaseDatos {
	
	private static ConexionBaseDatos conBD = new ConexionBaseDatos();
	
	public static void guardarUsuario(){
		Connection con = null;
		Statement st = null;
		Usuario u = Usuario.getUsuario();
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:./BaseDatos/buscaminas.db");
			System.out.println("Opened database successfully");
			String sql = "insert into usuarios (nombre, puntuacion, dificultad) values"
						 + " ('"+u.getNombre()+"', "+u.getPuntuacionMaxima()+", "+u.getNivelElegido()+")";
			System.out.println(sql);
			st = con.createStatement();
			st.executeUpdate("insert into usuarios (nombre, puntuacion, dificultad) values ('inaki2', '2500', '3')");	
			st.close();
			con.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
  }
	  
	  private ConexionBaseDatos() {
		  
	  }
	  
	  public static ConexionBaseDatos getConexion(){
		  return conBD;
	  }
	  
	  public static void main(String[] args) {
		guardarUsuario();
	}
}
