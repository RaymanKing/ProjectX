package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import modelo.Trabajadores;
import beans.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frmRayoo;
	private JPasswordField passwordField;
	private JTextField JPuser;
	private JPasswordField JPpassword;
	private final JLabel Fondo = new JLabel("New label");

	
	public Login() {
		initialize();
	}

	
	private void initialize() {
		// Detalles de la ventana
		frmRayoo = new JFrame();
		frmRayoo.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRayoo.setTitle("JaBaR");
		frmRayoo.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\images\\beer.png"));
		frmRayoo.setLocationRelativeTo(null);
		frmRayoo.setBounds(100, 100, 450, 300);
		frmRayoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRayoo.getContentPane().setLayout(null);
		
		JPuser = new JTextField();
		JPuser.setBounds(156, 73, 180, 20);
		frmRayoo.getContentPane().add(JPuser);
		JPuser.setColumns(10);
		
		JPpassword = new JPasswordField();
		JPpassword.setBounds(156, 149, 180, 20);
		frmRayoo.getContentPane().add(JPpassword);
		
		JLabel User = new JLabel("DNI");
		User.setForeground(Color.WHITE);
		User.setFont(new Font("Sitka Small", Font.BOLD, 30));
		User.setBounds(25, 63, 91, 50);
		frmRayoo.getContentPane().add(User);
		
		JLabel Password = new JLabel("Password");
		Password.setForeground(Color.WHITE);
		Password.setFont(new Font("Sitka Small", Font.BOLD, 25));
		Password.setBounds(10, 140, 162, 34);
		frmRayoo.getContentPane().add(Password);
		
		JButton ButtonLogin = new JButton("A currar");
		ButtonLogin.setFont(new Font("Sitka Small", Font.BOLD, 17));
		ButtonLogin.setBounds(163, 214, 115, 23);
		frmRayoo.getContentPane().add(ButtonLogin);
		Fondo.setIcon(new ImageIcon("src\\images\\bar.jpg"));
		Fondo.setBounds(0, 0, 434, 261);
		frmRayoo.getContentPane().add(Fondo);
		frmRayoo.setVisible(true);
		
		
		// Acciones del login
		
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recoges lo datos introducidos en los campos y los guarda en esas variables
				String dni = JPuser.getText();
				String password = JPpassword.getText();
				// Y llama al chequeo del usuario
				boolean check = new controlador.Login().checkUser(dni, password);
				if(check) {
					Window frame = new Window();	
				}
			}
		});
		
		
	}
}
