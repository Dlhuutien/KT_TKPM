package decorator;

public abstract class TaxDecorator implements Product{
	protected Product product;

	public TaxDecorator(Product product) {
		super();
		this.product = product;
	}

	@Override
	public double getPrice() {
		return product.getPrice();
	}

	@Override
	public String getDescription() {
		return product.getDescription();
	}
	
}
class ConsumptionTaxDecorator extends TaxDecorator{

	public ConsumptionTaxDecorator(Product product) {
		super(product);
	}
	
	@Override
	public double getPrice() {
		return product.getPrice() * 1.08;
	}

	@Override
	public String getDescription() {
		return product.getDescription() + "+ Consumption tax";
	}
}
class VATTaxDecorator extends TaxDecorator {
    public VATTaxDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() * 1.10;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + VAT Tax";
    }
}
class LuxuryTaxDecorator extends TaxDecorator {
    public LuxuryTaxDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() * 1.20;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Luxury Tax";
    }
}

