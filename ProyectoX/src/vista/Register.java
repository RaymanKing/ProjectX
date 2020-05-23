package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import beans.Trabajador;
import controlador.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Register extends JFrame {

	private JPanel registerPanel;
	private JTextField JPnombre;
	private JTextField JPapellidos;
	private JTextField JPdni;
	private JFormattedTextField JPtelefono;
	private JLabel texto01;
	private JLabel texto02;
	private JLabel texto03;
	private JLabel texto04;
	private JLabel texto05;
	private JLabel texto07;
	private final ButtonGroup rolGroup = new ButtonGroup();
	private JLabel role;
	private JPasswordField JPpassword;
	private JButton listo;
	private JButton volver;
	private Trabajador trabajador;
	public int rol = 0;
	private JTextField JPyear;
	private JTextField JPmonth;
	private JTextField JPday;
	

	public Register(Trabajador trabajador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\beer.png"));
		this.trabajador = trabajador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerPanel = new JPanel();
		registerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(registerPanel);
		// setBounds(0, 0, 1650, 1080);
		setBounds(0, 0, 500, 500);
		getContentPane().setLayout(null);
		registerPanel.setLayout(null);

		// Campos de recogida de datos

		JPnombre = new JTextField();
		JPnombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPnombre.setText("");
			}
		});
		JPnombre.setHorizontalAlignment(SwingConstants.CENTER);
		JPnombre.setText("Pepe");
		JPnombre.setBounds(192, 30, 185, 33);
		registerPanel.add(JPnombre);
		JPnombre.setColumns(10);

		JPapellidos = new JTextField();
		JPapellidos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPapellidos.setText("");
			}
		});
		JPapellidos.setText("Gutierrez Molina");
		JPapellidos.setHorizontalAlignment(SwingConstants.CENTER);
		JPapellidos.setColumns(10);
		JPapellidos.setBounds(192, 75, 185, 33);
		registerPanel.add(JPapellidos);

		JPdni = new JTextField();
		JPdni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPdni.setText("");
			}
		});
		JPdni.setText("67564263K");
		JPdni.setHorizontalAlignment(SwingConstants.CENTER);
		JPdni.setColumns(10);
		JPdni.setBounds(192, 163, 185, 33);
		registerPanel.add(JPdni);

		JPtelefono = new JFormattedTextField();
		JPtelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPtelefono.setText("");
			}
		});
		
		JPtelefono.setText("765263542");
		JPtelefono.setHorizontalAlignment(SwingConstants.CENTER);
		JPtelefono.setColumns(10);
		JPtelefono.setBounds(192, 207, 185, 33);
		registerPanel.add(JPtelefono);

		JPpassword = new JPasswordField();
		JPpassword.setHorizontalAlignment(SwingConstants.CENTER);
		JPpassword.setBounds(192, 251, 185, 33);
		registerPanel.add(JPpassword);

		JRadioButton rol01 = new JRadioButton("Camarero");
		rolGroup.add(rol01);
		rol01.setBackground(Color.BLACK);
		rol01.setForeground(Color.WHITE);
		rol01.setFont(new Font("Sitka Small", Font.BOLD, 13));
		rol01.setSelected(true);
		rol01.setBounds(184, 314, 119, 23);
		registerPanel.add(rol01);

		JRadioButton rol02 = new JRadioButton("Encargado de almac\u00E9n");
		rol02.setBackground(Color.BLACK);
		rolGroup.add(rol02);
		rol02.setForeground(Color.WHITE);
		rol02.setFont(new Font("Sitka Small", Font.BOLD, 13));
		rol02.setBounds(184, 350, 223, 23);
		registerPanel.add(rol02);

		JRadioButton rol03 = new JRadioButton("Administrador");
		rol03.setBackground(Color.BLACK);
		rolGroup.add(rol03);
		rol03.setForeground(Color.WHITE);
		rol03.setFont(new Font("Sitka Small", Font.BOLD, 13));
		rol03.setBounds(184, 376, 136, 32);
		registerPanel.add(rol03);

		texto01 = new JLabel("Nombre");
		texto01.setForeground(Color.WHITE);
		texto01.setFont(new Font("Sitka Small", Font.BOLD, 13));
		texto01.setBounds(38, 30, 97, 33);
		registerPanel.add(texto01);

		texto02 = new JLabel("Apellidos");
		texto02.setForeground(Color.WHITE);
		texto02.setFont(new Font("Sitka Small", Font.BOLD, 13));
		texto02.setBounds(38, 75, 97, 33);
		registerPanel.add(texto02);

		texto03 = new JLabel("Fecha de nacimiento");
		texto03.setForeground(Color.WHITE);
		texto03.setFont(new Font("Sitka Small", Font.BOLD, 13));
		texto03.setBounds(38, 119, 154, 33);
		registerPanel.add(texto03);

		texto04 = new JLabel("DNI");
		texto04.setForeground(Color.WHITE);
		texto04.setFont(new Font("Sitka Small", Font.BOLD, 13));
		texto04.setBounds(38, 163, 97, 33);
		registerPanel.add(texto04);

		texto05 = new JLabel("N\u00FAmero de tel\u00E9fono");
		texto05.setForeground(Color.WHITE);
		texto05.setFont(new Font("Sitka Small", Font.BOLD, 13));
		texto05.setBounds(38, 207, 144, 33);
		registerPanel.add(texto05);

		texto07 = new JLabel("Contrase\u00F1a");
		texto07.setForeground(Color.WHITE);
		texto07.setFont(new Font("Sitka Small", Font.BOLD, 13));
		texto07.setBounds(38, 251, 97, 33);
		registerPanel.add(texto07);

		role = new JLabel("Rol");
		role.setForeground(Color.WHITE);
		role.setFont(new Font("Sitka Small", Font.BOLD, 18));
		role.setBounds(62, 340, 73, 43);
		registerPanel.add(role);

		listo = new JButton("Listo");
		listo.setForeground(Color.WHITE);
		listo.setFont(new Font("Sitka Small", Font.BOLD, 16));
		listo.setBounds(166, 427, 89, 23);
		registerPanel.add(listo);

		volver = new JButton("");
		volver.setIcon(new ImageIcon("images\\volver.jpg"));
		volver.setBounds(398, 27, 73, 81);
		registerPanel.add(volver);
		
		JPyear = new JTextField();
		JPyear.setText("YYYY");
		JPyear.setHorizontalAlignment(SwingConstants.CENTER);
		JPyear.setBounds(192, 119, 63, 33);
		registerPanel.add(JPyear);
		JPyear.setColumns(10);
		JPyear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPyear.setText("");
			}
		});
		
		JPmonth = new JTextField();
		JPmonth.setText("MM");
		JPmonth.setHorizontalAlignment(SwingConstants.CENTER);
		JPmonth.setColumns(10);
		JPmonth.setBounds(274, 119, 46, 33);
		registerPanel.add(JPmonth);
		JPmonth.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPmonth.setText("");
			}
		});
		
		JPday = new JTextField();
		JPday.setText("DD");
		JPday.setHorizontalAlignment(SwingConstants.CENTER);
		JPday.setColumns(10);
		JPday.setBounds(331, 119, 46, 33);
		registerPanel.add(JPday);
		JPday.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPday.setText("");
			}
		});

		
		

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("images\\registerFondo.jpg"));
		fondo.setBounds(0, 0, 484, 461);
		registerPanel.add(fondo);
		this.setVisible(true);
		
		
		// Acciones en el registro

		listo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Recoges lo datos introducidos en los campos y los guarda en esas variables
				String nombre = JPnombre.getText();
				String apellidos = JPapellidos.getText();
				int year = Integer.parseInt(JPyear.getText());
				int month = Integer.parseInt(JPmonth.getText());
				int day = Integer.parseInt(JPday.getText());
				Date nacimiento = new Date(year, month,day);
				String dni = JPdni.getText();
				int telefono = Integer.parseInt(JPtelefono.getText());
				String password = JPpassword.getText();
				int role = rol;
				Trabajador trabajadorRegistrado = new Trabajador(nombre, apellidos, nacimiento, dni, telefono, password,
						role);
				
				new controlador.Register().trabajadorRegister(trabajadorRegistrado);
				JOptionPane.showMessageDialog(null, "Trabajador registrado correctamente");
				vista.Menu frame = new vista.Menu(trabajador);
				dispose();
			}
		});

		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vista.Menu frame = new vista.Menu(trabajador);
				dispose();
			}
		});

		// Accion grupo botones

		rol01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rol01.isSelected()) {
					rol = 0;
				}
			}
		});

		rol02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rol02.isSelected()) {
					rol = 1;
				}
			}
		});

		rol03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rol03.isSelected()) {
					rol = 101;
				}
			}
		});

	}
}
