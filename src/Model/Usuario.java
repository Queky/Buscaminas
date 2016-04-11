package Model;

public class Usuario {
	
	private String nombre;
	private String password;
	private int puntuacionMaxima;
	private CampoCasilla ultimoTablero;
	private boolean userLoaded;
	
	private static Usuario mUsuario;

	private Usuario() {
		if(mUsuario==null){
			mUsuario = new Usuario();
			checkUserLoaded();
		}
	}
	
	public Usuario(String name, String pass, int puntuacion){
		
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
	
	public void setPassword(String pPassword){
		password = pPassword;
		checkUserLoaded();
	}
	
	public String getPassword(){
		return password;
	}
	
	private void checkUserLoaded(){
		if(nombre!=null && password!=null)
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
