package decorator;

public class Main {
	 public static void main(String[] args) {
	     Order order = new Order();
	     order.setStrategy(new CheckInformationDecorator(new CheckOrderInformationStrategy()));
	     order.handleRequest();  // Kiểm tra thông tin đơn hàng bổ sung

	     order.setStrategy(new PackAndShipDecorator(new PackAndShipOrderStrategy()));
	     order.handleRequest();  // Đóng gói thêm và vận chuyển
	 }
	}
