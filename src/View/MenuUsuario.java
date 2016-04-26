package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Controller.WindowController;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuUsuario extends JFrame implements Observer{

	private static final long serialVersionUID = -44238291382720269L;
	private static MenuUsuario frame = new MenuUsuario();
	private JPanel contentPane;
	private JPanel buttonPane;
	private JButton btnNuevoJuego;
	private JButton btnPuntuaciones;
	private JButton btnAyuda;
	private JButton btnSalir;
	private JTextPane panelAyuda;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						frame = new MenuUsuario();
						frame.setVisible(true);
					}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private MenuUsuario() {
		initialize();
	}
	
	public static MenuUsuario getMenuUsuario(){
		return frame;
	}
	
	private void initialize() {
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 525);
		setMinimumSize(new Dimension(470, 525));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getButtonPane(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel getButtonPane() {
		if (buttonPane == null) {
			buttonPane = new JPanel();
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(171)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnSalir(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnPuntuaciones(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnAyuda(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getBtnNuevoJuego(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(161))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(248)
						.addComponent(getBtnNuevoJuego(), GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getBtnPuntuaciones(), GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getBtnAyuda(), GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getBtnSalir(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(75))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
		return buttonPane;
	}
	private JButton getBtnNuevoJuego() {
		if (btnNuevoJuego == null) {
			btnNuevoJuego = new JButton("Nuevo juego");
			/*
			btnNuevoJuego.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SeleccionNivel prueba = new SeleccionNivel();
					prueba.setVisible(true);
					
				}
			});*/
		}
		return btnNuevoJuego;
	}
	private JButton getBtnPuntuaciones() {
		if (btnPuntuaciones == null) {
			btnPuntuaciones = new JButton("Puntuaciones");
		}
		return btnPuntuaciones;
	}
	
	/*
	 * Implementar un ActionListener para mostrar una pantalla con las indicaciones
	 * y un boton "Atras" para volver al menu del usuario. Hacerlo dentro de un 
	 * JDialog. Dentro del juego habra OTRO DIFERENTE.
	 */
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("Ayuda");
			/*
			btnAyuda.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(btnAyuda.isEnabled()){
						JDialog prueba = new JDialog();
						prueba.setVisible(true);
						prueba.setSize(300, 300);
						prueba.setTitle("Ayuda");
						prueba.getContentPane().add(getTxtpnelJuegoConsiste(), BorderLayout.CENTER);
				
					}
				}
				
			});
			*/
		}
		return btnAyuda;
	}
	private JTextPane getTxtpnelJuegoConsiste() {
		if (panelAyuda == null) {
			panelAyuda = new JTextPane();
			panelAyuda.setEditable(false);
			panelAyuda.setText("1.-El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.\r\n2.-Algunas casillas tienen un número, el cual indica la cantidad de minas que hay en las casillas circundantes. \r\n3.-Si se descubre una casilla sin número indica que ninguna de las casillas vecinas tiene mina y éstas se descubren automáticamente.\r\n4.-Si se descubre una casilla con una mina se pierde la partida.\r\n");
		}
		return panelAyuda;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent pE) {
					// TODO Auto-generated method stub
					frame.dispose();
				}
			});
		}
		return btnSalir;
	}
	
	public void addController(ActionListener windowController){
		getBtnNuevoJuego().addActionListener(windowController);
		getBtnPuntuaciones().addActionListener(windowController);
		getBtnAyuda().addActionListener(windowController);
		getBtnSalir().addActionListener(windowController);;
	}

	@Override
	public void update(Observable pO, Object pArg) {
		// TODO Auto-generated method stub
		
	}
}
