package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Pedido;
import beans.Trabajador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;

public class QuitarProducto extends JFrame {

	private JPanel panelQuitar;
	private Object trabajador;
	private JButton volverAtras;

	public QuitarProducto(Trabajador trabajador, int mesaNumero) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelQuitar = new JPanel();
		panelQuitar.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelQuitar);
		panelQuitar.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);

		volverAtras = new JButton("");
		volverAtras.setBounds(10, 10, 82, 77);
		volverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Mesas frame = new vista.Mesas(trabajador);
				dispose();
			}
		});
		panelQuitar.setLayout(null);
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		panelQuitar.add(volverAtras);

		JLabel lblEliminar = new JLabel("Eliminar pedido");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Sitka Small", Font.BOLD, 30));
		lblEliminar.setBounds(102, 10, 268, 46);
		panelQuitar.add(lblEliminar);

		Label txtProducto = new Label("Producto");
		txtProducto.setFont(new Font("Sitka Small", Font.BOLD, 17));
		txtProducto.setBounds(141, 62, 87, 22);
		panelQuitar.add(txtProducto);

		Choice choiceProducto = new Choice();
		choiceProducto.setBounds(250, 62, 120, 22);
		panelQuitar.add(choiceProducto);

		Choice choiceCantidad = new Choice();
		choiceCantidad.setBounds(250, 146, 120, 20);
		panelQuitar.add(choiceCantidad);

		Button buttonSeleccionar = new Button("Seleccionar");
		buttonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = choiceProducto.getSelectedItem();
				int id = new modelo.Comidas().idComida(nombre);
				int cantidad = new modelo.Pedidos().recogerCantidad(id);
				for (int i = 0; i < cantidad; i++) {
					int numero = 1 + i;
					String num = Integer.toString(numero);
					choiceCantidad.add(num);
				}
			}
		});
		buttonSeleccionar.setFont(new Font("Sitka Small", Font.BOLD, 20));
		buttonSeleccionar.setBounds(250, 88, 120, 33);
		panelQuitar.add(buttonSeleccionar);

		Label labelDelete = new Label("Cantidad a eliminar");
		labelDelete.setFont(new Font("Sitka Small", Font.BOLD, 17));
		labelDelete.setBounds(65, 146, 163, 22);
		panelQuitar.add(labelDelete);

		Button buttonSeleccion = new Button("Seleccionar");
		buttonSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (choiceCantidad.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Selecciona una cantidad porfavor");
				} else {
					String eleccion = choiceCantidad.getSelectedItem();
					int numEleccion = Integer.parseInt(eleccion);
					String nombre = choiceProducto.getSelectedItem();
					int id = new modelo.Comidas().idComida(nombre);
					int cantidad = new modelo.Pedidos().recogerCantidad(id);
					if (numEleccion == cantidad) {
						new modelo.Comidas().addComida(id, cantidad);
						new modelo.Pedidos().borrarPedido(id, cantidad);
						vista.Mesas frame = new vista.Mesas(trabajador);
						dispose();
					} else {
						new modelo.Comidas().addComida(id, numEleccion);
						new modelo.Pedidos().actualizarPedido(id, cantidad, numEleccion);
						vista.Mesas frame = new vista.Mesas(trabajador);
						dispose();
					}
				}
			}
		});
		buttonSeleccion.setFont(new Font("Sitka Small", Font.BOLD, 20));
		buttonSeleccion.setBounds(161, 198, 177, 53);
		panelQuitar.add(buttonSeleccion);

		// Tengo que mostrar un choice con todos los elementos que tiene el id de la
		// mesa
		// Tengo que seleccionar uno y elegir una cantidad
		// Llamara al metodo DELETE para eliminarlo del pedido
		// Devolvera los elementos borrados al almacen

		ArrayList<Pedido> pedidos = new modelo.Pedidos().recogerPedido(mesaNumero);

		for (int i = 0; i < pedidos.size(); i++) {
			int id = pedidos.get(i).getIdFood();
			String nombre = new modelo.Comidas().traerNomComida(id);
			choiceProducto.add(nombre);

		}

	}
}
