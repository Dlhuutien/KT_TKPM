package factoryPattern;

public class PaperBook implements Book {
    private String title;

    public PaperBook(String title) {
        this.title = title;
    }

    @Override
    public void showInfo() {
        System.out.println("Sách giấy: " + title);
    }
}