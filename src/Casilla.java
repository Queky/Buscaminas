
public class Casilla {
	
	private boolean TieneMina;
	private int MinasCerca;
	private boolean visible ;
	private boolean interrogacion;
	
	
	public Casilla(boolean tieneMina) {
	
		TieneMina = tieneMina;
		visible=false;
		interrogacion=false;
	
	}
	
	public Casilla() {
		
	}
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isInterrogacion() {
		return interrogacion;
	}
	public void setInterrogacion(boolean interrogacion) {
		this.interrogacion = interrogacion;
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
