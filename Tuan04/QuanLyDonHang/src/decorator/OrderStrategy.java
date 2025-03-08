package decorator;

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

//Interface Decorator
interface OrderDecorator extends OrderStrategy {
	void decorate();
}

//Các decorator mở rộng hành động
class CheckInformationDecorator implements OrderDecorator {
	private OrderStrategy strategy;

	public CheckInformationDecorator(OrderStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void execute() {
		strategy.execute();
		System.out.println("Kiểm tra thêm thông tin đơn hàng.");
	}

	@Override
	public void decorate() {
		execute();
	}
}

class PackAndShipDecorator implements OrderDecorator {
	private OrderStrategy strategy;

	public PackAndShipDecorator(OrderStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void execute() {
		strategy.execute();
		System.out.println("Đóng gói thêm và vận chuyển đơn hàng.");
	}

	@Override
	public void decorate() {
		execute();
	}
}

//Lớp Order quản lý chiến lược và decorator
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
