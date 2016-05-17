package model;

import java.util.Observable;

import view.SeleccionNivel;

public class Usuario extends Observable{
	
	private static Usuario mUsuario = new Usuario();
	private String nombre;
	private int puntuacionMaxima;
	private CampoCasilla ultimoTablero;
	private boolean userLoaded;
	private int nivelElegido;
	private SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
	
	private Usuario() {

	}
	
	public Usuario(String name){
		nombre = name;
	}

	public static Usuario getUsuario() {
		return mUsuario;
	}

	public void nombreUsuario(){
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
	
	public int getNivelElegido() {
		return nivelElegido;
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
	
	public void calcularPuntuacion(){
		int tiempo = Tiempo.getTiempo().getTiempoSeg();
		puntuacionMaxima = nivelElegido*5000-tiempo*10;
		if (puntuacionMaxima < 0)
			puntuacionMaxima = 0;
	}
}
