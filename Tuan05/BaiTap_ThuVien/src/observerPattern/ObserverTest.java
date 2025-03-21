package observerPattern;

public class ObserverTest {
	public static void main(String[] args) {
		Library library = Library.getInstance();

		LibraryStaff staff1 = new LibraryStaff("Vũ");
		LibraryStaff staff2 = new LibraryStaff("Tiến");
		LibraryUser user1 = new LibraryUser("Khánh");
		LibraryUser user2 = new LibraryUser("Khôi");

		// Đăng ký nhận thông báo
		library.addObserver(staff1);
		library.addObserver(staff2);
		library.addObserver(user1);
		library.addObserver(user2);

		// Thêm sách mới
		library.addBook("Lập trình Java cơ bản");
		System.out.println("\n");
		library.addBook("Nhà giả kim");

		// Sách hết hạn mượn
		System.out.println("\n");
		library.bookExpired("Nhà giả kim");

		// Người dùng hủy đăng ký nhận thông báo
		System.out.println("\n");
		library.removeObserver(user1);

		// Thêm sách mới sau khi user1 đã hủy đăng ký
		library.addBook("Clean Code");
	}
}
