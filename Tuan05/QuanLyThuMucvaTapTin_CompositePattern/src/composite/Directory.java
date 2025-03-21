package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        children.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "Thư mục: " + name);
        for (FileSystemComponent component : children) {
            component.showInfo(indent + "  ");
        }
    }
}