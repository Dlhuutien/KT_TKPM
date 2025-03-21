package factoryPattern;

public class AudioBook implements Book {
    private String title;

    public AudioBook(String title) {
        this.title = title;
    }

    @Override
    public void showInfo() {
        System.out.println("Sách nói: " + title);
    }
}