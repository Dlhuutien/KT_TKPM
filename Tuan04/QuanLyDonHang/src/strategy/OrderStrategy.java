package strategy;

//Interface của chiến lược
interface OrderStrategy {
	void execute();
}

//Các chiến lược cụ thể
class CheckOrderInformationStrategy implements OrderStrategy {
	@Override
	public void execute() {
		System.out.println("Kiểm tra thông tin đơn hàng.");
	}
}

class PackAndShipOrderStrategy implements OrderStrategy {
	@Override
	public void execute() {
		System.out.println("Đóng gói và vận chuyển.");
	}
}

class UpdateOrderStatusStrategy implements OrderStrategy {
	@Override
	public void execute() {
		System.out.println("Cập nhật trạng thái đơn hàng là đã giao.");
	}
}

class CancelOrderAndRefundStrategy implements OrderStrategy {
	@Override
	public void execute() {
		System.out.println("Hủy đơn hàng và hoàn tiền.");
	}
}

//Lớp Order quản lý chiến lược
class Order {
	private OrderStrategy strategy;

	public Order() {
		strategy = new CheckOrderInformationStrategy(); // Mặc định kiểm tra thông tin
	}

	public void setStrategy(OrderStrategy strategy) {
		this.strategy = strategy;
	}

	public void handleRequest() {
		strategy.execute(); // Thực thi chiến lược
	}
}

//Main để kiểm tra
