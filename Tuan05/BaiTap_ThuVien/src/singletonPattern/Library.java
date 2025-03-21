package singletonPattern;

import java.util.ArrayList;
import java.util.List;

class Library {
    private static Library instance; 
    private List<String> books;

    private Library() {
        books = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(String book) {
        books.add(book);
        System.out.println("Đã thêm sách: " + book);
    }

    public void showBooks() {
        System.out.println("Danh sách sách trong thư viện:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }
}

