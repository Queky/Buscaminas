package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaBuscaminas extends JFrame {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 3350085996919535125L;
	private JPanel contentPaneVentana;
	private JPanel panelInformacion;
	private JPanel panelCasillas;
	private JLabel lblTiempo;
	private JButton btnReiniciar;
	private JLabel lblPuntuacin;
	private JButton[][] btnVentana;

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
	public VentanaBuscaminas() {
		initialize();
	}
	private void initialize() {
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 510);
		setMinimumSize(new Dimension(390, 510));
		contentPaneVentana = new JPanel();
		contentPaneVentana.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneVentana);
		contentPaneVentana.setLayout(new BorderLayout(0, 0));
		contentPaneVentana.add(getPanelInformacion(), BorderLayout.NORTH);
		contentPaneVentana.add(getPanelCasillas(), BorderLayout.CENTER);
	}

	private JPanel getPanelInformacion() {
		if (panelInformacion == null) {
			panelInformacion = new JPanel();
			GroupLayout gl_panelInformacion = new GroupLayout(panelInformacion);
			gl_panelInformacion.setHorizontalGroup(
				gl_panelInformacion.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInformacion.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLblTiempo(), GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getBtnReiniciar(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(12)
						.addComponent(getLblPuntuacin(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
			);
			gl_panelInformacion.setVerticalGroup(
				gl_panelInformacion.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelInformacion.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelInformacion.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblTiempo())
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
			panelCasillas.setLayout(new GridLayout(10, 7, -5, -6));
			for(int i=0; i<7; i++){
				for(int j=0; j<10; j++){
					btnVentana = new JButton[7][10];
					btnVentana[i][j] = new JButton();
					panelCasillas.add(btnVentana[i][j]);
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
		}
		return btnReiniciar;
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuación:");
		}
		return lblPuntuacin;
	}
}
