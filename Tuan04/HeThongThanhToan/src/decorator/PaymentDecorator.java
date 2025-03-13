package decorator;

interface Payment {
	void processPayment(int amount);
}

class CreditCardPayment implements Payment {
	private String name;
	private String cardNumber;
	private String cvv;
	private String expiryDate;

	public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}

	@Override
	public void processPayment(int amount) {
		System.out.println(amount + " VNĐ đã được thanh toán bằng Thẻ Tín Dụng của " + name + " (Số thẻ: " + cardNumber
				+ ", Hết hạn: " + expiryDate + ").");
	}
}

class PaypalPayment implements Payment {
	private String email;
	private String password;

	public PaypalPayment(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public void processPayment(int amount) {
		System.out.println(amount + " VNĐ đã được thanh toán qua PayPal (Email: " + email + ").");
	}
}

abstract class PaymentDecorator implements Payment {
	protected Payment decoratedPayment;

	public PaymentDecorator(Payment decoratedPayment) {
		this.decoratedPayment = decoratedPayment;
	}

	@Override
	public void processPayment(int amount) {
		decoratedPayment.processPayment(amount);
	}
}

//Decorator ghi log thanh toán
class LoggingDecorator extends PaymentDecorator {
	public LoggingDecorator(Payment decoratedPayment) {
		super(decoratedPayment);
	}

	@Override
	public void processPayment(int amount) {
		System.out.println("[LOG] Đang xử lý thanh toán...");
		decoratedPayment.processPayment(amount);
		System.out.println("[LOG] Thanh toán hoàn tất.");
	}
}

//Decorator bảo mật giao dịch
class SecurityDecorator extends PaymentDecorator {
	public SecurityDecorator(Payment decoratedPayment) {
		super(decoratedPayment);
	}

	@Override
	public void processPayment(int amount) {
		System.out.println("[SECURITY] Kiểm tra bảo mật giao dịch...");
		decoratedPayment.processPayment(amount);
		System.out.println("[SECURITY] Giao dịch an toàn.");
	}
}