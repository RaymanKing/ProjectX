package beans;

import java.sql.Date;

public class Caja {

	int idReceipt;
	float amount;
	float currentBox;
	float finalBox;
	Date transactionDate;

	// CONSTRUCTORES

	public Caja() {
	}

	public Caja(int idReceipt, float amount, float currentBox, float finalBox, Date transactionDate) {
		this.idReceipt = idReceipt;
		this.amount = amount;
		this.currentBox = currentBox;
		this.finalBox = finalBox;
		this.transactionDate = transactionDate;
	}

	// GETTERS Y SETTERS

	public int getIdReceipt() {
		return this.idReceipt;
	}

	public void setIdReceipt(int idReceipt) {
		this.idReceipt = idReceipt;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getCurrentBox() {
		return this.currentBox;
	}

	public void setCurrentBox(float currentBox) {
		this.currentBox = currentBox;
	}

	public float getFinalBox() {
		return this.finalBox;
	}

	public void setFinalBox(float finalBox) {
		this.finalBox = finalBox;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	// TO STRING

	@Override

	public String toString() {
		return "El recibo con ID " + idReceipt + " con la cantidad de " + amount + " euros, el día " + transactionDate
				+ " . Teniamos en caja la cantidad de " + currentBox + " euros y tenemos despues de este recibo "
				+ finalBox + " euros.";
	}

}
