package beans;

public class Pedido {

	int idTable;
	int idFood;
	int quantity;
	String commentary;
	float price;
	
	// Constructores
	
	public Pedido() {}
	public Pedido(int idTable, int idFood, int quantity, String commentary, float price) {
		this.idTable = idTable;
		this.idFood = idFood;
		this.quantity = quantity;
		this.commentary = commentary;
		this.price = price;
	}
	
	// Constructor para mostrar en la tabla de la mesa sin el comentario
	public Pedido(int idTable, int idFood, int quantity, float price) {
		this.idTable = idTable;
		this.idFood = idFood;
		this.quantity = quantity;
		this.price = price;
	}
	
	// Getters y setters
	
	public int getIdTable() {
		return this.idTable;
	}
	
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	
	public int getIdFood() {
		return this.idFood;
	}
	
	public void setIdTabel(int idFood) {
		this.idFood = idFood;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getCommentary() {
		return this.commentary;
	}
	
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	// To string
	
	public String toString() {
		return "La mesa con id "+idTable+" tiene la comida con el id "+idFood+" con la cantidad de "+quantity+" unidades con el precio de "+price+" euros. Con comentario especial "+commentary+" .";
	}
	
}
