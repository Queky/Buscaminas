package Model;

public class Usuario {
	
	private String nombre;
	private int puntuacionMaxima;
	private CampoCasilla ultimoTablero;
	private boolean userLoaded;
	
	// Tiempo del usuario.
	int min;
	int seg;
	
	private static Usuario mUsuario = new Usuario();
	
	private Usuario() {
		if(mUsuario==null){
			mUsuario = new Usuario();
			checkUserLoaded();
		}
	}
	
	public Usuario(String name){
		nombre = name;
	}

	public static Usuario getUsuario() {
		return mUsuario;
	}
	
	public void setNombre(String pNombre){
		nombre = pNombre;
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
}
