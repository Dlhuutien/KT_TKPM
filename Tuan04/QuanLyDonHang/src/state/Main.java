package state;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.handleRequest();  // Kiểm tra đơn hàng mới tạo
        order.handleRequest();  // Kiểm tra trạng thái đang xử lý
        order.handleRequest();  // Kiểm tra trạng thái đã giao

        // Tạo đơn hàng hủy
        Order cancelledOrder = new Order();
        cancelledOrder.setState(new CancelledOrderState());
        cancelledOrder.handleRequest();  // Kiểm tra trạng thái hủy
    }
}
