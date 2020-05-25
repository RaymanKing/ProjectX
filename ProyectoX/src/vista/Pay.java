package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Caja;
import beans.Pedido;
import beans.Recibo;
import beans.Trabajador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JTextField;

public class Pay extends JFrame {

	private JPanel panelPay;
	private Trabajador trabajador;
	private JButton volverAtras;
	private JTextField introducirEuros;
	private JTextField textCentimos;

	public Pay(Trabajador trabajador, int mesaNumero) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelPay = new JPanel();
		panelPay.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPay);
		setVisible(true);
		setLocationRelativeTo(null);

		// new controlador.Fichero().escrituraTipo(mesaNumero);
		float total = new controlador.Pagos().recogerT(mesaNumero);

		volverAtras = new JButton("");
		volverAtras.setBounds(10, 10, 82, 77);
		volverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Mesas frame = new vista.Mesas(trabajador);
				dispose();
			}
		});
		panelPay.setLayout(null);
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		panelPay.add(volverAtras);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuenta.setFont(new Font("Sitka Small", Font.BOLD, 30));
		lblCuenta.setBounds(153, 11, 172, 38);
		panelPay.add(lblCuenta);

		JLabel lblTotal = new JLabel("Total a pagar :");
		lblTotal.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(10, 150, 164, 26);
		panelPay.add(lblTotal);

		JLabel lblNewLabel = new JLabel("N\u00FAmero de mesa :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 110, 199, 29);
		panelPay.add(lblNewLabel);

		JLabel lblPagar = new JLabel("" + mesaNumero);
		lblPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagar.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblPagar.setBounds(219, 110, 115, 29);
		panelPay.add(lblPagar);

		introducirEuros = new JTextField();
		introducirEuros.setFont(new Font("Sitka Small", Font.BOLD, 14));
		introducirEuros.setText("Euros");
		introducirEuros.setHorizontalAlignment(SwingConstants.CENTER);
		introducirEuros.setBounds(124, 212, 50, 20);
		panelPay.add(introducirEuros);
		introducirEuros.setColumns(10);
		introducirEuros.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				introducirEuros.setText("");
			}
		});

		JLabel lblEfectivo = new JLabel("Efectivo");
		lblEfectivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfectivo.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblEfectivo.setBounds(10, 211, 110, 20);
		panelPay.add(lblEfectivo);

		textCentimos = new JTextField();
		textCentimos.setFont(new Font("Sitka Small", Font.BOLD, 14));
		textCentimos.setText("C\u00E9ntimos");
		textCentimos.setHorizontalAlignment(SwingConstants.CENTER);
		textCentimos.setColumns(10);
		textCentimos.setBounds(189, 212, 82, 20);
		panelPay.add(textCentimos);
		textCentimos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textCentimos.setText("");
			}
		});

		JButton enviarPago = new JButton("Tarjeta");
		enviarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Tarjeta
				int tipoPago = 2;	
				//ArrayList<Pedido> pedidoActual = new modelo.Pedidos().recogerPedido(mesaNumero);
				// Crear el recibo
				Recibo reciboActual = new Recibo();
				// String numMesa = new controlador.Fichero().leerTipo();
				// int numero = Integer.parseInt(numMesa);
				int idUser = trabajador.getIdUser();
				String nombre = trabajador.getFirstName();
				float price = new controlador.Pagos().recogerT(mesaNumero);
				Date transaction = new Date(System.currentTimeMillis());
				reciboActual = new Recibo(mesaNumero, idUser, nombre, price, transaction);
				new modelo.Recibos().realizarRecibo(reciboActual, tipoPago);
				// Añadir recibo a la caja
				Recibo recibo = new modelo.Recibos().extraerRecibo();
				Caja caja = new modelo.Cajas().recogerUltCaja();
				new modelo.Cajas().insertarRecibo(recibo, caja);
				// Limpiar la mesa
				new modelo.Mesas().limpiarMesa(mesaNumero);
				vista.Mesas frame = new vista.Mesas(trabajador);
				dispose();
			}
		});
		enviarPago.setFont(new Font("Sitka Small", Font.BOLD, 18));
		enviarPago.setBounds(327, 152, 107, 23);
		panelPay.add(enviarPago);

		JLabel lblNumero = new JLabel(total + " euros");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNumero.setBounds(189, 149, 136, 29);
		panelPay.add(lblNumero);
		
		
		

		// EFECTIVOO
		JButton buttonEfectivo = new JButton("Efectivo");
		buttonEfectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String vacio = "";
				String e = "Euros";
				String c = "Céntimos";
				if (introducirEuros.getText().equals(vacio) || textCentimos.getText().equals(vacio)
						|| textCentimos.getText().equals(c) || introducirEuros.getText().equals(e)) {
					JOptionPane.showMessageDialog(null, "Introduzca la cantidad con la que va a pagar");
					}else {
						int tipoPago = 1;
						String euros = introducirEuros.getText();
						String centimos = textCentimos.getText();
						String precio = euros + "." + centimos;
						float precioFloat = Float.parseFloat(precio);
						if(precioFloat >= total) {	
						//ArrayList<Pedido> pedidoActual = new modelo.Pedidos().recogerPedido(mesaNumero);
						// Crear el recibo
						Recibo reciboActual = new Recibo();
						// String numMesa = new controlador.Fichero().leerTipo();
						// int numero = Integer.parseInt(numMesa);
						int idUser = trabajador.getIdUser();
						String nombre = trabajador.getFirstName();
						float price = new controlador.Pagos().recogerT(mesaNumero);
						Date transaction = new Date(System.currentTimeMillis());
						reciboActual = new Recibo(mesaNumero, idUser, nombre, price, transaction);
						new modelo.Recibos().realizarRecibo(reciboActual, tipoPago);
						// Añadir recibo a la caja
						Recibo recibo = new modelo.Recibos().extraerRecibo();
						Caja caja = new modelo.Cajas().recogerUltCaja();
						new modelo.Cajas().insertarRecibo(recibo, caja);
						// Limpiar la mesa
						new modelo.Mesas().limpiarMesa(mesaNumero);
						// Mostrar la vuelta
						float vuelta = precioFloat;
						vuelta = vuelta - reciboActual.getPrice();
						JOptionPane.showMessageDialog(null, "La vuelta es de "+vuelta+" euros");
						// Decir si se puede o no pagar con esta cantidad por si es mayor o menor
						vista.Mesas frame = new vista.Mesas(trabajador);
						dispose();
						}else {
							JOptionPane.showMessageDialog(null, "No llega a la cantidad necesaria para pagar");
						}
	
						}
					} 

		});
		buttonEfectivo.setFont(new Font("Sitka Small", Font.BOLD, 20));
		buttonEfectivo.setBounds(306, 212, 128, 28);
		panelPay.add(buttonEfectivo);
	}
}
