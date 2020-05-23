package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.Conexion;
import beans.Comida;
import beans.Pedido;
import beans.Trabajador;
import vista.*;

public class Pedidos{

	public ArrayList <Comida> recogerComidas(int tipo) {
		ResultSet comida = Conexion.EjecutarSentencia("SELECT * FROM comidas WHERE Type = '" + tipo + "'");
		ArrayList <Comida> comidas = new ArrayList<Comida>();
		try {
			while (comida.next()) {
				Comida comidaMostrar = new Comida();
				int idFood = comida.getInt("IdFood");
				String name = comida.getString("Name");
				float precio = comida.getFloat("Price_Unit");
				comidaMostrar = new Comida(idFood, name, precio);
				comidas.add(comidaMostrar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comidas;
	}
	
	public Comida recogerComida(String nombre) {
		ResultSet comidas = Conexion.EjecutarSentencia("SELECT * FROM comidas WHERE Name = '" + nombre + "'");
		Comida comidaMostrar = new Comida();
		try {
			while (comidas.next()) {
				int idFood = comidas.getInt("IdFood");
				String name = comidas.getString("Name");
				float precio = comidas.getFloat("Price_Unit");
				comidaMostrar = new Comida(idFood, name, precio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comidaMostrar;
	}
	
	public void realizarPedido(Pedido pedido) {
		int idTable = pedido.getIdTable();
		int idFood = pedido.getIdFood();
		int cantidad = pedido.getQuantity();
		String comentario = pedido.getCommentary();
		float precio = pedido.getPrice();
		Conexion.EjecutarUpdate("INSERT INTO pedidos VALUES ('"+idTable+"','"+idFood+"','"+cantidad+"','"+comentario+"','"+precio+"');");
		JOptionPane.showMessageDialog(null, "Pedido realizado correctamente");
	}

}
