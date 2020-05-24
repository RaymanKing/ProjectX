package vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import beans.Comida;
import beans.Trabajador;
import javax.swing.JTextField;

public class AddComida extends JFrame {

	private JPanel panelAddComida;
	private Trabajador trabajador;
	private JButton volverAtras;
	private JLabel lblComida;
	private Choice tipo;
	private JTextField txtNombre;
	private JTextField txtEuros;
	private JTextField txtCntimos;
	private JTextField txtCantidad;

	public AddComida(Trabajador trabajador) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelAddComida = new JPanel();
		panelAddComida.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelAddComida);
		setVisible(true);
		setLocationRelativeTo(null);

		volverAtras = new JButton("");
		volverAtras.setBounds(10, 10, 82, 77);
		volverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Inventario frame = new vista.Inventario(trabajador);
				dispose();
			}
		});
		panelAddComida.setLayout(null);
		panelAddComida.setLayout(null);
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		panelAddComida.add(volverAtras);

		tipo = new Choice();
		tipo.setBounds(224, 40, 163, 27);
		panelAddComida.add(tipo);
		tipo.add("Bebidas");
		tipo.add("Cervezas");
		tipo.add("Vino afrutado");
		tipo.add("Riojas");
		tipo.add("Verdejos");
		tipo.add("Finos");
		tipo.add("Tapas frías");
		tipo.add("Ibéricos");
		tipo.add("Marisco");
		tipo.add("Pescado");
		tipo.add("Carnes");
		tipo.add("Especiales");
		tipo.add("Postres");

		lblComida = new JLabel("Nombre producto");
		lblComida.setHorizontalAlignment(SwingConstants.CENTER);
		lblComida.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblComida.setBounds(44, 108, 170, 24);
		panelAddComida.add(lblComida);

		JLabel lblTitulo = new JLabel("A\u00F1adir Producto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblTitulo.setBounds(139, 10, 198, 24);
		panelAddComida.add(lblTitulo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblTipo.setBounds(115, 46, 71, 14);
		panelAddComida.add(lblTipo);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Sitka Small", Font.BOLD, 16));
		txtNombre.setBounds(224, 110, 163, 20);
		panelAddComida.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblCantidad.setBounds(110, 178, 104, 24);
		panelAddComida.add(lblCantidad);

		txtEuros = new JTextField();
		txtEuros.setHorizontalAlignment(SwingConstants.CENTER);
		txtEuros.setFont(new Font("Sitka Small", Font.BOLD, 14));
		txtEuros.setText("Euros");
		txtEuros.setBounds(224, 141, 71, 20);
		panelAddComida.add(txtEuros);
		txtEuros.setColumns(10);
		txtEuros.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEuros.setText("");
			}
		});

		txtCntimos = new JTextField();
		txtCntimos.setText("C\u00E9ntimos");
		txtCntimos.setFont(new Font("Sitka Small", Font.BOLD, 14));
		txtCntimos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCntimos.setBounds(305, 141, 82, 20);
		panelAddComida.add(txtCntimos);
		txtCntimos.setColumns(10);
		txtCntimos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCntimos.setText("");
			}
		});

		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrecio.setFont(new Font("Sitka Small", Font.BOLD, 16));
		labelPrecio.setBounds(110, 143, 104, 24);
		panelAddComida.add(labelPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Sitka Small", Font.BOLD, 16));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(224, 180, 163, 20);
		panelAddComida.add(txtCantidad);

		JButton buttonEnviar = new JButton("A\u00F1adir");
		buttonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vacio = "";
				String eu = "Euros";
				String c = "Céntimos";
				if (txtCantidad.getText().equals(vacio) || txtEuros.getText().equals(vacio)
						|| txtCntimos.getText().equals(vacio) || txtEuros.getText().equals(eu)
						|| txtCntimos.getText().equals(c) || txtNombre.getText().equals(vacio)) {
					JOptionPane.showMessageDialog(null, "Porfavor completa todos los campos.");
				} else {
					String bebidas = "Bebidas";
					String cervezas = "Cervezas";
					String afrutado = "Vino afrutado";
					String riojas = "Riojas";
					String verdejos = "Verdejos";
					String finos = "Finos";
					String tapas = "Tapas frías";
					String ibericos = "Ibéricos";
					String marisco = "Marisco";
					String pescado = "Pescado";
					String carnes = "Carnes";
					String especiales = "Especiales";
					String postres = "Postres";
					String eleccion = tipo.getSelectedItem();

					if (eleccion.equals(bebidas)) {
						int tipo = 1;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(cervezas)) {
						int tipo = 2;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(afrutado)) {
						int tipo = 3;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(riojas)) {
						int tipo = 4;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(verdejos)) {
						int tipo = 5;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(finos)) {
						int tipo = 6;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(tapas)) {
						int tipo = 7;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(ibericos)) {
						int tipo = 8;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(marisco)) {
						int tipo = 9;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(pescado)) {
						int tipo = 10;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(carnes)) {
						int tipo = 11;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(especiales)) {
						int tipo = 12;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					} else if (eleccion.equals(postres)) {
						int tipo = 13;
						String nombre = txtNombre.getText();
						String euros = txtEuros.getText();
						String centimos = txtCntimos.getText();
						String precio = euros + "." + centimos;
						String vacio01 = "";
						float precioFloat = 0;
						precioFloat = Float.parseFloat(precio);
						String cant = txtCantidad.getText();
						int cantidad = Integer.parseInt(cant);
						Comida comida = new Comida(nombre,tipo,cantidad,precioFloat);
						new modelo.Comidas().crearComida(nombre, tipo, cantidad, precioFloat);
					}
				}
			}
		});
		buttonEnviar.setFont(new Font("Sitka Small", Font.BOLD, 20));
		buttonEnviar.setBounds(164, 213, 131, 37);
		panelAddComida.add(buttonEnviar);
	}
}
