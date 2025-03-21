package factoryPattern;

public class FactoryTest {
	public static void main(String[] args) {
		Library library = Library.getInstance();
		library.addBook("paper", "Design Patterns");
		library.addBook("ebook", "Factory Pattern");
		library.addBook("audio", "Clean Code");

		library.showBooks();
	}
}
