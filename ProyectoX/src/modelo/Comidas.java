package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bbdd.Conexion;

public class Comidas {

	// Método para realizar la bajada del producto en almacén
	
	public void retiradaAlmacen(int idFood, int cantidad) {
		Conexion.EjecutarUpdate("UPDATE comidas SET Stock = Stock - "+cantidad+" WHERE IdFood = "+idFood);
		JOptionPane.showMessageDialog(null, "Cantidad retirada del almacén satisfactoriamente.");
	}
	
	public String traerNomComida(int idFood) {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT Name FROM comidas WHERE IdFood = '"+idFood+"';");
		String nameFood = null;
		try {
			if(resultado.next()) {
				nameFood = resultado.getNString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameFood;
	}
	
	
}
