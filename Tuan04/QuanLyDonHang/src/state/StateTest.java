package state;

public class StateTest {
    public static void main(String[] args) {
        Order order = new Order();
        // Kiểm tra đơn hàng mới tạo
        order.handleRequest();  
        // Kiểm tra trạng thái đang xử lý
        order.handleRequest();  
        // Kiểm tra trạng thái đã giao
        order.handleRequest();  

        // Tạo đơn hàng hủy
        Order cancelledOrder = new Order();
        cancelledOrder.setState(new CancelledOrderState());
        // Kiểm tra trạng thái hủy
        cancelledOrder.handleRequest();  
    }
}
