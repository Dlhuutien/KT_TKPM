package state;

public class StateTest {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		// Thêm sản phẩm vào giỏ hàng
		cart.addItem(new Item("1234", 100000));
		cart.addItem(new Item("5678", 200000));

		// Chưa chọn phương thức thanh toán
		cart.checkout();

		// Chọn thanh toán bằng PayPal
		cart.setPaymentState(new PaypalState("email@example.com", "password123"));
		cart.checkout();

		// Chuyển sang thanh toán bằng thẻ tín dụng
		cart.setPaymentState(new CreditCardState("Dang le Huu Tien", "1234567890123456", "123", "12/27"));
		cart.checkout();

	}

}
