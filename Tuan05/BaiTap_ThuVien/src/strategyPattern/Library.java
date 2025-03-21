package strategyPattern;

import java.util.ArrayList;
import java.util.List;

class Library {
	private static Library instance;
	private List<Book> books;
	private SearchStrategy searchStrategy;

	private Library() {
		books = new ArrayList<>();
	}

	public static Library getInstance() {
		if (instance == null) {
			instance = new Library();
		}
		return instance;
	}

	public void addBook(String title, String author, String category) {
		books.add(new Book(title, author, category));
		System.out.println("Đã thêm sách: " + title);
	}

	public void setSearchStrategy(SearchStrategy searchStrategy) {
		this.searchStrategy = searchStrategy;
	}

	public void searchBooks(String keyword) {
		if (searchStrategy == null) {
			System.out.println("Chưa chọn chiến lược tìm kiếm!");
			return;
		}
		List<Book> result = searchStrategy.search(books, keyword);
		if (result.isEmpty()) {
			System.out.println("Không tìm thấy sách phù hợp.");
		} else {
			System.out.println("Kết quả tìm kiếm:");
			for (Book book : result) {
				System.out.println(book);
			}
		}
	}
}