package strategyPattern;

import java.util.ArrayList;
import java.util.List;

interface SearchStrategy {
	List<Book> search(List<Book> books, String keyword);
}

//Tìm kiếm theo tên sách
class SearchByTitle implements SearchStrategy {
	@Override
	public List<Book> search(List<Book> books, String keyword) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(keyword)) {
				result.add(book);
			}
		}
		return result;
	}
}

//Tìm kiếm theo tác giả
class SearchByAuthor implements SearchStrategy {
	@Override
	public List<Book> search(List<Book> books, String keyword) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(keyword)) {
				result.add(book);
			}
		}
		return result;
	}
}

//Tìm kiếm theo thể loại
class SearchByCategory implements SearchStrategy {
	@Override
	public List<Book> search(List<Book> books, String keyword) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getCategory().equalsIgnoreCase(keyword)) {
				result.add(book);
			}
		}
		return result;
	}
}
