package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import beans.Caja;
import beans.Comida;
import beans.Pedido;
import beans.Trabajador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CajaFrame extends JFrame {

	private JPanel panelCaja;
	private JButton volverAtras;
	private Trabajador trabajador;
	private JLabel fondoCaja;
	private JLabel txtCaja;
	private JButton buttonCaja;
	private JButton buttonCambio;
	private JTextField txtEuros;
	private JLabel txtCambio;
	private JTextField txtCentimos;
	private JLabel lblInfo;

	public CajaFrame(Trabajador trabajador) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelCaja = new JPanel();
		panelCaja.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelCaja);
		panelCaja.setLayout(null);

		txtCaja = new JLabel("Caja");
		txtCaja.setHorizontalAlignment(SwingConstants.CENTER);
		txtCaja.setFont(new Font("Sitka Small", Font.BOLD, 48));
		txtCaja.setBounds(257, 10, 333, 77);
		panelCaja.add(txtCaja);

		buttonCaja = new JButton("Ver");
		buttonCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cargando la caja");
				cargaAutomatica();
			}
		});
		buttonCaja.setFont(new Font("Sitka Small", Font.BOLD, 48));
		buttonCaja.setBounds(564, 25, 128, 47);
		panelCaja.add(buttonCaja);

		volverAtras = new JButton("");
		volverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Menu frame = new vista.Menu(trabajador);
				dispose();
			}
		});
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		volverAtras.setBounds(10, 10, 82, 77);
		panelCaja.add(volverAtras);

		buttonCambio = new JButton("Cambio");
		buttonCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vacio = "";
				String c = "Céntimos";
				String eu = "Euros";
				if (txtEuros.getText().equals(vacio) || txtCentimos.getText().equals(vacio)
						|| txtCentimos.getText().equals(c) || txtEuros.getText().equals(eu)) {
					JOptionPane.showMessageDialog(null, "Inserta el cambio");
				} else {
					String euros = txtEuros.getText();
					String centimos = txtCentimos.getText();
					String precio = euros + "." + centimos;
					float precioFloat = 0;
					precioFloat = Float.parseFloat(precio);
					Caja caja = new modelo.Cajas().recogerUltCaja();
					new modelo.Cajas().insertarCambio(caja, precioFloat);
					
				}
			}
		});
		buttonCambio.setFont(new Font("Sitka Small", Font.BOLD, 40));
		buttonCambio.setBounds(935, 76, 220, 40);
		panelCaja.add(buttonCambio);

		txtEuros = new JTextField();
		txtEuros.setText("Euros");
		txtEuros.setHorizontalAlignment(SwingConstants.CENTER);
		txtEuros.setBounds(925, 25, 72, 47);
		panelCaja.add(txtEuros);
		txtEuros.setColumns(10);
		txtEuros.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEuros.setText("");
			}
		});

		txtCambio = new JLabel("Inserta Cambio :");
		txtCambio.setFont(new Font("Sitka Small", Font.BOLD, 20));
		txtCambio.setBounds(729, 31, 192, 47);
		panelCaja.add(txtCambio);

		txtCentimos = new JTextField();
		txtCentimos.setText("Céntimos");
		txtCentimos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCentimos.setColumns(10);
		txtCentimos.setBounds(1023, 25, 72, 47);
		panelCaja.add(txtCentimos);
		txtCentimos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCentimos.setText("");
			}
		});
		
		lblInfo = new JLabel("Con Id de recibo 0, ser\u00E1n los cambios insertados por el administrador en la caja");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblInfo.setBounds(10, 724, 603, 14);
		panelCaja.add(lblInfo);

		fondoCaja = new JLabel("");
		fondoCaja.setIcon(new ImageIcon("images\\fondo.jpg"));
		fondoCaja.setBounds(0, 0, 1184, 749);
		panelCaja.add(fondoCaja);

		setVisible(true);
		setLocationRelativeTo(null);

	}

	public void cargaAutomatica() {

		ArrayList<Caja> cajas = new modelo.Cajas().recogerDatosCaja();
		int numeroDeEntradas = new modelo.Cajas().entradaDeDatos();

		String data[][] = new String[numeroDeEntradas][5];
		for (int i = 0; i < numeroDeEntradas; i++) {
			int o = 0;
			int recibo = cajas.get(i).getIdReceipt();
			String idRecibo = String.valueOf(recibo);
			data[i][o] = idRecibo;
			o++;
			float cantidad = cajas.get(i).getAmount();
			String cant = String.valueOf(cantidad);
			data[i][o] = cant;
			o++;
			float current = cajas.get(i).getCurrentBox();
			String currentBox = String.valueOf(current);
			data[i][o] = currentBox;
			o++;
			float finalB = cajas.get(i).getFinalBox();
			String finalBox = String.valueOf(finalB);
			data[i][o] = finalBox;
			o++;
			Date fecha = cajas.get(i).getTransactionDate();
			String fechaT = String.valueOf(fecha);
			data[i][o] = fechaT;
		}

		String header[] = { "Id Recibo", "Cantidad", "Caja actual", "Caja final", "Día" };

		// Table
		JTable table = new JTable(data, header);
		table.setEnabled(false);

		// ScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(108, 121, 898, 589);
		getContentPane().add(scrollPane);

	}

}
