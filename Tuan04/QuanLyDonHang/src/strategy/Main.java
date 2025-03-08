package strategy;

public class Main {
	public static void main(String[] args) {
		Order order = new Order();
		order.handleRequest(); // Kiểm tra thông tin đơn hàng

		order.setStrategy(new PackAndShipOrderStrategy());
		order.handleRequest(); // Đóng gói và vận chuyển

		order.setStrategy(new UpdateOrderStatusStrategy());
		order.handleRequest(); // Cập nhật trạng thái đã giao

		// Tạo đơn hàng hủy
		Order cancelledOrder = new Order();
		cancelledOrder.setStrategy(new CancelOrderAndRefundStrategy());
		cancelledOrder.handleRequest(); // Hủy đơn hàng và hoàn tiền
	}
}
