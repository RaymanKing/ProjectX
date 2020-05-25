package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bbdd.Conexion;
import beans.Pedido;
import beans.Recibo;
import beans.Trabajador;
import vista.Inventario;

public class Recibos {

	public void realizarRecibo(Recibo recibo, int tipoPago) {
		String pagoTipo = "";
		if (tipoPago == 1) {
			pagoTipo = "En efectivo";
		} else {
			pagoTipo = "Con tarjeta";
		}
		int idTable = recibo.getIdTable();
		int idU = recibo.getIdUser();
		String nombre = recibo.getNameWaiter();
		float precio = recibo.getPrice();
		Date transaction = recibo.getTransactionDate();
		Conexion.EjecutarUpdate(
				"INSERT INTO recibos (IdTable,IdUser,NameWaiter,Price,TransactionDate,WayToPay) VALUES ('" + idTable
						+ "','" + idU + "','" + nombre + "','" + precio + "','" + transaction + "','" + pagoTipo
						+ "');");
		JOptionPane.showMessageDialog(null, "Pedido cobrado correctamente.");
	}
	
	public Recibo extraerRecibo() {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM recibos ORDER BY IdReceipt DESC limit 1 ;");
		Recibo recibo = new Recibo();
		try {
			if(resultado.next()) {
				int idRecibo = resultado.getInt("IdReceipt");
				int idTable = resultado.getInt("IdTable");
				int idUser = resultado.getInt("IdUser");
				String nombre = resultado.getNString("NameWaiter");
				float precio = resultado.getFloat("Price");
				Date transaction = resultado.getDate("TransactionDate");
				String tipoPago = resultado.getNString("WayToPay");
				recibo = new Recibo(idRecibo, idTable, idUser, nombre, precio, transaction, tipoPago);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recibo;
	}

}
