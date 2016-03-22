package Model;

public class Casilla {
	
	private boolean TieneMina;
	private int MinasCerca;
	
	public Casilla(boolean tieneMina) {
	
		TieneMina = tieneMina;
		
	}
	public Casilla() {
			}
	
	public int CalcularMinasCerca(){
		return 0;
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
	
	

}
