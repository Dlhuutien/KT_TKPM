package decorator;

public class DecoratorTest {
	 public static void main(String[] args) {
	     Order order = new Order();
	     order.setStrategy(new CheckInformationDecorator(new CheckOrderInformationStrategy()));
	     // Kiểm tra thông tin đơn hàng bổ sung
	     order.handleRequest(); 

	     // Đóng gói thêm và vận chuyển
	     order.setStrategy(new PackAndShipDecorator(new PackAndShipOrderStrategy()));
	     order.handleRequest();  
	 }
	}
