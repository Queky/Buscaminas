package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class SeleccionNivel extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4888033634551970793L;
	private JPanel contentPane;
	private JPanel panelDatos;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblNivel;
	private JComboBox<Object> comboBoxNivel;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionNivel frame = new SeleccionNivel();
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
	public SeleccionNivel() {
		initialize();
	}
	private void initialize() {
		setTitle("Elige un nivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelDatos(), BorderLayout.CENTER);
		contentPane.add(getBtnAceptar(), BorderLayout.SOUTH);
	}
	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setLayout(new MigLayout("", "[133px][][][][][][][grow]", "[16px][][][][][]"));
			panelDatos.setLayout(new MigLayout("", "[1px][][][]", "[1px][][]"));
			panelDatos.setLayout(new MigLayout("", "[1px]", "[1px]"));
			panelDatos.add(getLblNombre(), "cell 0 0,grow");
			panelDatos.add(getTextFieldNombre(), "cell 0 0,grow");
			panelDatos.add(getLblNivel(), "cell 0 0,grow");
			panelDatos.add(getComboBoxNivel(), "cell 0 0,grow");
		}
		return panelDatos;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Introduce tu nombre:");
		}
		return lblNombre;
	}
	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setColumns(10);
		}
		return textFieldNombre;
	}
	private JLabel getLblNivel() {
		if (lblNivel == null) {
			lblNivel = new JLabel("Elige un nivel:");
		}
		return lblNivel;
	}
	private JComboBox<Object> getComboBoxNivel() {
		if (comboBoxNivel == null) {
			comboBoxNivel = new JComboBox<Object>();
			comboBoxNivel.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3"}));
		}
		return comboBoxNivel;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
		}
		return btnAceptar;
	}

	@Override
	public void update(Observable pO, Object pArg) {
		// TODO Auto-generated method stub
		
	}
}
