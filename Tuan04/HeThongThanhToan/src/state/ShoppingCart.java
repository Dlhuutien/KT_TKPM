package state;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Item> items;
    private PaymentState paymentState;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calculateTotal() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    public void checkout() {
        if (paymentState == null) {
            System.out.println("Vui lòng chọn phương thức thanh toán trước khi thanh toán.");
        } else {
            paymentState.pay(this);
        }
    }
}