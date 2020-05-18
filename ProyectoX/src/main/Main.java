package main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbdd.Conexion;
import vista.Login;

public class Main {

	public static void main(String[] args) throws SQLException{
		/* Conecto con la base de datos */
		Conexion.Conectar();
		
		/* Ahora arrancaremos la interfaz gráfica del programa */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}