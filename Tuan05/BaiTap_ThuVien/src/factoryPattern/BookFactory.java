package factoryPattern;

interface Book {
	void showInfo();
}

class BookFactory {
	public static Book createBook(String type, String title) {
		switch (type.toLowerCase()) {
		case "paper":
			return new PaperBook(title);
		case "ebook":
			return new EBook(title);
		case "audio":
			return new AudioBook(title);
		default:
			throw new IllegalArgumentException("Loại sách không hợp lệ!");
		}
	}
}