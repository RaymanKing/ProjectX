package vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Comida;
import beans.Trabajador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class Add extends JFrame {

	private JPanel panelAdd;
	private JButton volverAtras;
	private Trabajador trabajador;
	private Choice tipo;
	private JLabel lblTipo;
	private Choice eleccionProducto;
	private JLabel lblComida;
	private JLabel cantidad;
	private JFormattedTextField textCantidad;

	public Add(Trabajador trabajador) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelAdd = new JPanel();
		panelAdd.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelAdd);
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
		panelAdd.setLayout(null);
		panelAdd.setLayout(null);
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		panelAdd.add(volverAtras);

		JLabel addUnits = new JLabel("A\u00F1adir unidades");
		addUnits.setHorizontalAlignment(SwingConstants.CENTER);
		addUnits.setFont(new Font("Sitka Small", Font.BOLD, 16));
		addUnits.setBounds(181, 10, 160, 24);
		panelAdd.add(addUnits);

		tipo = new Choice();
		tipo.setBounds(224, 40, 163, 27);
		panelAdd.add(tipo);
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

		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblTipo.setBounds(87, 36, 130, 24);
		panelAdd.add(lblTipo);

		eleccionProducto = new Choice();
		eleccionProducto.setBounds(224, 130, 163, 20);
		panelAdd.add(eleccionProducto);

		lblComida = new JLabel("Producto");
		lblComida.setHorizontalAlignment(SwingConstants.CENTER);
		lblComida.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblComida.setBounds(87, 126, 130, 24);
		panelAdd.add(lblComida);

		JButton seleccion = new JButton("Seleccionar");
		seleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipo.getSelectedItem() != null) {
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
						JOptionPane.showMessageDialog(null, "Seleccionado bebidas");
						int tipo = 1;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(cervezas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado cervezas");
						int tipo = 2;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(afrutado)) {
						JOptionPane.showMessageDialog(null, "Seleccionado vino afrutado");
						int tipo = 3;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(riojas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado riojas");
						int tipo = 4;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(verdejos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado verdejos");
						int tipo = 5;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(finos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado finos");
						int tipo = 6;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(tapas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado tapas");
						int tipo = 7;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(ibericos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado ibéricos");
						int tipo = 8;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(marisco)) {
						JOptionPane.showMessageDialog(null, "Seleccionado marisco");
						int tipo = 9;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(pescado)) {
						JOptionPane.showMessageDialog(null, "Seleccionado pescado");
						int tipo = 10;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(carnes)) {
						JOptionPane.showMessageDialog(null, "Seleccionado carnes");
						int tipo = 11;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(especiales)) {
						JOptionPane.showMessageDialog(null, "Seleccionado especiales");
						int tipo = 12;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					} else if (eleccion.equals(postres)) {
						JOptionPane.showMessageDialog(null, "Seleccionado postres");
						int tipo = 13;
						ArrayList<Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {
							eleccionProducto.add(comida.getName());
						});
					}
				}
			}
		});
		seleccion.setBackground(UIManager.getColor("Button.light"));
		seleccion.setFont(new Font("Sitka Small", Font.BOLD, 17));
		seleccion.setBounds(234, 66, 145, 23);
		panelAdd.add(seleccion);

		cantidad = new JLabel("Introducir cantidad :");
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.setFont(new Font("Sitka Small", Font.BOLD, 16));
		cantidad.setBounds(30, 174, 187, 24);
		panelAdd.add(cantidad);

		textCantidad = new JFormattedTextField();
		textCantidad.setFont(new Font("Sitka Small", Font.BOLD, 14));
		textCantidad.setBounds(234, 177, 86, 20);
		panelAdd.add(textCantidad);
		textCantidad.setColumns(10);

		JButton buttonAddInventary = new JButton("A\u00F1adir");
		buttonAddInventary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vacio = "";
				if(eleccionProducto.getSelectedIndex() != -1 && !textCantidad.getText().equals(vacio)) {
					String nombrePlato = eleccionProducto.getSelectedItem();
					int id = new modelo.Comidas().idComida(nombrePlato);
					int cantidad =  Integer.parseInt(textCantidad.getText());
					new modelo.Comidas().addComida(id,cantidad);
				}else {
					JOptionPane.showMessageDialog(null, "Porfavor completa todos los campos");
				}
			}
		});
		buttonAddInventary.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonAddInventary.setBounds(207, 221, 102, 29);
		panelAdd.add(buttonAddInventary);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("images\\fondo.jpg"));
		fondo.setBounds(0, 0, 434, 261);
		panelAdd.add(fondo);
	}
}
