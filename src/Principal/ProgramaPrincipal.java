package Principal;

import Controller.WindowController;
import Model.CampoCasilla;
import Model.Usuario;
import View.MenuUsuario;
import View.SeleccionNivel;
import View.VentanaBuscaminas;

public class ProgramaPrincipal {
		
	public static void ejecutarPrograma() {

		// View
		MenuUsuario mU = MenuUsuario.getMenuUsuario();
		SeleccionNivel sN = SeleccionNivel.getSeleccionNivel();
		VentanaBuscaminas vN = VentanaBuscaminas.getVentanaBuscaminas();
		
		// Model
		Usuario u = Usuario.getUsuario();
		CampoCasilla cc = CampoCasilla.getcampoCasillas();
		
		
		// Controller
		WindowController wC = new WindowController();
				
		// Add controllers
		mU.addController(wC);
		sN.addController(wC);
		
		// Add observers
		//CampoCasilla.addObserver();
	}
	
	public static void main(String[] args) {
		ejecutarPrograma();
	}
}
