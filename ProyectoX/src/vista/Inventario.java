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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import beans.Comida;
import beans.Pedido;
import beans.Trabajador;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Inventario extends JFrame {

	private JPanel panelInventario;
	private JButton volverAtras;
	private Trabajador trabajador;
	private JLabel fondoInventario;
	private JLabel txtInventario;
	private JButton buttonTabla;

	
	public Inventario(Trabajador trabajador) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelInventario = new JPanel();
		panelInventario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelInventario);
		
		volverAtras = new JButton("");
		volverAtras.setBounds(10, 10, 82, 77);
		volverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Menu frame = new vista.Menu(trabajador);
				dispose();
			}
		});
		panelInventario.setLayout(null);
		volverAtras.setIcon(new ImageIcon("images\\volverAtras.jpg"));
		panelInventario.add(volverAtras);
		
		txtInventario = new JLabel("Inventario");
		txtInventario.setHorizontalAlignment(SwingConstants.CENTER);
		txtInventario.setFont(new Font("Sitka Small", Font.BOLD, 48));
		txtInventario.setBounds(257, 10, 333, 77);
		panelInventario.add(txtInventario);
		
		buttonTabla = new JButton("Ver");
		buttonTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cargando el inventario");
				cargaAutomatica();
			}
		});
		buttonTabla.setFont(new Font("Sitka Small", Font.BOLD, 25));
		buttonTabla.setBounds(660, 21, 128, 47);
		panelInventario.add(buttonTabla);
		
		fondoInventario = new JLabel("");
		fondoInventario.setBounds(0, 0, 1184, 749);
		fondoInventario.setIcon(new ImageIcon("images\\fondo.jpg"));
		panelInventario.add(fondoInventario);
		
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
	
	public void cargaAutomatica() {
		
		ArrayList <Comida> comidas = new modelo.Comidas().arrayComidas();
		int numeroDeComidas = new modelo.Comidas().totalComidas();
		
		String data[][] = new String[numeroDeComidas][5];
		for(int i = 0; i < numeroDeComidas; i++) {
			int o = 0;
			int idFood = comidas.get(i).getIdFood();
			String idComida = String.valueOf(idFood);
			data[i][o] = idComida;
			o++;
			String nomComida = comidas.get(i).getName();
			data[i][o] = nomComida;
			o++;
			int tipo = comidas.get(i).getType();
			String type = String.valueOf(tipo);
			data[i][o] = type;
			o++;
			int stock = comidas.get(i).getStock();
			String stok = String.valueOf(stock);
			data[i][o] = stok;
			o++;
			float precio = comidas.get(i).getPrice_unit();
			String price = String.valueOf(precio);
			data[i][o] = price;		
		}
		
		
        String header[] = { "Id Comida", "Nombre", "Tipo", "Stock","Precio/Unidad" };

        // Table
        JTable table = new JTable(data,header);
        table.setEnabled(false);

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(108,121,898,589);
        getContentPane().add(scrollPane);
        
	}
}
