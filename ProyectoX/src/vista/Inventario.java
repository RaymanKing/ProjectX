package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Trabajador;

public class Inventario extends JFrame {

	private JPanel panelInventario;
	private JButton volverAtras;
	private Trabajador trabajador;
	private JLabel fondoInventario;

	
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
		
		fondoInventario = new JLabel("");
		fondoInventario.setBounds(0, 0, 1184, 749);
		fondoInventario.setIcon(new ImageIcon("images\\fondo.jpg"));
		panelInventario.add(fondoInventario);
		
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
}
