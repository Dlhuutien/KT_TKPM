package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Library implements Subject {
	private static Library instance;
	private List<LibraryObserver> observers;
	private List<String> books;

	private Library() {
		observers = new ArrayList<>();
		books = new ArrayList<>();
	}

	public static Library getInstance() {
		if (instance == null) {
			instance = new Library();
		}
		return instance;
	}

	// Đăng ký người nhận thông báo
	@Override
	public void addObserver(LibraryObserver observer) {
		observers.add(observer);
	}

	// Hủy đăng ký nhận thông báo
	@Override
	public void removeObserver(LibraryObserver observer) {
		observers.remove(observer);
	}

	// Gửi thông báo đến tất cả người quan tâm
	@Override
	public void notifyObservers(String message) {
		for (LibraryObserver observer : observers) {
			observer.update(message);
		}
	}

	// Thêm sách mới vào thư viện
	public void addBook(String bookTitle) {
		books.add(bookTitle);
		System.out.println("Đã thêm sách mới: " + bookTitle);
		notifyObservers("Sách mới có sẵn: " + bookTitle);
	}

	// Xử lý sách hết hạn mượn
	public void bookExpired(String bookTitle) {
		System.out.println("Sách '" + bookTitle + "' đã hết hạn mượn.");
		notifyObservers("Sách '" + bookTitle + "' đã hết hạn mượn. Vui lòng trả sách sớm.");
	}
}