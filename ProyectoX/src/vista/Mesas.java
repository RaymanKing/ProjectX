package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Trabajador;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Mesas extends JFrame {

	private JPanel contentPane;
	private Trabajador trabajador;

	
	public Mesas(Trabajador trabajador) {
		this.trabajador = trabajador;
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("images\\fondoMesas.jpg"));
		fondo.setBounds(0, 0, 1184, 749);
		contentPane.add(fondo);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
