package savingsApp.utils;

public enum ExpenseType {
	
	FIXED("#2ecc71"), TRANSPORTATION("#3498db"), FOOD("#9b59b6"), UTILITIES("#f1c40f"), RECREATIONAL("#e74c3c"), MISCELLANEOUS("#34495e");
	
	private ExpenseType(String color) {
		this.color = color;
	}

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
