package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Trabajador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caja extends JFrame {

	private JPanel panelCaja;
	private JButton volverAtras;
	private Trabajador trabajador;
	private JLabel fondoCaja;

	
	public Caja(Trabajador trabajador) {
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		panelCaja = new JPanel();
		panelCaja.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelCaja);
		panelCaja.setLayout(null);
		
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

}
