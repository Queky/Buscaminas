package Controller;

import java.util.Observable;

import View.VentanaBuscaminas;

public class Buscaminas extends Observable{
	
	// Atributo que contiene la unica instancia de la clase
	private static Buscaminas mBuscaminas;
	private VentanaBuscaminas ventanaBuscaminas;
	
	
	private Buscaminas() {
		if(mBuscaminas==null){
			mBuscaminas = new Buscaminas();
		}
	}

	public static Buscaminas getBuscaminas() {
		return mBuscaminas;
	}
	
	public void seleccionNivel(String pLevel){
		int nivel = Integer.parseInt(pLevel);
		ventanaBuscaminas = new VentanaBuscaminas();
		ventanaBuscaminas.setNivelElegido(nivel);
		ventanaBuscaminas.inicializarVentana();
	}

}
