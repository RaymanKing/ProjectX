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
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CajaFrame extends JFrame {

	private JPanel panelCaja;
	private JButton volverAtras;
	private Trabajador trabajador;
	private JLabel fondoCaja;
	private JLabel txtCaja;
	private JButton buttonCaja;

	
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
		buttonCaja.setFont(new Font("Sitka Small", Font.BOLD, 25));
		buttonCaja.setBounds(660, 21, 128, 47);
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
		for(int i = 0; i < numeroDeEntradas; i++) {
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
		
		
        String header[] = { "Id Recibo", "Cantidad", "Caja actual", "Caja final","Día" };

        // Table
        JTable table = new JTable(data,header);
        table.setEnabled(false);

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(108,121,898,589);
        getContentPane().add(scrollPane);
        
	}

}
