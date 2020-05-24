package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.Conexion;
import beans.Comida;

public class Comidas {

	// M�todo para realizar la bajada del producto en almac�n
	
	public void retiradaAlmacen(int idFood, int cantidad) {
		Conexion.EjecutarUpdate("UPDATE comidas SET Stock = Stock - "+cantidad+" WHERE IdFood = "+idFood);
		JOptionPane.showMessageDialog(null, "Cantidad retirada del almac�n satisfactoriamente.");
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
	
	public int totalComidas() {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT COUNT(IdFood) AS totalComida FROM comidas;");
		int numeroTotal = 0;
		try {
			if(resultado.next()) {
				numeroTotal = resultado.getInt("totalComida");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numeroTotal;
	}
	
	public ArrayList<Comida> arrayComidas(){
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM comidas;");
		ArrayList <Comida> comidas = new ArrayList<Comida>();
		try {
			while(resultado.next()) {
				Comida comida = new Comida();
				int idFood =  resultado.getInt("IdFood");
				String name = resultado.getNString("Name");
				int type = resultado.getInt("Type");
				int stock = resultado.getInt("Stock");
				float price = resultado.getFloat("Price_Unit");
				comida = new Comida(idFood, name, type, stock, price);
				comidas.add(comida);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comidas;
	}
}
