
package model;

import java.util.Observable;
import java.util.Observer;

public class CampoCasilla extends Observable implements Observer{

	private Casilla[][] caCasillas;
	private int bombasTotales;
	private int banderasTotales;
	private static CampoCasilla MCAMPOCASILLAS = new CampoCasilla();
	
	public static CampoCasilla getcampoCasillas(){
		return MCAMPOCASILLAS;
	}

	public CampoCasilla() {

	}
	
	// Rellena el tablero de casillas sin bombas, despues llama a introducir
	// bombas para rellenarlo y a clacular minas cerca
	public void rellenarTablero() {
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
		banderasTotales = bombas;
		rellenarTablero();

	}

	// introduce bombas en el mapa hasta llenar la cantidad
	public void introducirBombas(int x, int y) {
		int posx = 0;
		int posy = 0;

		for (int i = 0; i < bombasTotales; i++) {

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

	public boolean comprobarjuego() {
		boolean minasBienMarcadas = false;
		for (int i = 0; i < caCasillas.length ; i++) {
			for (int j = 0; j < caCasillas[i].length; j++) {
				if(caCasillas[i][j].esMina()){
					if(caCasillas[i][j].tieneBandera())
						minasBienMarcadas = true;
					else
						minasBienMarcadas = false;
				}
			}
		}
		return minasBienMarcadas;
	}
	
	public boolean casillasDescubiertas(){
		
		boolean todasDesmarcadas = false;
		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[i].length && !caCasillas[i][j].esMina(); j++) {
				if(caCasillas[i][j].getEstado() instanceof Casilla.Visible)
					todasDesmarcadas = true;
				else
					return false;
			}
		}
		return todasDesmarcadas;
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

	@Override
	public void update(Observable o, Object arg) {
		Casilla casilla = (Casilla) o;
		if (arg instanceof Casilla.Visible) {
			if (!casilla.esMina()) {
				if (casilla.getMinasCerca() == 0) {
					descubrirCasillaExpansion(casilla.getCoordX(), casilla.getCoordY());
				}
			}
		}
		if (arg instanceof Casilla.Bandera && banderasTotales >= 0) {
			banderasTotales--;
			if(banderasTotales > 0)
				casilla.marcarBandera();
		}

		if (arg instanceof Casilla.NoVisible && banderasTotales >= -1) {
			banderasTotales++;
			casilla.desmarcarBandera();
		}
		setChanged();
		notifyObservers(casilla);
		comprobarjuego();

	}
	
	public void reiniciarCasillas(){
		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[i].length; j++) {
				caCasillas[i][j].reiniciarCasilla(i, j);
			}
		}
		banderasTotales = bombasTotales;
	}
	public int minasRestantes(){
		return banderasTotales;
	}
}
