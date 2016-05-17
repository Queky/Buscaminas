package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SeleccionNivel extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 953446088960038024L;
	private final JPanel panelDatos = new JPanel();
	private JTextField textFieldNombre;
	private JComboBox<Object> comboBoxNivel;
	private static SeleccionNivel dialog = new SeleccionNivel();
	private JButton okButton;
	private JButton cancelButton;
	
	public static SeleccionNivel getSeleccionNivel(){
		return dialog;
	}

	/**
	 * Create the dialog.
	 */
	private SeleccionNivel() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 160);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		panelDatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new MigLayout("", "[][][grow]", "[][][][]"));
		{
			JLabel lblNombre = new JLabel("Introduce tu nombre:");
			panelDatos.add(lblNombre, "cell 0 0");
		}
		
		{
			textFieldNombre = new JTextField();
			panelDatos.add(textFieldNombre, "cell 2 0,growx");
			textFieldNombre.setColumns(10);
		}
		
		
		{
			JLabel lblNivel = new JLabel("Selecciona un nivel:");
			panelDatos.add(lblNivel, "cell 0 3");
		}
		{
			comboBoxNivel = new JComboBox<Object>();
			comboBoxNivel.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3"}));
			panelDatos.add(comboBoxNivel, "cell 2 3,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.setActionCommand("Aceptar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public String getNombreJugador(){
		return textFieldNombre.getText() ;
	}
	
	public void addController(ActionListener controller){
		okButton.addActionListener(controller);
		cancelButton.addActionListener(controller);
	}
	
	public int getSelectedLevel(){
		int numero = comboBoxNivel.getSelectedIndex() + 1;
		return numero;
	}
}
