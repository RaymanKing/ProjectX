package vista;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import beans.Pedido;
import beans.Trabajador;
import javax.swing.JTextField;



public class Mesas extends JFrame {

	private JPanel panelMesas;
	private Trabajador trabajador;
	private JButton volver;
	private Choice choiceMesa;
	private JLabel fondoMesas;
	private JButton buttonSelect;
	private ArrayList <Integer> mesasOcupadas;
	private JLabel tituloMesa;
	private JLabel total;
	//private DefaultTableModel modelo = new DefaultTableModel();
	//private JTable tableMesa;
	
	public Mesas(Trabajador trabajador) {
		this.trabajador = trabajador;
		mesasOcupadas = new modelo.Mesas().devolverNumMesas();
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		panelMesas = new JPanel();
		panelMesas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelMesas);
		panelMesas.setLayout(null);
		
		
		choiceMesa = new Choice();
		choiceMesa.setBounds(575, 10, 128, 20);
		panelMesas.add(choiceMesa);
		
		tituloMesa = new JLabel("Selecciona el n\u00FAmero de mesa :");
		tituloMesa.setFont(new Font("Sitka Small", Font.BOLD, 20));
		tituloMesa.setHorizontalAlignment(SwingConstants.CENTER);
		tituloMesa.setBounds(174, 10, 361, 20);
		panelMesas.add(tituloMesa);
		
		volver = new JButton("");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Pedidos frame = new vista.Pedidos(trabajador);
				dispose();
			}
		});
		volver.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		volver.setBounds(10, 10, 82, 77);
		panelMesas.add(volver);
		
		
		
		
		// Vamos a añadir a la tabla el pedido de la mesa seleccionado
		
		buttonSelect = new JButton("Seleccionar");
		buttonSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mesaNumero = Integer.parseInt(choiceMesa.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Estas en la mesa número : "+mesaNumero);
				ArrayList <Pedido> pedidos = new modelo.Pedidos().recogerPedido(mesaNumero);
				cargaAutomatica(pedidos, mesaNumero);
			}
		});
		buttonSelect.setFont(new Font("Sitka Small", Font.BOLD, 20));
		buttonSelect.setBounds(726, 7, 162, 23);
		panelMesas.add(buttonSelect);
		
		JLabel txtComanda = new JLabel("Comandas ");
		txtComanda.setFont(new Font("Sitka Small", Font.BOLD, 20));
		txtComanda.setHorizontalAlignment(SwingConstants.CENTER);
		txtComanda.setBounds(158, 46, 302, 41);
		panelMesas.add(txtComanda);
		
		JButton pay = new JButton("");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mesaNumero = Integer.parseInt(choiceMesa.getSelectedItem());
				vista.Pay frame = new vista.Pay(trabajador, mesaNumero);
				dispose();
			}
		});
		pay.setIcon(new ImageIcon("images\\pay.jpg"));
		pay.setBounds(1085, 86, 89, 107);
		panelMesas.add(pay);
		
		JButton menos = new JButton("");
		menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Quitar elemento de la comanda
				int mesaNumero = Integer.parseInt(choiceMesa.getSelectedItem());
				vista.QuitarProducto frame = new vista.QuitarProducto(trabajador, mesaNumero);
				dispose();
			}
		});
		menos.setIcon(new ImageIcon("images\\menos.jpg"));
		menos.setBounds(1099, 250, 75, 77);
		panelMesas.add(menos);
		
		
		
		
		fondoMesas = new JLabel("");
		fondoMesas.setIcon(new ImageIcon("images\\fondo.jpg"));
		fondoMesas.setBounds(0, 0, 1184, 749);
		panelMesas.add(fondoMesas);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		
		
		// Nos muestra las mesas ocupadas o sino nos manda el mensaje y nos vuelve a la ventana anterior
		
		if(mesasOcupadas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "En estos momentos no hay ninguna mesa ocupada");
			vista.Pedidos frame = new vista.Pedidos(trabajador);
			dispose();
		}else {
			for(int i = 0; i < mesasOcupadas.size(); i++) {
				choiceMesa.add(mesasOcupadas.get(i).toString());
			}
			
		}
		
		
		
	}
	
	public void cargaAutomatica(ArrayList<Pedido> pedidos, int mesaNumero) {
		
		int numeroPedidos = new modelo.Pedidos().comprobarNumeroPedidos(mesaNumero);
		
		String data[][] = new String[numeroPedidos][4];
		for(int i = 0; i < numeroPedidos; i++) {
			int o = 0;
			int idTable = pedidos.get(i).getIdTable();
			String idMesa = String.valueOf(idTable);
			data[i][o] = idMesa;
			o++;
			int idFood = pedidos.get(i).getIdFood();
			String nomComida = new modelo.Comidas().traerNomComida(idFood);
			data[i][o] = nomComida;
			o++;
			int cantidad = pedidos.get(i).getQuantity();
			String cant = String.valueOf(cantidad);
			data[i][o] = cant;
			o++;
			float precio = pedidos.get(i).getPrice();
			String price = String.valueOf(precio);
			data[i][o] = price;			
		}
		
		
        String header[] = { "Número de mesa", "Comida/Bebida", "Cantidad", "Precio total" };

        // Table
        JTable table = new JTable(data,header);
        table.setEnabled(false);

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(108,121,898,589);
        getContentPane().add(scrollPane);
        
        
        
	}
}

