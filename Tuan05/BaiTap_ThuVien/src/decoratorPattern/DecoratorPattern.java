package decoratorPattern;

public class DecoratorPattern {
	public static void main(String[] args) {
		// Mượn sách cơ bản
		BookBorrow borrow1 = new BasicBookBorrow("Lập trình Java", "Hải");
		borrow1.borrow();

		System.out.println("\nMượn sách với gia hạn");
		// Mượn sách và gia hạn thêm 7 ngày
		BookBorrow borrow2 = new ExtendedBorrow(new BasicBookBorrow("Clean Code", "Trang"), 7);
		borrow2.borrow();

		System.out.println("\nMượn sách phiên bản đặc biệt");
		// Mượn sách với bản dịch tiếng Anh
		BookBorrow borrow3 = new SpecialEditionBorrow(new BasicBookBorrow("Nhà giả kim", "Minh"), "Bản dịch tiếng Anh");
		borrow3.borrow();

		System.out.println("\nKết hợp nhiều tính năng: Gia hạn + Phiên bản đặc biệt");
		// Mượn sách bản chữ nổi và gia hạn thêm 14 ngày
		BookBorrow borrow4 = new ExtendedBorrow(
				new SpecialEditionBorrow(new BasicBookBorrow("Đắc nhân tâm", "Lan"), "Bản chữ nổi"), 14);
		borrow4.borrow();
	}
}
