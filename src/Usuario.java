
public class Usuario {
	
	private String nombre;
	private String pass;
	private int puntuacionMaxima;
	private CampoCasilla ultimoTablero;
	
	public Usuario(String nombre, String pass, int puntuacionMaxima, CampoCasilla ultimoTablero) {

		this.nombre = nombre;
		this.pass = pass;
	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
