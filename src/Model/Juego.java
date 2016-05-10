package Model;

import Pruebas.CampoDeCasillas;

/**
 * 
 * @author inakisanchez
 */
public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		Casilla Casilla00 = new Casilla(true);
//		Casilla Casilla01 = new Casilla(false);
//		Casilla Casilla02 = new Casilla(false);
//		Casilla Casilla10 = new Casilla(false);
//		Casilla Casilla11 = new Casilla(true);
//		Casilla Casilla12 = new Casilla(false);
//		Casilla Casilla20 = new Casilla(false);
//		Casilla Casilla21 = new Casilla(true);
//		Casilla Casilla22 = new Casilla(false);
		
		Casilla[][] CampoDeCasillas1= new Casilla[2][2];
		
	/*	CampoDeCasillas1[0][0]=Casilla00;
		if (CampoDeCasillas1[0][0].esMina()) {
			System.out.println("true");
		}
		if (!CampoDeCasillas1[0][0].esMina()) {
			System.out.println("false");
			} */
		
		
	CampoDeCasillas Tablero= new CampoDeCasillas(9,9);
	//CampoDeCasillas Tablero= new CampoDeCasillas("dificil");
	Tablero.EnseñarTablero();

		
	//	CampoDeCasillas CampoDeCasillas1= new CampoDeCasillas[][](null, 2, 2);
		
		
	}

}
