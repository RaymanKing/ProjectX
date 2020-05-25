package vista;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import beans.Comida;
import beans.Pedido;
import beans.Trabajador;
import modelo.Trabajadores;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Pedidos extends JFrame {

	private JPanel mesasPedidos;
	private Trabajador trabajador;
	private JTextField commentary;
	private Choice eleccionProducto;
	private Choice selectTable;
	private Choice tipo;
	private Choice chooseQuantity;

	public Pedidos(Trabajador trabajador) {
		this.trabajador = trabajador;
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		mesasPedidos = new JPanel();
		mesasPedidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mesasPedidos);
		mesasPedidos.setLayout(null);

		selectTable = new Choice();
		selectTable.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		selectTable.setBounds(1067, 25, 80, 39);
		mesasPedidos.add(selectTable);
		selectTable.add("1");
		selectTable.add("2");
		selectTable.add("3");
		selectTable.add("4");
		selectTable.add("5");

		JLabel mesasNumero = new JLabel("N\u00FAmero de mesa");
		mesasNumero.setFont(new Font("Sitka Small", Font.BOLD, 17));
		mesasNumero.setHorizontalAlignment(SwingConstants.CENTER);
		mesasNumero.setBackground(UIManager.getColor("Button.shadow"));
		mesasNumero.setBounds(862, 25, 181, 27);
		mesasPedidos.add(mesasNumero);

		JButton volverAtras = new JButton("");
		volverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Menu frame = new vista.Menu(trabajador);
				dispose();
			}
		});
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		volverAtras.setBounds(10, 11, 80, 76);
		mesasPedidos.add(volverAtras);

		tipo = new Choice();
		tipo.setBounds(483, 25, 163, 27);
		mesasPedidos.add(tipo);
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

		JLabel selectTipo = new JLabel("Categor\u00EDa");
		selectTipo.setBackground(UIManager.getColor("Button.light"));
		selectTipo.setFont(new Font("Sitka Small", Font.BOLD, 17));
		selectTipo.setHorizontalAlignment(SwingConstants.CENTER);
		selectTipo.setBounds(303, 25, 174, 27);
		mesasPedidos.add(selectTipo);

		
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
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						// Clases anónimas con interfaces
						// Patrones de diseño
						// Solid
						// Método para iterar sobre la misma lista, realiza la acción entre parentesis
						// por cada comida hace -> la siguiente iteraccion
						// Expresión lambda -------------->
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
						/*for(Comida comida : comidas) {
						/*	eleccionProducto.add(comida.getName());
						}/**/
					}else if(eleccion.equals(cervezas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado cervezas");
						int tipo = 2;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(afrutado)) {
						JOptionPane.showMessageDialog(null, "Seleccionado vino afrutado");
						int tipo = 3;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(riojas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado riojas");
						int tipo = 4;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(verdejos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado verdejos");
						int tipo = 5;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(finos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado finos");
						int tipo = 6;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(tapas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado tapas");
						int tipo = 7;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(ibericos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado ibéricos");
						int tipo = 8;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(marisco)) {
						JOptionPane.showMessageDialog(null, "Seleccionado marisco");
						int tipo = 9;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(pescado)) {
						JOptionPane.showMessageDialog(null, "Seleccionado pescado");
						int tipo = 10;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(carnes)) {
						JOptionPane.showMessageDialog(null, "Seleccionado carnes");
						int tipo = 11;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(especiales)) {
						JOptionPane.showMessageDialog(null, "Seleccionado especiales");
						int tipo = 12;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(postres)) {
						JOptionPane.showMessageDialog(null, "Seleccionado postres");
						int tipo = 13;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						eleccionProducto.removeAll();
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}
				}
			}
		});

			
		
		
		
		seleccion.setBackground(UIManager.getColor("Button.light"));
		seleccion.setFont(new Font("Sitka Small", Font.BOLD, 17));
		seleccion.setBounds(675, 25, 145, 23);
		mesasPedidos.add(seleccion);
		
		JLabel titulo = new JLabel("Elija el producto :");
		titulo.setFont(new Font("Sitka Small", Font.BOLD, 20));
		titulo.setBackground(UIManager.getColor("Button.light"));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(56, 174, 207, 46);
		mesasPedidos.add(titulo);
		
		eleccionProducto = new Choice();
		eleccionProducto.setBounds(303, 186, 248, 46);
		mesasPedidos.add(eleccionProducto);
		
		JLabel quantity = new JLabel("Cantidad :");
		quantity.setFont(new Font("Sitka Small", Font.BOLD, 20));
		quantity.setHorizontalAlignment(SwingConstants.CENTER);
		quantity.setBounds(612, 174, 145, 34);
		mesasPedidos.add(quantity);
		
		chooseQuantity = new Choice();
		chooseQuantity.setBounds(763, 174, 70, 20);
		mesasPedidos.add(chooseQuantity);
		chooseQuantity.add("1");
		chooseQuantity.add("2");
		chooseQuantity.add("3");
		chooseQuantity.add("4");
		chooseQuantity.add("5");
		chooseQuantity.add("6");
		chooseQuantity.add("7");
		chooseQuantity.add("8");
		chooseQuantity.add("9");
		chooseQuantity.add("10");
		
		commentary = new JTextField();
		commentary.setFont(new Font("Sitka Small", Font.BOLD, 14));
		commentary.setBounds(56, 343, 268, 46);
		mesasPedidos.add(commentary);
		commentary.setColumns(10);
		
		JLabel txtComment = new JLabel("Escriba su comentario :");
		txtComment.setHorizontalAlignment(SwingConstants.CENTER);
		txtComment.setFont(new Font("Sitka Small", Font.BOLD, 20));
		txtComment.setBounds(56, 288, 268, 30);
		mesasPedidos.add(txtComment);
		
		JButton buttonSend = new JButton("Enviar");
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedidoActual = new Pedido();
				int idTable = selectTable.getSelectedIndex();
				idTable = idTable + 1;
				String nombrePlato = eleccionProducto.getSelectedItem();
				Comida comida = new modelo.Pedidos().recogerComida(nombrePlato);
				int idFood = comida.getIdFood();
				int quantity = chooseQuantity.getSelectedIndex();
				quantity = quantity + 1;
				String comentario = commentary.getText();
				float price = comida.getPrice_unit();
				price = price * quantity;
				pedidoActual = new Pedido(idTable, idFood, quantity, comentario, price);
				if(pedidoActual.getIdFood() != 0) {
					new modelo.Pedidos().realizarPedido(pedidoActual);
					new modelo.Comidas().retiradaAlmacen(idFood, quantity);
				}else {		
					JOptionPane.showMessageDialog(null, "Por favor selecciona un producto");
				}
			}
		});
		buttonSend.setBackground(UIManager.getColor("Button.light"));
		buttonSend.setFont(new Font("Sitka Small", Font.BOLD, 20));
		buttonSend.setBounds(462, 538, 184, 46);
		mesasPedidos.add(buttonSend);
		
		JButton mesas = new JButton("");
		mesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.Mesas frame = new vista.Mesas(trabajador);
				dispose();
			}
		});
		mesas.setIcon(new ImageIcon("images\\mesasCuentas.jpg"));
		mesas.setBounds(926, 400, 221, 194);
		mesasPedidos.add(mesas);
		
		JLabel fondoPedidos = new JLabel("");
		fondoPedidos.setIcon(new ImageIcon("images\\fondo.jpg"));
		fondoPedidos.setBounds(0, 0, 1184, 749);
		mesasPedidos.add(fondoPedidos);
		
		
		setVisible(true);
		setLocationRelativeTo(null);

		
		
	}
}
