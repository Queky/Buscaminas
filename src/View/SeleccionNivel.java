package View;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.Buscaminas;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SeleccionNivel extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 953446088960038024L;
	private final JPanel panelDatos = new JPanel();
	private JTextField textFieldNombre;
	private static Buscaminas buscaminas = Buscaminas.getBuscaminas();
	private String selectedLevel;
	private JComboBox comboBoxNivel;
	private static SeleccionNivel dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new SeleccionNivel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SeleccionNivel() {
<<<<<<< HEAD
		setBounds(100, 100, 310, 160);
		getContentPane().setLayout(new BorderLayout());
		panelDatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new MigLayout("", "[][][grow]", "[][][][]"));
		{
			JLabel lblNombre = new JLabel("Introduce tu nombre:");
			panelDatos.add(lblNombre, "cell 0 0");
=======
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
>>>>>>> Raul
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
			comboBoxNivel = new JComboBox();
			comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
			panelDatos.add(comboBoxNivel, "cell 2 3,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("Aceptar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent pE) {
						// TODO Auto-generated method stub
						selectedLevel=comboBoxNivel.getSelectedItem().toString();
						buscaminas.seleccionNivel(selectedLevel);
						dialog.setVisible(false);
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent pE) {
						// TODO Auto-generated method stub
						dialog.dispose();
					}
				});
			}
		}
	}
}
