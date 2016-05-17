package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.WindowController;
import model.ConexionBaseDatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Puntuaciones extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8685401671809454004L;
	private JPanel contentPaneInformacion;
	private ConexionBaseDatos conBD = ConexionBaseDatos.getConexion();
	private static Puntuaciones frame = new Puntuaciones(); 
	private JButton btnVolver = new JButton();
	@SuppressWarnings("rawtypes")
	private JComboBox<?> comboBox = new JComboBox();
	private JTextPane textPane = new JTextPane();

	private Puntuaciones() {
		setResizable(false);
		initialize();
	}
	
	public static Puntuaciones getVentanaPuntuaciones(){
		return frame;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setTitle("Puntuaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 430);
		contentPaneInformacion = new JPanel();
		contentPaneInformacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneInformacion);
		setLocationRelativeTo(null);
		textPane.setEditable(false);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nivel 1", "Nivel 2", "Nivel 3"}));
		
		btnVolver = new JButton("Volver");
		GroupLayout gl_contentPaneInformacion = new GroupLayout(contentPaneInformacion);
		gl_contentPaneInformacion.setHorizontalGroup(
			gl_contentPaneInformacion.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPaneInformacion.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPaneInformacion.createSequentialGroup()
					.addGap(132)
					.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(129))
				.addGroup(gl_contentPaneInformacion.createSequentialGroup()
					.addGap(128)
					.addComponent(comboBox, 0, 71, Short.MAX_VALUE)
					.addGap(125))
		);
		gl_contentPaneInformacion.setVerticalGroup(
			gl_contentPaneInformacion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneInformacion.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(21))
		);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0){
					textPane.setText(conBD.getPunt1());
				}
				else if(comboBox.getSelectedIndex() == 1){
					textPane.setText(conBD.getPunt2());
				}
				else if(comboBox.getSelectedIndex() == 2){
					textPane.setText(conBD.getPunt3());
				}
			}
		});
		textPane.setText(conBD.getPunt1());
		contentPaneInformacion.setLayout(gl_contentPaneInformacion);
	}
	
	public void actualizarVariables(){
		if(comboBox.getSelectedIndex() == 0){
			textPane.setText(conBD.getPunt1());
		}
		else if(comboBox.getSelectedIndex() == 1){
			textPane.setText(conBD.getPunt2());
		}
		else if(comboBox.getSelectedIndex() == 2){
			textPane.setText(conBD.getPunt3());
		}
	}

	public void addController(WindowController wC) {
		btnVolver.addActionListener(wC);
	}
}
