package strategy;

public class StrategyTest {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		// Thêm sản phẩm vào giỏ hàng
		cart.addItem(new Item("1234", 100000));
		cart.addItem(new Item("5678", 200000));

		// Thanh toán bằng PayPal
		cart.pay(new PaypalStrategy("email@example.com", "password123"));

		// Thanh toán bằng Thẻ Tín Dụng
		cart.pay(new CreditCardStrategy("Dang le Huu Tien", "1234567890123456", "123", "12/27"));
	}
}
