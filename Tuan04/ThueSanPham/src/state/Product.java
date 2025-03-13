package state;

public class Product {
	private String name;
	private double basePrice;
	private TaxState taxState;

	public Product(String name, double basePrice) {
		super();
		this.name = name;
		this.basePrice = basePrice;
		this.taxState = new VATState();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public TaxState getTaxState() {
		return taxState;
	}

	public void setTaxState(TaxState taxState) {
		this.taxState = taxState;
	}

	public double calculateFinalPrice() {
		return basePrice + taxState.calculateTax(basePrice);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", basePrice=" + basePrice + ", taxState=" + calculateFinalPrice() + "]";
	}

}
