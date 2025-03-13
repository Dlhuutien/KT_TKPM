package strategy;

interface TaxStrategy {
	double calculateTax(double price);
}

//Thuế tiêu thụ (Consumption Tax) - 8%
class ConsumptionTaxStrategy implements TaxStrategy {
	@Override
	public double calculateTax(double price) {
		return price * 0.08;
	}
}

//Thuế giá trị gia tăng (VAT) - 10%
class VATStrategy implements TaxStrategy {
	@Override
	public double calculateTax(double price) {
		return price * 0.10;
	}
}

//Thuế đặc biệt (Luxury Tax) - 20%
class LuxuryTaxStrategy implements TaxStrategy {
	@Override
	public double calculateTax(double price) {
		return price * 0.20;
	}
}

