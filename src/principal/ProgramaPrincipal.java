package principal;

import controller.WindowController;
import model.CampoCasilla;
import model.ConexionBaseDatos;
import model.Usuario;
import view.MenuUsuario;
import view.Puntuaciones;
import view.SeleccionNivel;
import view.VentanaBuscaminas;
public class ProgramaPrincipal {
		
	public static void ejecutarPrograma() {

		ConexionBaseDatos conBD = ConexionBaseDatos.getConexion();
		conBD.obtenerPuntuaciones();
		
		// view
		MenuUsuario mU = MenuUsuario.getMenuUsuario();
		SeleccionNivel sN = SeleccionNivel.getSeleccionNivel();
		VentanaBuscaminas.getVentanaBuscaminas();
		Puntuaciones punt = Puntuaciones.getVentanaPuntuaciones();
		
		Usuario.getUsuario();
		CampoCasilla.getcampoCasillas();
		
		
		// controller
		WindowController wC = new WindowController();
				
		// Add controllers

		mU.addController(wC);
		sN.addController(wC);
		punt.addController(wC);		
		
		// Add observers
		//CampoCasilla.addObserver();
	}
	
	public static void main(String[] args) {
		ejecutarPrograma();
	}
}
