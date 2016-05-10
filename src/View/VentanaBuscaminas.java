package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.CampoCasilla;
import Model.Casilla;
import Model.Tiempo;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

public class VentanaBuscaminas extends JFrame implements Observer{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 3350085996919535125L;
	private static VentanaBuscaminas frame = new VentanaBuscaminas();
	private JPanel contentPaneVentana;
	private JPanel panelInformacion;
	private JPanel panelCasillas;
	private JLabel lblTiempo;
	private JButton btnReiniciar;
	private JLabel lblPuntuacin;
	private JButton[][] btnVentana;
	private int nivelElegido;
	private JLabel lblCurrentTime;
	private Tiempo time = Tiempo.getTiempo();
	private CampoCasilla campCasilla = CampoCasilla.getcampoCasillas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscaminas frame = new VentanaBuscaminas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private VentanaBuscaminas() {
		//initialize();
	}
	
	public void inicializar(){
		time.addObserver(frame);
		campCasilla.addObserver(frame);
		initialize();
	}
	
	public static VentanaBuscaminas getVentanaBuscaminas(){
		return frame;
	}
	
	private void initialize() {
		
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = (nivelElegido == 1) ? 390 : (nivelElegido == 2) ? 420 : (nivelElegido == 3) ? 450 : 390;
		int y = (nivelElegido == 1) ? 510 : (nivelElegido == 2) ? 540 : (nivelElegido == 3) ? 900 : 510;
		setBounds(100, 100, x, y);
		setMinimumSize(new Dimension(x, y));
		contentPaneVentana = new JPanel();
		contentPaneVentana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneVentana);
		contentPaneVentana.setLayout(new BorderLayout(0, 0));
		contentPaneVentana.add(getPanelInformacion(), BorderLayout.NORTH);
		contentPaneVentana.add(getPanelCasillas(), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		time.iniciarTiempo();
		//pack();
		//setVisible(true);
	}

	private JPanel getPanelInformacion() {
		if (panelInformacion == null) {
			panelInformacion = new JPanel();
			GroupLayout gl_panelInformacion = new GroupLayout(panelInformacion);
			gl_panelInformacion.setHorizontalGroup(
				gl_panelInformacion.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInformacion.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblTiempo())
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getLblCurrentTime())
						.addGap(31)
						.addComponent(getBtnReiniciar(), GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getLblPuntuacin())
						.addGap(35))
			);
			gl_panelInformacion.setVerticalGroup(
				gl_panelInformacion.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInformacion.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelInformacion.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblTiempo())
							.addComponent(getLblCurrentTime())
							.addComponent(getLblPuntuacin())
							.addComponent(getBtnReiniciar()))
						.addContainerGap(9, Short.MAX_VALUE))
			);
			panelInformacion.setLayout(gl_panelInformacion);
		}
		return panelInformacion;
	}
	private JPanel getPanelCasillas() {
		if (panelCasillas == null) {
			panelCasillas = new JPanel();
			campCasilla.inicializar(nivelElegido);
			int x = (nivelElegido == 1) ? 10 : (nivelElegido == 2) ? 15 : (nivelElegido == 3) ? 25 : 3;
			int y = (nivelElegido == 1) ? 7 : (nivelElegido == 2) ? 10 : (nivelElegido == 3) ? 12 : 3;
			panelCasillas.setLayout(new GridLayout(x, y, 0, 0));
			btnVentana = new JButton[x][y];
			for(int i=0; i<x; i++){
				for(int j=0; j<y; j++){
					btnVentana[i][j] = new JButton();
					panelCasillas.add(btnVentana[i][j]);
					btnVentana[i][j].setActionCommand(String.format("%1$d-%2$d", i,j));
					btnVentana[i][j].addMouseListener(new MouseAdapter() {
					
						
						@Override
						public void mouseClicked(MouseEvent pE) {
							String command = ((JButton) pE.getComponent()).getActionCommand();
							Scanner proc = new Scanner(command);
							proc.useDelimiter("-");
							int i = proc.nextInt();
							int j = proc.nextInt();
							
							System.out.println(i + " " + j);
							boolean izquierdo = false;
							boolean derecho =false;
							if (SwingUtilities.isLeftMouseButton(pE)) {
								izquierdo=true;
							}
							else{
								derecho=true;
							}
							System.out.println(pE.toString());
							System.out.println(command);
							campCasilla.enseñarTablero();
							campCasilla.descubrirCasilla(i, j, derecho, izquierdo);
							
							//CampoCasilla.getcampoCasillas().enseñarTablero();
							//CampoCasilla.getcampoCasillas().descubrirCasilla(i, j, derecho, izquierdo);
							
				
						}
					});
				}
			}
		}
		return panelCasillas;
	}

	
	private JLabel getLblTiempo() {
		if (lblTiempo == null) {
			lblTiempo = new JLabel("Tiempo:");
		}
		return lblTiempo;
	}
	private JButton getBtnReiniciar() {
		if (btnReiniciar == null) {
			btnReiniciar = new JButton("Reiniciar");
			btnReiniciar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent pE) {
					if(btnReiniciar.isEnabled())
						Tiempo.getTiempo().reiniciar();
				}
			});
		}
		return btnReiniciar;
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuación:");
		}
		return lblPuntuacin;
	}
	
	public void setNivelElegido(int pNivel){
		nivelElegido = pNivel;
		System.out.println("entra y nivel 2");
	}

	private JLabel getLblCurrentTime() {
		if (lblCurrentTime == null) {
			lblCurrentTime = new JLabel("00:00");
		}
		return lblCurrentTime;
	}

	@Override
	public void update(Observable pO, Object pArg) {
		if(pO.getClass().equals(Tiempo.class))
			lblCurrentTime.setText(pArg.toString());
		else if(pO.getClass().equals(CampoCasilla.class)){
			Casilla casilla = (Casilla) pArg;
			btnVentana[casilla.getCoordX()][casilla.getCoordY()].setText(""+casilla.getMinasCerca());
			btnVentana[casilla.getCoordX()][casilla.getCoordY()].setEnabled(false);
		}
	}
}
