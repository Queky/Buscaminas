package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.CampoCasilla;
import model.Tiempo;
import model.Usuario;
import view.MenuUsuario;
import view.Puntuaciones;
import view.SeleccionNivel;
import view.VentanaBuscaminas;

public class WindowController implements ActionListener{
	
	private VentanaBuscaminas ventBuscaminas = VentanaBuscaminas.getVentanaBuscaminas();
	private MenuUsuario menu = MenuUsuario.getMenuUsuario();
	private Puntuaciones punt = Puntuaciones.getVentanaPuntuaciones();
	
	@Override
	public void actionPerformed(ActionEvent pE) {
		
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
			Tiempo.getTiempo().reiniciar();
			menu.setVisible(false);
			SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
			selNivel.setVisible(true);
		}
		else if(pE.getActionCommand().equals("Puntuaciones")){
			punt.actualizarVariables();
			menu.setVisible(false);
			punt.setVisible(true);
		}
		else if(pE.getActionCommand().equals("Volver")){
			punt.setVisible(false);
			menu.setVisible(true);
		}
		else if(pE.getActionCommand().equals("Salir")){
			menu.dispose();
			System.exit(0);
		}
		else if(pE.getActionCommand().equals("Aceptar")){
			SeleccionNivel selNivel = SeleccionNivel.getSeleccionNivel();
			if(selNivel.getNombreJugador().contains(" ") || selNivel.getNombreJugador().isEmpty()){
				JOptionPane.showMessageDialog(selNivel, "Nombre de jugador incorrecto. Por favor, \n"
														+"introduce un nombre valido.",
					    "Nombre no valido",
					    JOptionPane.ERROR_MESSAGE);
			}
			else { 
				ventBuscaminas = VentanaBuscaminas.getVentanaBuscaminas();
				ventBuscaminas.setNivelElegido(selNivel.getSelectedLevel());
				ventBuscaminas.inicializar();
				selNivel.dispose();
				Usuario user = Usuario.getUsuario();
				user.nombreUsuario();
				CampoCasilla tablero = CampoCasilla.getcampoCasillas();
				tablero.inicializar(selNivel.getSelectedLevel());
				tablero.rellenarTablero();
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
