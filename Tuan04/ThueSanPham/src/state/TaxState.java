package state;

interface TaxState {
	double calculateTax(double price);
}

//Thuế tiêu thụ (Consumption Tax) - 8%
class ConsumptionTaxState implements TaxState {
	@Override
	public double calculateTax(double price) {
		return price * 0.08;
	}
}

//Thuế giá trị gia tăng (VAT) - 10%
class VATState implements TaxState {
	@Override
	public double calculateTax(double price) {
		return price * 0.10;
	}
}

//Thuế đặc biệt (Luxury Tax) - 20%
class LuxuryTaxState implements TaxState {
	@Override
	public double calculateTax(double price) {
		return price * 0.20;
	}
}

