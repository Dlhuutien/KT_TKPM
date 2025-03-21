package singletonPattern;

public class SingletonTest {
	public static void main(String[] args) {
        Library library1 = Library.getInstance();
        library1.addBook("Design Patterns");
        library1.addBook("Singleton Pattern");

        Library library2 = Library.getInstance();
        library2.showBooks();

        // Kiểm tra hai instance
        System.out.println(library1 == library2);
        }
}
