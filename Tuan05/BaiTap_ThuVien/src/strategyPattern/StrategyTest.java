package strategyPattern;

public class StrategyTest {
	public static void main(String[] args) {
		Library library = Library.getInstance();

		library.addBook("Lập trình hướng đối tượng", "A", "Công nghệ");
		library.addBook("Thuật toán và lập trình", "B", "Công nghệ");
		library.addBook("Nhà giả kim", "Đặng Lê Hữu Tiến", "Văn học");
		library.addBook("Tư duy lập trình", "D", "Công nghệ");

		// Tìm sách theo tên
		System.out.println("\nTìm theo tên: 'Thuật toán và lập trình'");
		library.setSearchStrategy(new SearchByTitle());
		library.searchBooks("Thuật toán và lập trình");

		// Tìm sách theo tác giả
		System.out.println("\nTìm theo tác giả: 'Đặng Lê Hữu Tiến'");
		library.setSearchStrategy(new SearchByAuthor());
		library.searchBooks("Đặng Lê Hữu Tiến");

		// Tìm sách theo thể loại
		System.out.println("\nTìm theo thể loại: 'Công nghệ'");
		library.setSearchStrategy(new SearchByCategory());
		library.searchBooks("Công nghệ");

	}
}
