package test;

interface OrderState {
	void handleRequest(Order order);
}

class NewOrder implements OrderState{

	@Override
	public void handleRequest(Order order) {
		System.out.println("Dang chuan bi");
		order.setOrderState(new ProOrder());
		
	}
}
class ProOrder implements OrderState{

	@Override
	public void handleRequest(Order order) {
		System.out.println("Dang chuyen");
	}
	
}

class Order{
	private OrderState orderState;

	public Order() {
		orderState = new NewOrder();
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	
	public void handleRequest() {
		orderState.handleRequest(this);
	}
	
	
}
