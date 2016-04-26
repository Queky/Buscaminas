package Principal;

import Controller.Buscaminas;
import Controller.WindowController;
import Model.Tiempo;
import Model.Usuario;
import Pruebas.PruebaTiempo;
import View.MenuUsuario;
import View.SeleccionNivel;
import View.VentanaBuscaminas;

public class ProgramaPrincipal {
		
	public static void ProgramaPrincipal() {

		// View
		MenuUsuario mU = MenuUsuario.getMenuUsuario();
		SeleccionNivel sN = SeleccionNivel.getSeleccionNivel();
		
		// Model
		Usuario u = Usuario.getUsuario();
		
		// Controller
		WindowController wC = new WindowController();
				
		mU.addController(wC);
		sN.addController(wC);
	}
	
	public static void main(String[] args) {
		ProgramaPrincipal();
	}
}
