package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuUsuario extends JFrame{

	private static final long serialVersionUID = -44238291382720269L;
	private static MenuUsuario frame = new MenuUsuario();
	private JPanel contentPane;
	private JPanel buttonPane;
	private JButton btnNuevoJuego;
	private JButton btnPuntuaciones;
	private JButton btnAyuda;
	private JButton btnSalir;

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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 525);
		setMinimumSize(new Dimension(470, 525));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getButtonPane(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
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
		}
		return btnNuevoJuego;
	}
	private JButton getBtnPuntuaciones() {
		if (btnPuntuaciones == null) {
			btnPuntuaciones = new JButton("Puntuaciones");
		}
		return btnPuntuaciones;
	}

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("Ayuda");
		}
		return btnAyuda;
	}
	
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent pE) {
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
}