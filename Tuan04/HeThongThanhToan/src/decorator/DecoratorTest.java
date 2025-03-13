package decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		// Thêm sản phẩm vào giỏ hàng
		cart.addItem(new Item("Áo thun", 150000));
		cart.addItem(new Item("Giày sneaker", 800000));

		System.out.println("\n--- Thanh toán bằng PayPal với Logging ---");
		Payment paypal = new LoggingDecorator(new PaypalPayment("email@example.com", "password123"));
		cart.checkout(paypal);

		System.out.println("\n--- Thanh toán bằng Thẻ Tín Dụng với Bảo mật ---");
		Payment creditCard = new SecurityDecorator(
				new CreditCardPayment("Đặng Lê Hữu Tiến", "1234567890123456", "123", "12/27"));
		cart.checkout(creditCard);

		System.out.println("\n--- Thanh toán bằng Thẻ Tín Dụng với cả Logging và Bảo mật ---");
		Payment secureLoggedCreditCard = new LoggingDecorator(new SecurityDecorator(
				new CreditCardPayment("Đặng Lê Hữu Tiến", "1234567890123456", "123", "12/27")));
		cart.checkout(secureLoggedCreditCard);

	}
}
