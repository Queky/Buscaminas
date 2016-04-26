package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarCasilla implements ActionListener{
	
	private static CambiarCasilla mCambiarCasilla = new CambiarCasilla();
	
	private CambiarCasilla() {

	}

	public static CambiarCasilla getCambiarCasilla() {
		return mCambiarCasilla;
	}

	@Override
	public void actionPerformed(ActionEvent pE) {
		// TODO Auto-generated method stub
		
	}
}
