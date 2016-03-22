package View;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SeleccionNivel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 953446088960038024L;
	private final JPanel panelDatos = new JPanel();
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SeleccionNivel dialog = new SeleccionNivel();
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
		setBounds(100, 100, 310, 160);
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
			JComboBox comboBoxNivel = new JComboBox();
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
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}

}
