package factoryPattern;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private static Library instance;
    private List<Book> books;

    private Library() {
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(String type, String title) {
        Book book = BookFactory.createBook(type, title);
        books.add(book);
        System.out.println("Đã thêm sách: " + title + " (" + type + ")");
    }

    public void showBooks() {
        System.out.println("Danh sách sách trong thư viện:");
        for (Book book : books) {
            book.showInfo();
        }
    }
}
