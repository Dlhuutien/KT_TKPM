package decorator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int calculateTotal() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public void checkout(Payment payment) {
        int amount = calculateTotal();
        payment.processPayment(amount);
    }
}
