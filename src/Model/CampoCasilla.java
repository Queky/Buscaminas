
package Model;

import java.time.Duration;
import java.util.Observable;
import java.util.Observer;

public class CampoCasilla implements Observer {


	private Casilla[][] caCasillas;
	private int bombasTotales;
	private int banderasTotales;
	private static CampoCasilla MCAMPOCASILLAS = new CampoCasilla();
	private Usuario user;

	public static CampoCasilla getcampoCasillas() {

		return MCAMPOCASILLAS;
	}

	public CampoCasilla() {


	}
	// Recibe la altura y anchura del tablero, Despues llama a rellenar Tablero
	public void inicializar(int alto, int ancho) {

		caCasillas = new Casilla[ancho][alto];

		bombasTotales = (alto+ancho)/2;
		banderasTotales =0;
		RellenarTablero(); // lo Comento para hacer una prueba 
		
	}
	
	// Rellena el tablero de casillas sin bombas, despues llama a introducir
	// bombas para rellenarlo y a clacular minas cerca
	public void RellenarTablero() {
		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[i].length; j++) {
				Casilla Casilla01 = new Casilla(false);
				caCasillas[i][j] = Casilla01;
			}
		}

		introducirBombas(caCasillas.length, caCasillas[0].length, bombasTotales);
		calcularMinasCerca();

	}
	
	
	

	public void inicializar(String dificultad) {
		int ancho = 0;
		int alto = 0;
		int bombas = 0;
		if (dificultad.equals("facil")) {
			ancho = 7;
			alto = 10;
			bombas = ancho;
		} else {
			if (dificultad.equals("medio")) {
				ancho = 10;
				alto = 15;
				bombas = ancho * 2;
			} else {
				if (dificultad.equals("dificil")) {
					ancho = 12;
					alto = 25;
					bombas = ancho * 3;
				}

			}

		}

		caCasillas = new Casilla[alto][ancho];
		// bombasTotales = (alto + ancho) / 2;
		bombasTotales = bombas;
		banderasTotales = 0;
		RellenarTablero();

	}

	// Rellena el tablero de casillas sin bombas, despues llama a introducir
	// bombas para rellenarlo y a clacular minas cerca
	public void RellenarTablero1() {

		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[i].length; j++) {
				Casilla Casilla01 = new Casilla(false);
				caCasillas[i][j] = Casilla01;
			}
		}

		introducirBombas(caCasillas.length, caCasillas[0].length, bombasTotales);
		calcularMinasCerca();

	}

	// introduce bombas en el mapa hasta llenar la cantidad
	public void introducirBombas(int alto, int ancho, int cantidadBombas) {
		int posx = 0;
		int posy = 0;

		for (int i = 0; i < cantidadBombas; i++) {

			posx = (int) (Math.random() * alto + 0);
			posy = (int) (Math.random() * ancho + 0);

			if (caCasillas[posx][posy].esMina()) {
				i--;
			}

			Casilla Casilla01 = new Casilla(true);
			caCasillas[posx][posy] = Casilla01;
		}

	}

	// calcula en las minas vacias cuantas bombas tiene en el perimetro
	public void calcularMinasCerca() {

		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[0].length; j++) {

				caCasillas[i][j].setMinasCerca(calcularMinasCerca(i, j));

			}
		}

	}

	public int calcularMinasCerca(int posx, int posy) {

		int resultado = 0;

		if (!caCasillas[posx][posy].esMina()) {
			for (int i = Math.max(0, posx - 1); i <= Math.min(posx + 1, caCasillas.length - 1); i++) {
				for (int j = Math.max(0, posy - 1); j <= Math.min(posy + 1, caCasillas[i].length - 1); j++) {
					if (caCasillas[i][j].esMina()) {
						resultado++;
					}
				}
			}
		}
		return resultado;
	}

	public void descubrirCasilla(int posx, int posy, boolean derecho, boolean izquierdo) {
		
		if (derecho) {
			caCasillas[posx][posy].getEstado().botonDerecho();
		}
		if (izquierdo) {
			caCasillas[posx][posy].getEstado().botonIzquierdo();
		}
	
	}

	public void descubrirCasillaExpansion(int posx, int posy) {
		// tiene como precondicion que la casilla no tenga bombas y
		// getMinasCerca sea 0, de todas formas lo vuelvo a comprobar

		if (caCasillas[posx][posy].getMinasCerca() == 0 && caCasillas[posx][posy].esMina() == false) {
			//caCasillas[posx][posy].setVisible(true);
			for (int i = Math.max(0, posx - 1); i <= Math.min(posx + 1, caCasillas.length - 1); i++) {
				for (int j = Math.max(0, posy - 1); j <= Math.min(posy + 1, caCasillas[i].length - 1); j++) {

					descubrirCasillaExpansion(i, j);
				}
			}

		}
	}

	public void comprobarjuego() {

		if (bombasTotales == banderasTotales) {
			System.out.println("Terminaste el juego");
			System.out.println(user);
		}
		if (banderasTotales < bombasTotales) {
			System.out.println("demasiadas incognitas");
		}
		if (banderasTotales > bombasTotales) {
			System.out.println("sigue jugando");
		}

	}

	public void enseñarTablero() {

		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[0].length; j++) {
				if (caCasillas[i][j].esMina()) {
					System.out.print("X");
				} else {
					System.out.print("0");
				}

			}
			System.out.println("");
		}

		System.out.println("");

		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[0].length; j++) {
				if (caCasillas[i][j].esMina()) {
					System.out.print("X");

				} else {

					System.out.print(caCasillas[i][j].getMinasCerca());
				}
			}
			System.out.println("");
		}

	}

	public Casilla[][] getCampoCasillas() {
		return caCasillas;
	}

	public void setCampoCasillas(Casilla[][] campoCasillas) {
		this.caCasillas = campoCasillas;
	}

	public int getBombasTotales() {
		return bombasTotales;
	}

	public void setBombasTotales(int bombasTotales) {
		this.bombasTotales = bombasTotales;
	}

	public int getInterrrogacionesTotales() {
		return banderasTotales;
	}

	public void setInterrrogacionesTotales(int interrrogacionesTotales) {
		this.banderasTotales = interrrogacionesTotales;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		
		if (((State) arg).toString().equals("NoVisible") ) {
			
		}
	
		
		// TODO Auto-generated method stub
		
	}

}
