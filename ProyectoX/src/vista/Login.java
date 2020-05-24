package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel panelLogin;
	private JTextField JPuser;
	private JPasswordField JPpassword;
	private JLabel User;
	private final JLabel Fondo = new JLabel();
	private JLabel Password;
	private JButton ButtonLogin;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelLogin = new JPanel();
		panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelLogin);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		setLocationRelativeTo(null);
		setVisible(true);
		panelLogin.setLayout(null);

		JPuser = new JTextField();
		JPuser.setBounds(156, 73, 180, 20);
		panelLogin.add(JPuser);
		JPuser.setColumns(10);

		JPpassword = new JPasswordField();
		JPpassword.setBounds(156, 149, 180, 20);
		panelLogin.add(JPpassword);

		User = new JLabel("DNI");
		User.setHorizontalAlignment(SwingConstants.CENTER);
		User.setForeground(Color.WHITE);
		User.setFont(new Font("Sitka Small", Font.BOLD, 30));
		User.setBounds(25, 63, 91, 50);
		panelLogin.add(User);

		Password = new JLabel("Password");
		Password.setForeground(Color.WHITE);
		Password.setFont(new Font("Sitka Small", Font.BOLD, 25));
		Password.setBounds(10, 140, 162, 34);
		panelLogin.add(Password);

		ButtonLogin = new JButton("A currar");
		ButtonLogin.setFont(new Font("Sitka Small", Font.BOLD, 17));
		ButtonLogin.setBounds(163, 214, 115, 23);
		panelLogin.add(ButtonLogin);

		Fondo.setIcon(new ImageIcon("images\\bar.jpg"));
		Fondo.setBounds(0, 0, 434, 261);
		panelLogin.add(Fondo);

		// Acciones del login

		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recoges lo datos introducidos en los campos y los guarda en esas variables
				String dni = JPuser.getText();
				String password = JPpassword.getText();
				// Y llama al chequeo del usuario
				boolean cerrar = new controlador.Login().checkUser(dni, password);
				if (cerrar) {
					dispose();
				}
			}
		});

	}

}
