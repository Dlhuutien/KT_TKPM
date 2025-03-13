package decorator;

public interface Product{
	 double getPrice();
	 String getDescription();
}

class basicProduct implements Product{

	private String name;
    private double basePrice;

	public basicProduct(String name, double basePrice) {
		super();
		this.name = name;
		this.basePrice = basePrice;
	}

	@Override
	public double getPrice() {
		return basePrice;
	}

	@Override
	public String getDescription() {
		return name;
	}
	
}
