package Principal;

import Controller.WindowController;
import Model.Usuario;
import View.MenuUsuario;
import View.SeleccionNivel;

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
