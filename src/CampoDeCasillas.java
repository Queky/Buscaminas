
public class CampoDeCasillas {
	private Casilla[][] CampoCasillas;
	
	


	
	public CampoDeCasillas(String dificultad) {
	
		if (dificultad.equals("facil")) {
			CampoCasillas=new Casilla[5][5]; 					
		}
		if (dificultad.equals("medio")) {
			CampoCasillas=new Casilla[10][10]; 
		}
		if (dificultad.equals("dificil")) {
			CampoCasillas=new Casilla[20][20]; 
	
		}
		RellenarTablero();
	}
	
	public void RellenarTablero(){
		for (int i = 0; i < CampoCasillas.length; i++) {
			for (int j = 0; j < CampoCasillas[i].length; j++) {
				Casilla Casilla01 = new Casilla(false);
				CampoCasillas[i][j]=Casilla01;
			}
		}
		
		IntroducirBombas(CampoCasillas.length, CampoCasillas[0].length, (CampoCasillas.length+CampoCasillas[0].length)/2);
		
	}
	
	public CampoDeCasillas(int alto, int ancho) {
		CampoCasillas = new Casilla[ancho][alto];
		RellenarTablero();
		
	}
	
	public void IntroducirBombas(int alto, int ancho, int cantidadBombas){
		int posx=0;
		int posy=0;
		
		for (int i = 0; i <cantidadBombas; i++) {
			
			posx = (int) (Math.random()*alto+0);
			posy = (int) (Math.random()*ancho+0);
			
			if (CampoCasillas[posx][posy].esMina()) {
				i--;
			}
			
			Casilla Casilla01 = new Casilla(true);
			CampoCasillas[posx][posy]=Casilla01;
		}
		
		
		
	}
	
	public void EnseñarTablero(){
		for (int i = 0; i < CampoCasillas.length; i++) {
			for (int j = 0; j < CampoCasillas[0].length; j++) {
				if (CampoCasillas[i][j].esMina()) {
					System.out.print("0");
				} else {
					System.out.print("X");
				}
				
			}
			System.out.println("");
		}
		
	}
	
	public void CalcularMinasCerca(){
		for (int i = 0; i < CampoCasillas.length; i++) {
			for (int j = 0; j < CampoCasillas[i].length; j++) {
				int MinasCerca =0;
				CampoCasillas[i][j].setMinasCerca(CampoCasillas[i][j].CalcularMinasCerca());
			}
		}
	
	}

	public Casilla[][] getCampoCasillas() {
		return CampoCasillas;
	}

	public void setCampoCasillas(Casilla[][] campoCasillas) {
		CampoCasillas = campoCasillas;
	}

}
