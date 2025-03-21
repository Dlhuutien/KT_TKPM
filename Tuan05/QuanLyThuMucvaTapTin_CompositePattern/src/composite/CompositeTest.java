package composite;

public class CompositeTest {
	public static void main(String[] args) {
		// Tạo thư mục gốc
		Directory root = new Directory("Thư mục gốc");

		// Tạo thư mục con
		Directory documents = new Directory("Tài liệu");
		Directory images = new Directory("Hình ảnh");

		// Tạo tập tin
		File file1 = new File("Báo cáo.pdf", "Dữ liệu báo cáo");
		File file2 = new File("Ảnh.png", "Dữ liệu ảnh");

		// Thêm tập tin vào thư mục
		documents.addComponent(file1);
		images.addComponent(file2);

		// Thêm thư mục con vào thư mục gốc
		root.addComponent(documents);
		root.addComponent(images);

		// Hiển thị cấu trúc cây thư mục
		root.showInfo("");
	}
}
