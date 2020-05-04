package main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbdd.Conexion;

public class Main {

	public static void main(String[] args) throws SQLException{
		/* Conecto con la base de datos */
		Conexion.Conectar();
		
	}

}
