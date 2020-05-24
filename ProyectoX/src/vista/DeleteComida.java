package vista;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import beans.Comida;
import beans.Trabajador;

public class DeleteComida extends JFrame {

	private JPanel panelDeleteComida;
	private Trabajador trabajador;
	private JButton volverAtras;
	private Choice tipo;
	private JLabel lblTipo;
	private JLabel lblComida;
	private Choice eleccionProducto;
	
	public DeleteComida(Trabajador trabajador) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelDeleteComida = new JPanel();
		panelDeleteComida.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelDeleteComida);
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
		panelDeleteComida.setLayout(null);
		panelDeleteComida.setLayout(null);
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		panelDeleteComida.add(volverAtras);
		
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblTipo.setBounds(87, 36, 130, 24);
		panelDeleteComida.add(lblTipo);
		
		tipo = new Choice();
		tipo.setBounds(224, 40, 163, 27);
		panelDeleteComida.add(tipo);
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
		
		lblComida = new JLabel("Producto");
		lblComida.setHorizontalAlignment(SwingConstants.CENTER);
		lblComida.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblComida.setBounds(87, 126, 130, 24);
		panelDeleteComida.add(lblComida);
		
		eleccionProducto = new Choice();
		eleccionProducto.setBounds(224, 130, 163, 20);
		panelDeleteComida.add(eleccionProducto);
		
		
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
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(cervezas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado cervezas");
						int tipo = 2;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(afrutado)) {
						JOptionPane.showMessageDialog(null, "Seleccionado vino afrutado");
						int tipo = 3;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(riojas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado riojas");
						int tipo = 4;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(verdejos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado verdejos");
						int tipo = 5;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(finos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado finos");
						int tipo = 6;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(tapas)) {
						JOptionPane.showMessageDialog(null, "Seleccionado tapas");
						int tipo = 7;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(ibericos)) {
						JOptionPane.showMessageDialog(null, "Seleccionado ibéricos");
						int tipo = 8;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(marisco)) {
						JOptionPane.showMessageDialog(null, "Seleccionado marisco");
						int tipo = 9;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(pescado)) {
						JOptionPane.showMessageDialog(null, "Seleccionado pescado");
						int tipo = 10;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(carnes)) {
						JOptionPane.showMessageDialog(null, "Seleccionado carnes");
						int tipo = 11;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(especiales)) {
						JOptionPane.showMessageDialog(null, "Seleccionado especiales");
						int tipo = 12;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}else if(eleccion.equals(postres)) {
						JOptionPane.showMessageDialog(null, "Seleccionado postres");
						int tipo = 13;
						ArrayList <Comida> comidas = new modelo.Pedidos().recogerComidas(tipo);
						comidas.forEach(comida -> {eleccionProducto.add(comida.getName());});
					}
				}
			}
		});
		seleccion.setBackground(UIManager.getColor("Button.light"));
		seleccion.setFont(new Font("Sitka Small", Font.BOLD, 17));
		seleccion.setBounds(234, 66, 145, 23);
		panelDeleteComida.add(seleccion);
		
		JButton buttonDelete = new JButton("Eliminar");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vacio = "";
				if(eleccionProducto.getSelectedIndex() != -1) {
					String nombrePlato = eleccionProducto.getSelectedItem();
					int id = new modelo.Comidas().idComida(nombrePlato);
					new modelo.Comidas().eliminarComida(id);
				}else {	
					JOptionPane.showMessageDialog(null, "Por favor seleccione un producto");
				}
			}
		});
		buttonDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonDelete.setBounds(207, 221, 102, 29);
		panelDeleteComida.add(buttonDelete);
	}

}
