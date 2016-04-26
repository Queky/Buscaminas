package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Usuario;

public class Buscaminas implements ActionListener{
	
	// Atributo que contiene la unica instancia de la clase
	private static Buscaminas mBuscaminas = new Buscaminas();
	
	private Buscaminas() {

	}

	public static Buscaminas getBuscaminas() {
		return mBuscaminas;
	}
	
	public void seleccionNivel(String pLevel){
		int nivelElegido = Integer.parseInt(pLevel);
		Usuario u = Usuario.getUsuario();
		u.setNivelElegido(nivelElegido);
	}

	@Override
	public void actionPerformed(ActionEvent pE) {
		// TODO Auto-generated method stub
		System.out.println(pE.paramString());
	}

}
