package Model;

public class CampoCasilla {
	
	private Casilla[][] caCasillas;
	private int bombasTotales;
	private int interrrogacionesTotales;
	private static CampoCasilla MCAMPOCASILLAS=new CampoCasilla();
	
		
	public static CampoCasilla getcampoCasillas(){
		
	return MCAMPOCASILLAS;
	}
	
	public CampoCasilla() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Recibe la altura y anchura del tablero, Despues llama a rellenar Tablero
	public void inicializar(int alto, int ancho) {
		
		caCasillas = new Casilla[ancho][alto];
		bombasTotales = (alto+ancho)/2;
		interrrogacionesTotales =0;
		//RellenarTablero(); // lo Comento para hacer una prueba 
		
	}
	
	//Rellena el tablero de casillas sin bombas, despues llama a introducir bombas para rellenarlo y a calcular minas cerca
	public void RellenarTablero(){
		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[i].length; j++) {
				Casilla Casilla01 = new Casilla(false);
				caCasillas[i][j]=Casilla01;
			}
		}
		
		introducirBombas(caCasillas.length, caCasillas[0].length, bombasTotales);
		calcularMinasCerca();
		
	}
		//introduce bombas en el mapa hasta llenar la cantidad
	public void introducirBombas(int alto, int ancho, int cantidadBombas){
		int posx=0;
		int posy=0;
		
		for (int i = 0; i <cantidadBombas; i++) {
			
			posx = (int) (Math.random()*alto+0);
			posy = (int) (Math.random()*ancho+0);
			
			if (caCasillas[posx][posy].esMina()) {
				i--;
			}
			
			Casilla Casilla01 = new Casilla(true);
			caCasillas[posx][posy]=Casilla01;
		}
		
	}
	
	
	public void enseñarTablero(){
		
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
				
			}else{
				
			
				System.out.print(caCasillas[i][j].getMinasCerca());
			}
			}
			System.out.println("");
		}
		
	}
	
	//calcula en las minas vacias cuantas bombas tiene en el perimetro
	public void calcularMinasCerca(){

		for (int i = 0; i < caCasillas.length; i++) {
			for (int j = 0; j < caCasillas[0].length; j++) {
				
				caCasillas[i][j].setMinasCerca(calcularMinasCerca(i,j));
				
			}
		}
	
	}
	
	
	
	public void descubrirCasilla(int posx, int posy, boolean interrogacion){
		
		if (interrogacion) {
			caCasillas[posx][posy].setInterrogacion(true);
			interrrogacionesTotales++;
			
			
			
		}else{
			caCasillas[posx][posy].setVisible(true);
			
			if (caCasillas[posx][posy].esMina()) {
				System.out.println("distes a una bomba, juego terminado");
			}
			if (!caCasillas[posx][posy].esMina()) {
				
				if (caCasillas[posx][posy].getMinasCerca()==0) {
					descubrirCasillaExpansion(posx, posy);
				}
				
				
				System.out.println(caCasillas[posx][posy].getMinasCerca());
			}
			
		}
		
	
		
	}
	
	public void descubrirCasillaExpansion(int posx, int posy){
		
	}
	
	
	
	
	
	public void comprobarjuego(){
		
		if (bombasTotales==interrrogacionesTotales) {
			System.out.println("Terminaste el juego");
		}
		if (interrrogacionesTotales< bombasTotales) {
			System.out.println("demasiadas incognitas");
		}
		if (interrrogacionesTotales> bombasTotales) {
			System.out.println("sigue jugando");
		}
		
	}
	
	
	public int calcularMinasCerca(int posx, int posy){
		
		int resultado=0;
		
		if (!caCasillas[posx][posy].esMina()) {
			for (int i = Math.max(0, posx-1); i <= Math.min(posx+1, caCasillas.length-1); i++) {
				for (int j = Math.max(0, posy-1); j <= Math.min(posy+1, caCasillas[i].length-1); j++) {
					if (caCasillas[i][j].esMina()) {
						resultado++;
					}
				}
			}
		}
		return resultado;
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
		return interrrogacionesTotales;
	}

	public void setInterrrogacionesTotales(int interrrogacionesTotales) {
		this.interrrogacionesTotales = interrrogacionesTotales;
	}

}
