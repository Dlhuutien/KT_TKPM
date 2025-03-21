package composite;

public class File implements FileSystemComponent {
    private String name;
    private String data;

    public File(String name, String data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "Tập tin: " + name);
    }
}
