// Interface của trạng thái
package state;
interface OrderState {
    void handleRequest(Order order);
}

// Các trạng thái cụ thể
class NewOrderState implements OrderState {
    @Override
    public void handleRequest(Order order) {
        System.out.println("Đơn hàng mới được tạo.");
        order.setState(new ProcessingOrderState());
    }
}

class ProcessingOrderState implements OrderState {
    @Override
    public void handleRequest(Order order) {
        System.out.println("Đang xử lý đơn hàng.");
        order.setState(new DeliveredOrderState());
    }
}

class DeliveredOrderState implements OrderState {
    @Override
    public void handleRequest(Order order) {
        System.out.println("Đơn hàng đã được giao.");
    }
}

class CancelledOrderState implements OrderState {
    @Override
    public void handleRequest(Order order) {
        System.out.println("Đơn hàng đã bị hủy.");
    }
}

// Lớp Order quản lý trạng thái
class Order {
    private OrderState state;

    public Order() {
        state = new NewOrderState();  // Trạng thái ban đầu là Mới tạo
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void handleRequest() {
        state.handleRequest(this);
    }
}

// Main để kiểm tra

