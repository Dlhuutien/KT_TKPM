package state;

public class StateTest {
	public static void main(String[] args) {
		Product product = new Product("Iphone 15", 20000);

		// Hiển thị giá với thuế mặc định (VAT)
		System.out.println(product.toString());

		// Thay đổi thuế cho sản phẩm thường sang thuế tiêu thụ
		product.setTaxState(new ConsumptionTaxState());
		System.out.println("\nSau khi áp dụng thuế tiêu thụ:");
		System.out.println(product.toString());

		// Thay đổi thuế cho sản phẩm xa xỉ
		product.setTaxState(new LuxuryTaxState());
		System.out.println("\nSau khi áp dụng thuế xa xỉ:");
		System.out.println(product.toString());

	}
}
