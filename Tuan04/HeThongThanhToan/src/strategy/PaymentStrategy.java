package strategy;

interface PaymentStrategy {
	void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private String cardNumber;
	private String cvv;
	private String expiryDate;

	public CreditCardStrategy(String name, String cardNumber, String cvv, String expiryDate) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " VNĐ đã được thanh toán bằng Thẻ Tín dụng.");
	}
}

class PaypalStrategy implements PaymentStrategy {
	private String email;
	private String password;

	public PaypalStrategy(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " VNĐ đã được thanh toán bằng PayPal.");
	}
}