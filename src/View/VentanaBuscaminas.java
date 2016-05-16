package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.CampoCasilla;
import Model.Casilla;
import Model.ConexionBaseDatos;
import Model.Tiempo;
import Model.Usuario;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;

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
<<<<<<< HEAD
	private CampoCasilla campCasilla = CampoCasilla.getcampoCasillas(); 
	private String rutaMina;
	private String rutaBandera;
	private JPanel panelInformacionMinas;
	private JLabel lblMinasRestantes;
	private JLabel lblNumMinas;
	private ConexionBaseDatos conBD = ConexionBaseDatos.getConexion();
			
=======
	private CampoCasilla campCasilla = CampoCasilla.getcampoCasillas();
	private boolean inicializado= false;

>>>>>>> markel
	/**
	 * Launch the application.
	 */

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
		int x = (nivelElegido == 1) ? 390 : (nivelElegido == 2) ? 440 : (nivelElegido == 3) ? 530 : 390;
		int y = (nivelElegido == 1) ? 510 : (nivelElegido == 2) ? 540 : (nivelElegido == 3) ? 900 : 510;
		setBounds(100, 100, x, y);
		setMinimumSize(new Dimension(x, y));
		contentPaneVentana = new JPanel();
		contentPaneVentana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneVentana);
		contentPaneVentana.setLayout(new BorderLayout(0, 0));
		contentPaneVentana.add(getPanelInformacion(), BorderLayout.NORTH);
		contentPaneVentana.add(getPanelCasillas(), BorderLayout.CENTER);
		contentPaneVentana.add(getPanelInformacionMinas(), BorderLayout.SOUTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		time.iniciarTiempo(true);
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
		//Se hace esto para redimensionar la pantalla cuando ya existe un panel casillas,
		//y cambiamos de nivel.
		if (panelCasillas == null || panelCasillas != null) {
			panelCasillas = new JPanel();
			int x = (nivelElegido == 1) ? 10 : (nivelElegido == 2) ? 15 : (nivelElegido == 3) ? 25 : 3;
			int y = (nivelElegido == 1) ? 7 : (nivelElegido == 2) ? 10 : (nivelElegido == 3) ? 12 : 3;
			panelCasillas.setLayout(new GridLayout(x, y, 0, 0));
			btnVentana = new JButton[x][y];
			for(int i=0; i<x; i++){
				for(int j=0; j<y; j++){
					btnVentana[i][j] = new JButton();
					btnVentana[i][j].setFocusable(false);
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
							
							if (inicializado) {
								campCasilla.descubrirCasilla(i, j, derecho, izquierdo);
							} else {
								inicializado=true;
								campCasilla.introducirBombas(campCasilla.getBombasTotales(),i,j);
								campCasilla.calcularMinasCerca();
					
								campCasilla.descubrirCasilla(i, j, derecho, izquierdo);
							}}
					});
				}
			}
		}
		return panelCasillas;
	}
	
	private void reiniciarCasillas(){
		int x = (nivelElegido == 1) ? 10 : (nivelElegido == 2) ? 15 : (nivelElegido == 3) ? 25 : 3;
		int y = (nivelElegido == 1) ? 7 : (nivelElegido == 2) ? 10 : (nivelElegido == 3) ? 12 : 3;
		
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				btnVentana[i][j].setText("");
				btnVentana[i][j].setEnabled(true);
				btnVentana[i][j].setIcon(null);				
			}
		}
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
					if(btnReiniciar.isEnabled()){
						time.reiniciar();
						reiniciarCasillas();
						campCasilla.rellenarTablero();
						campCasilla.reiniciarCasillas();
						lblNumMinas.setText(""+campCasilla.minasRestantes());
					}
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
		rutaMina = "./Imagenes/mina";
		rutaBandera = "./Imagenes/bandera";
		rutaMina += (pNivel == 1) ? "Nivel1.png" : "Nivel2.png";
		rutaBandera += (pNivel == 1) ? "Nivel1.png" : "Nivel2.png";
		System.out.println("entra y nivel "+pNivel);
	}

	private JLabel getLblCurrentTime() {
		if (lblCurrentTime == null) {
			lblCurrentTime = new JLabel("00:00");
		}
		return lblCurrentTime;
	}

	@Override
	public void update(Observable pO, Object pArg) {
		boolean banderaConCera = false;
		
		if(campCasilla.minasRestantes() >= 0)
			lblNumMinas.setText(""+campCasilla.minasRestantes());

		if(pO.getClass().equals(Tiempo.class))
			lblCurrentTime.setText(pArg.toString());
		else if(pO.getClass().equals(CampoCasilla.class)){
			Casilla casilla = (Casilla) pArg;
			if (casilla.getEstado() instanceof Casilla.Visible) {
<<<<<<< HEAD
				if (casilla.esMina() && !casilla.tieneBandera()) {
					time.pararTiempo();
					time.iniciarTiempo(false);
				    btnVentana[casilla.getCoordX()][casilla.getCoordY()].setIcon(new ImageIcon(rutaMina));
					JOptionPane.showMessageDialog(frame, "  GAME OVER \n", "Fin del juego", JOptionPane.ERROR_MESSAGE);
					setVisible(false);
					reiniciarCasillas();
					lblCurrentTime.setText("00:00");
					MenuUsuario.getMenuUsuario().setVisible(true);
				}else if(!casilla.tieneBandera()){
=======
				
				if (casilla.esMina()) {

				    btnVentana[casilla.getCoordX()][casilla.getCoordY()].setIcon(new ImageIcon("./Imagenes/mina.jpg"));

							JOptionPane.showMessageDialog(btnVentana[casilla.getCoordX()][casilla.getCoordY()],
									"  GAME OVER \n",
								    "Fin del juego",
								    JOptionPane.ERROR_MESSAGE);						
				}else{
					
>>>>>>> markel
					if (casilla.getMinasCerca()==0) {
						btnVentana[casilla.getCoordX()][casilla.getCoordY()].setIcon(null);
						btnVentana[casilla.getCoordX()][casilla.getCoordY()].setText("");
						btnVentana[casilla.getCoordX()][casilla.getCoordY()].setEnabled(false);
					}
					else if (casilla.getMinasCerca()!=0 && !casilla.tieneBandera()) {
						btnVentana[casilla.getCoordX()][casilla.getCoordY()].setIcon(null);
						btnVentana[casilla.getCoordX()][casilla.getCoordY()].setText(""+casilla.getMinasCerca());
						btnVentana[casilla.getCoordX()][casilla.getCoordY()].setEnabled(false);
					}
				}
			}
			else if (casilla.getEstado() instanceof Casilla.NoVisible && !casilla.tieneBandera()) {
				casilla.desmarcarBandera();
				btnVentana[casilla.getCoordX()][casilla.getCoordY()].setIcon(null);
				btnVentana[casilla.getCoordX()][casilla.getCoordY()].setText("");
				btnVentana[casilla.getCoordX()][casilla.getCoordY()].setEnabled(true);
			}
			else if (casilla.getEstado() instanceof Casilla.Bandera && campCasilla.minasRestantes() >= 0) {
				casilla.marcarBandera();
				btnVentana[casilla.getCoordX()][casilla.getCoordY()].setIcon(new ImageIcon(rutaBandera));
				//btnVentana[casilla.getCoordX()][casilla.getCoordY()].setText("B");
				}
		
			if(campCasilla.minasRestantes() == 0 && campCasilla.casillasDescubiertas() && campCasilla.comprobarjuego()){
				Usuario.getUsuario().calcularPuntuacion();
				time.pararTiempo();
				conBD.guardarUsuario();
				ConexionBaseDatos.getConexion().guardarUsuario();
				JOptionPane.showMessageDialog(frame, "\t Juego completado!\n Tu puntuacion es de:\n"+Usuario.getUsuario().getPuntuacionMaxima(), "Juego completado", JOptionPane.INFORMATION_MESSAGE);				
			}
		}
	}
	private JPanel getPanelInformacionMinas() {
		if (panelInformacionMinas == null) {
			panelInformacionMinas = new JPanel();
			
			lblNumMinas = new JLabel();
			GroupLayout gl_panelInformacionMinas = new GroupLayout(panelInformacionMinas);
			gl_panelInformacionMinas.setHorizontalGroup(
				gl_panelInformacionMinas.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panelInformacionMinas.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblMinasRestantes(), GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNumMinas, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
			);
			gl_panelInformacionMinas.setVerticalGroup(
				gl_panelInformacionMinas.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelInformacionMinas.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelInformacionMinas.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNumMinas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getLblMinasRestantes(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			);
			panelInformacionMinas.setLayout(gl_panelInformacionMinas);
		}
		return panelInformacionMinas;
	}
	private JLabel getLblMinasRestantes() {
		if (lblMinasRestantes == null) {
			lblMinasRestantes = new JLabel("Minas restantes:");
			lblMinasRestantes.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return lblMinasRestantes;
	}
}
