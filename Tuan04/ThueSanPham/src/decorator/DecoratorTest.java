package decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		Product iphone = new basicProduct("iPhone 15", 20000);
		System.out.println(iphone.getDescription() + " Price: $" + iphone.getPrice());

		// Áp dụng thuế VAT
		Product iphoneWithVAT = new VATTaxDecorator(iphone);
		System.out.println(iphoneWithVAT.getDescription() + " Price: $" + iphoneWithVAT.getPrice());

		// Áp dụng thuế tiêu thụ
		Product iphoneWithConsumptionTax = new ConsumptionTaxDecorator(iphoneWithVAT);
		System.out
				.println(iphoneWithConsumptionTax.getDescription() + " Price: $" + iphoneWithConsumptionTax.getPrice());

		// Áp dụng thuế xa xỉ
		Product luxuryIphone = new LuxuryTaxDecorator(iphoneWithConsumptionTax);
		System.out.println(luxuryIphone.getDescription() + " Price: $" + luxuryIphone.getPrice());
	}
}
