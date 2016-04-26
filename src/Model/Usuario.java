package Model;

import java.util.Observable;

import View.SeleccionNivel;

public class Usuario extends Observable{
	
	
	private static Usuario mUsuario = new Usuario();

	private String nombre;
	private int puntuacionMaxima;
	private CampoCasilla ultimoTablero;
	private boolean userLoaded;
	private int nivelElegido;
	
	SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
	
	// Tiempo del usuario.
	int seg;
		
	private Usuario() {

	}
	
	public Usuario(String name){
		nombre = name;
	}

	public static Usuario getUsuario() {
		return mUsuario;
	}
	//mirar..
	public void setNombreUsuario(){
		 nombre=selNivel.getNombreJugador();
	}
	public void setNombre(String pNombre){
		nombre = pNombre ;
		checkUserLoaded();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	private void checkUserLoaded(){
		if(nombre!=null)
			userLoaded = true;
		else
			userLoaded = false;
	}
	
	public boolean getUserLoaded(){
		return userLoaded;
	}

	public int getPuntuacionMaxima() {
		return puntuacionMaxima;
	}
	public void setPuntuacionMaxima(int puntuacionMaxima) {
		this.puntuacionMaxima = puntuacionMaxima;
	}
	public CampoCasilla getUltimoTablero() {
		return ultimoTablero;
	}
	public void setUltimoTablero(CampoCasilla ultimoTablero) {
		this.ultimoTablero = ultimoTablero;
	}
	
	public void setNivelElegido(int pNivel){
		nivelElegido = pNivel;
		notifyObservers();
	}
}
