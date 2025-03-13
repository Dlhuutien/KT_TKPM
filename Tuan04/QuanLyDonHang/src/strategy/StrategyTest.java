package strategy;

public class StrategyTest {
	public static void main(String[] args) {
		Order order = new Order();
		// Kiểm tra thông tin đơn hàng
		order.handleRequest(); 

		// Đóng gói và vận chuyển
		order.setStrategy(new PackAndShipOrderStrategy());
		order.handleRequest(); 

		// Cập nhật trạng thái đã giao
		order.setStrategy(new UpdateOrderStatusStrategy());
		order.handleRequest(); 

		// Tạo đơn hàng hủy
		Order cancelledOrder = new Order();
		cancelledOrder.setStrategy(new CancelOrderAndRefundStrategy());
		cancelledOrder.handleRequest(); // Hủy đơn hàng và hoàn tiền
	}
}
