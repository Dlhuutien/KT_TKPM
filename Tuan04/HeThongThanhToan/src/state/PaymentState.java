package state;

interface PaymentState {
	void pay(ShoppingCart cart);
}

class CreditCardState implements PaymentState {
	private String name;
	private String cardNumber;
	private String cvv;
	private String expiryDate;

	public CreditCardState(String name, String cardNumber, String cvv, String expiryDate) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	@Override
	public void pay(ShoppingCart cart) {
		int amount = cart.calculateTotal();
		System.out.println(amount + " VNĐ đã được thanh toán bằng Thẻ Tín dụng.");
	}
}

class PaypalState implements PaymentState {
	private String email;
	private String password;

	public PaypalState(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public void pay(ShoppingCart cart) {
		int amount = cart.calculateTotal();
		System.out.println(amount + " VNĐ đã được thanh toán bằng PayPal.");
	}
}