package factoryPattern;

public class EBook implements Book {
	private String title;

	public EBook(String title) {
		this.title = title;
	}

	@Override
	public void showInfo() {
		System.out.println("Sách điện tử: " + title);
	}
}