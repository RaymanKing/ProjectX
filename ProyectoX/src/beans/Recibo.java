package beans;

import java.util.Date;

public class Recibo {

	int idReceipt;
	int idTable;
	int idUser;
	String nameWaiter;
	float price;
	Date transactionDate;
	String wayToPay;
	
	// Constructores
	
	public Recibo() {}
	public Recibo(int idReceipt, int idTable, int idUser, String nameWaiter, float price, Date transactionDate, String wayToPay) {
		this.idReceipt = idReceipt;
		this.idTable = idTable;
		this.idUser = idUser;
		this.nameWaiter = nameWaiter;
		this.price = price;
		this.transactionDate = transactionDate;
		this.wayToPay = wayToPay;
	}
	
	// Getter y setters
	
	public int getIdReceipt() {
		return this.idReceipt;
	}
	
	public void setIdReceipt(int idReceipt) {
		this.idReceipt = idReceipt;
	}
	
	public int getIdTable() {
		return this.idTable;
	}
	
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	
	public int getIdUser(int idUser) {
		return this.idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getNameWaiter() {
		return this.nameWaiter;
	}
	
	public void setNameWaiter(String nameWaiter) {
		this.nameWaiter = nameWaiter;
	}
	
	public Date getTransactionDate() {
		return this.transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String getWayToPay() {
		return this.wayToPay;
	}
	
	public void setWayToPay(String wayToPay) {
		this.wayToPay = wayToPay;
	}
	
	// To string
	
	public String toString() {
		return "El id de recibo numero "+idReceipt+" en la mesa "+idTable+" por el camarero "+nameWaiter+" con el precio de "+price+" euros el día "+transactionDate+" con "+wayToPay;
	}
}
