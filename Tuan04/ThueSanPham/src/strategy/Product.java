package strategy;

public class Product {
	private String name;
	private double basePrice;
	private TaxStrategy taxStrategy;

	public Product(String name, double basePrice, TaxStrategy taxStrategy) {
		super();
		this.name = name;
		this.basePrice = basePrice;
		this.taxStrategy = taxStrategy;
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


	public TaxStrategy getTaxStrategy() {
		return taxStrategy;
	}

	public void setTaxStrategy(TaxStrategy taxStrategy) {
		this.taxStrategy = taxStrategy;
	}

	public double calculateFinalPrice() {
		return basePrice + taxStrategy.calculateTax(basePrice);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", basePrice=" + basePrice + ", taxStrategy=" + calculateFinalPrice() + "]";
	}

}
