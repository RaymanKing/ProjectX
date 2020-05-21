package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import modelo.Trabajadores;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField Bienvenida;

	
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(0, 0, 1650, 1080);
		setBounds(0,0,500,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        
        
        
		Bienvenida = new JTextField();
		Bienvenida.setText("Buenas ");
		Bienvenida.setFont(new Font("Sitka Small", Font.BOLD, 17));
		Bienvenida.setBounds(320, 430, 86, 20);
		contentPane.add(Bienvenida);
		Bienvenida.setColumns(10);
		this.setVisible(true);
		
		
	}
}
