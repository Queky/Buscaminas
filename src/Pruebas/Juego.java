package Pruebas;
import Model.CampoCasilla;

public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	CampoCasilla Tablero=  CampoCasilla.getcampoCasillas();
	//Tablero.inicializar(7, 10);
	Tablero.inicializar("facil");
	Tablero.enseñarTablero();
	
		
		
	}

}
