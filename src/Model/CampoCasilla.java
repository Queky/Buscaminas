
package Model;

import java.util.Observable;
import java.util.Observer;

import View.VentanaBuscaminas;

public class CampoCasilla extends Observable implements Observer{

	private Casilla[][] caCasillas;
	private int bombasTotales;
	private int banderasTotales;
	private static CampoCasilla MCAMPOCASILLAS = new CampoCasilla();
	private Usuario user;
	

	public static CampoCasilla getcampoCasillas(){
		return MCAMPOCASILLAS;
	}

	public CampoCasilla() {

	}


	public void RellenarTablero() {
		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[i].length; j++) {
				Casilla Casilla01 = new Casilla(false, i, j);
				caCasillas[i][j] = Casilla01;
				caCasillas[i][j].addObserver(MCAMPOCASILLAS);
			}
		}
	}

	public void inicializar(int dificultad) {
		int ancho = 0;
		int alto = 0;
		int bombas = 0;
		if (dificultad==1) {
			ancho = 7;
			alto = 10;
			bombas = ancho;
		} else {
			if (dificultad==2) {
				ancho = 10;
				alto = 15;
				bombas = ancho * 2;
			} else {
				if (dificultad==3) {
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

	// introduce bombas en el mapa hasta llenar la cantidad
	public void introducirBombas(int cantidadBombas, int x, int y) {
		int posx = 0;
		int posy = 0;

		for (int i = 0; i < cantidadBombas; i++) {

			posx = (int) (Math.random() * caCasillas.length + 0);
			posy = (int) (Math.random() * caCasillas[0].length + 0);

			if (caCasillas[posx][posy].esMina()) {
				i--;
			}
			
			if (!(posx==x && posy==y)) {
				caCasillas[posx][posy].setTieneMina(true);
			}
			if ((posx==x && posy==y)) {
				i--;
				}
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

		if (caCasillas[posx][posy].getMinasCerca() == 0 && caCasillas[posx][posy].esMina() == false ) {
			for (int i = Math.max(0, posx - 1); i <= Math.min(posx + 1, caCasillas.length - 1); i++) {
				for (int j = Math.max(0, posy - 1); j <= Math.min(posy + 1, caCasillas[i].length - 1); j++) {

					if (caCasillas[i][j].esMina() == false) {
						caCasillas[i][j].getEstado().botonIzquierdo();
						
						if (caCasillas[i][j].getMinasCerca() == 0 && !(caCasillas[posx][posy].getEstado() instanceof Casilla.Visible)) {
							descubrirCasillaExpansion(i, j);

						}

					}
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

	public void gameOver() {

		System.out.println("GAME OVER NOOB");
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
		System.out.println("entra update");
		Casilla casilla = (Casilla) o;
		//VentanaBuscaminas ventBuscaminas = VentanaBuscaminas.getVentanaBuscaminas();
		if (arg instanceof Casilla.Visible) {
			if (casilla.esMina()) {
				gameOver();
				System.out.println("game over");
			}
			if (!casilla.esMina()) {
				if (casilla.getMinasCerca() == 0) {
					descubrirCasillaExpansion(casilla.getCoordX(), casilla.getCoordY());
				}
				if (casilla.getMinasCerca() != 0) {
					System.out.println(casilla.getMinasCerca());
				}

			}

		}

		if (arg instanceof Casilla.Bandera) {

			banderasTotales++;

		}

		if (arg instanceof Casilla.NoVisible) {

			banderasTotales--;

		}
		// Mark for change
		setChanged();
		//Notify observer class
		notifyObservers(casilla);
		comprobarjuego();

	}

}
