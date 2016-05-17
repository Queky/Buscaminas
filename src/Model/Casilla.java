
package model;

import java.util.Observable;

public class Casilla extends Observable{
	
	private boolean tieneMina;
	private int minasCerca;
	private State estado;
	private int coordX;
	private int coordY;
	private boolean marcadoBandera = false;

	
	public State getEstado() {
		return estado;
	}

	private void setEstado(State estado) {
		this.estado = estado;
	}

	public void marcarBandera(){
		marcadoBandera = true;
	}
	
	public void desmarcarBandera(){
		marcadoBandera = false;
	}
	
	public boolean tieneBandera(){
		return marcadoBandera;
	}
	
	public Casilla(boolean tieneMina, int i, int j) {
		this.tieneMina = tieneMina;
		this.coordX=i;
		this.coordY=j;
		estado = new NoVisible();
	}
	
	public int CalcularMinasCerca(){
		return 0;
	}

	public Casilla() {
		
	}
	
	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public boolean esMina() {
		return tieneMina;
	}
	public void setTieneMina(boolean tieneMina) {
		this.tieneMina = tieneMina;
	}
	public int getMinasCerca() {
		return minasCerca;
	}
	public void setMinasCerca(int minasCerca) {
		this.minasCerca = minasCerca;
	}
	
	public class Bandera implements State{
		
		// de bandera: derecho a novisible, izquierdo a visible

		@Override
		public void botonDerecho() {
			
			setEstado( new NoVisible());
			
			
			setChanged();
			notifyObservers(estado);
		}

		@Override
		public void botonIzquierdo() {
			if(!tieneBandera()){
				setEstado( new Visible());
				setChanged();
				notifyObservers(estado);
		}
		}}
	public class Visible implements State{
		
		// visible no hace nada

		@Override
		public void botonDerecho() {
			
		}

		@Override
		public void botonIzquierdo() {
			
		}}
	public class NoVisible implements State{
		
		//Novisible; derecho a bandera; izquierda a Visible

		@Override
		public void botonDerecho() {
			setEstado( new Bandera());
	
			setChanged();
			notifyObservers(estado);
		}

		@Override
		public void botonIzquierdo() {
			setEstado( new Visible());
			
			setChanged();
			notifyObservers(estado);
			
		}
	}
	
	public void reiniciarCasilla(int i, int j){
		estado = new NoVisible();
	}
}
