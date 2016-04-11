package Controller;

import java.util.Observable;

import View.SeleccionNivel;
import View.VentanaBuscaminas;

public class Buscaminas extends Observable{
	
	// Atributo que contiene la unica instancia de la clase
	private static Buscaminas mBuscaminas = new Buscaminas();
	private VentanaBuscaminas ventanaBuscaminas;
	
	
	private Buscaminas() {
		// TODO Completar el cuerpo del constructor
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
