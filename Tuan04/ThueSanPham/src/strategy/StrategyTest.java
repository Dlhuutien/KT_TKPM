package strategy;

public class StrategyTest {
	public static void main(String[] args) {
		 // Tạo sản phẩm với thuế mặc định (VAT)
		Product p1 = new Product("Iphone 15", 20000, new VATStrategy());
		
		// Hiển thị giá ban đầu
		System.out.println(p1.toString());

        // Thay đổi chiến lược thuế sang thuế tiêu thụ
        p1.setTaxStrategy(new ConsumptionTaxStrategy());
        System.out.println("\nSau khi áp dụng thuế tiêu thụ:");
        System.out.println(p1.toString());
		
		 // Thay đổi chiến lược thuế cho sản phẩm xa xỉ
        p1.setTaxStrategy(new LuxuryTaxStrategy());
        System.out.println("\nSau khi áp dụng thuế xa xỉ:");
        System.out.println(p1.toString());

	}
}
