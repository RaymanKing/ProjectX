package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.Conexion;
import beans.Comida;

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
	
	public int idComida(String nombre) {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT IdFood FROM comidas WHERE Name = '"+nombre+"' ;");
		int id = 0;
		try {
			if(resultado.next()) {
				id = resultado.getInt("IdFood");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void addComida(int id ,int cantidad) {
		Conexion.EjecutarUpdate("UPDATE comidas SET Stock = Stock + "+cantidad+" WHERE IdFood = "+id+"");
		JOptionPane.showMessageDialog(null, "Cantidad añadida al inventario.");
	}
	
	public void crearComida(String nombre, int tipo, int stock, float precio) {
		Conexion.EjecutarUpdate("INSERT INTO comidas (Name, Type, Stock, Price_Unit) VALUES ('"+nombre+"','"+tipo+"','"+stock+"','"+precio+"');");
		JOptionPane.showMessageDialog(null, "Producto añadido al inventario y a la carta.");
	}
	
	public void eliminarComida(int id) {
		Conexion.EjecutarUpdate("DELETE FROM comidas WHERE IdFood = '"+id+"';");
		JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
	}
	
}
