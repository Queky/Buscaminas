package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Usuario;
import View.MenuUsuario;
import View.SeleccionNivel;
import View.VentanaBuscaminas;

public class WindowController implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent pE) {

		MenuUsuario menu = MenuUsuario.getMenuUsuario();
		
		if(pE.getActionCommand().equals("Ayuda")){
			JOptionPane.showMessageDialog(menu, "1. El juego consiste en despejar todas las casillas \n"
												+ "de una pantalla que no oculten una mina."
												+ "\r\n2. Algunas casillas tienen un número, el cual \n"
												+ "indica la cantidad de minas que hay en las casillas \n"
												+ "circundantes."
												+ "\r\n3. Si se descubre una casilla sin número indica \n"
												+ "que ninguna de las casillas vecinas tiene mina y éstas \n"
												+ "se descubren automáticamente."
												+ "\r\n4. Si se descubre una casilla con una mina se pierde la \n"
												+ "partida.\r\n", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(pE.getActionCommand().equals("Nuevo juego")){
			menu.setVisible(false);
			SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
			selNivel.setVisible(true);
		}
		else if(pE.getActionCommand().equals("Salir")){
			menu.dispose();
		}
		else if(pE.getActionCommand().equals("Aceptar")){
			SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
			if(selNivel.getNombreJugador().equals("")){
				JOptionPane.showMessageDialog(selNivel, "Nombre de jugador incorrecto. Por favor, \n"
														+"introduce un nombre valido.",
					    "Nombre no valido",
					    JOptionPane.ERROR_MESSAGE);
			}
			else {
				VentanaBuscaminas ventBuscaminas = VentanaBuscaminas.getVentanaBuscaminas();
				ventBuscaminas.setNivelElegido(selNivel.getSelectedLevel());
				ventBuscaminas = VentanaBuscaminas.getVentanaBuscaminas();
				ventBuscaminas.inicializar();
				selNivel.dispose();
				Usuario user = Usuario.getUsuario();
				System.out.println(selNivel.getSelectedLevel());
				user.setNivelElegido(selNivel.getSelectedLevel());
				ventBuscaminas.setVisible(true);
			}
				
		}
		else if(pE.getActionCommand().equals("Cancelar")){
			SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
			selNivel.dispose();
			menu.setVisible(true);
		}
		
	}

}