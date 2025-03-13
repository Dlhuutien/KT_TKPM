package strategy;

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

	public void removeItem(Item item) {
		items.remove(item);
	}

	private int calculateTotal() {
		return items.stream().mapToInt(Item::getPrice).sum();
	}

	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}
