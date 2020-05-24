package vista;

import beans.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import modelo.Trabajadores;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Trabajador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;


public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField Bienvenida;
	private Trabajador trabajador;
	
	public Menu(Trabajador trabajador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(0, 0, 1650, 1080);
		setBounds(0,0,500,500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido "+trabajador.getFirstName()+" "+trabajador.getLastName());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 17));
		lblNewLabel.setBounds(74, 412, 400, 38);
		getContentPane().add(lblNewLabel);
		
		JButton buttonTables = new JButton("");
		buttonTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Pedidos frame = new vista.Pedidos(trabajador);
				dispose();
			}
		});
		buttonTables.setIcon(new ImageIcon("images\\bottonMesas.jpg"));
		buttonTables.setBounds(370, 155, 61, 58);
		getContentPane().add(buttonTables);
		
		// Partes específicas del administrador
		
		if(trabajador.getRol() == 101) {
			
		JButton buttonCaja = new JButton("");
		buttonCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.CajaFrame frame = new vista.CajaFrame(trabajador);
				dispose();
			}
		});
		buttonCaja.setIcon(new ImageIcon("images\\registradora.jpg"));
		buttonCaja.setBounds(32, 155, 61, 58);
		getContentPane().add(buttonCaja);
		
		JLabel corona = new JLabel("");
		corona.setIcon(new ImageIcon("images\\corona.jpg"));
		corona.setBounds(370, 11, 104, 90);
		getContentPane().add(corona);
		
		JButton register = new JButton("");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.Register frame = new vista.Register(trabajador);
				dispose();
			}
		});
		register.setIcon(new ImageIcon("images\\register.png"));
		register.setBounds(176, 153, 104, 130);
		getContentPane().add(register);
		}
		
		if(trabajador.getRol() == 2 || trabajador.getRol() == 101) {
			
		JButton almacen = new JButton("");
		almacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Inventario frame = new vista.Inventario(trabajador);
				dispose();
			}
		});
		almacen.setIcon(new ImageIcon("images\\almacen.jpg"));
		almacen.setBounds(32, 292, 89, 74);
		getContentPane().add(almacen);
		}
		
		JLabel titulo = new JLabel("JaBaR");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Sitka Small", Font.BOLD, 30));
		titulo.setBounds(117, 11, 243, 44);
		getContentPane().add(titulo);
		
		JButton disconnect = new JButton("");
		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.Login frame = new vista.Login();
				dispose();
			}
		});
		disconnect.setIcon(new ImageIcon("images\\logout.jpg"));
		disconnect.setBounds(326, 292, 105, 96);
		getContentPane().add(disconnect);
		
		JLabel menuFondo = new JLabel("");
		menuFondo.setIcon(new ImageIcon("images\\menu.jpg"));
		menuFondo.setBounds(0, 0, 484, 461);
		getContentPane().add(menuFondo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        
        
        
		
		this.setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
}
