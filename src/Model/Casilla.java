
package Model;

import java.util.Observable;

public class Casilla extends Observable{
	
	private boolean TieneMina;
	private int MinasCerca;
	private State estado;

	
	public State getEstado() {
		return estado;
	}

	private void setEstado(State estado) {
		this.estado = estado;
	}

	
	
	public Casilla(boolean tieneMina) {
	
		TieneMina = tieneMina;
	
		estado = new NoVisible();
	
	}
	
	public int CalcularMinasCerca(){
		return 0;
	}

	public Casilla() {
		
	}
	
	public boolean esMina() {
		return TieneMina;
	}
	public void setTieneMina(boolean tieneMina) {
		TieneMina = tieneMina;
	}
	public int getMinasCerca() {
		return MinasCerca;
	}
	public void setMinasCerca(int minasCerca) {
		MinasCerca = minasCerca;
	}
	
	public class Bandera implements State{

		@Override
		public void botonDerecho() {
			
			setEstado( new NoVisible());
			
			
			setChanged();
			notifyObservers(estado);
		}

		@Override
		public void botonIzquierdo() {
			setEstado( new Visible());
			
			
			setChanged();
			notifyObservers(estado);
			
		}}
	public class Visible implements State{

		@Override
		public void botonDerecho() {
		
			
		}

		@Override
		public void botonIzquierdo() {
			
			
		}}
	public class NoVisible implements State{

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
			
		}}
	

}
