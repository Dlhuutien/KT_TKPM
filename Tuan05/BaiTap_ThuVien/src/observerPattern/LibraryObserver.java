package observerPattern;

interface LibraryObserver {
	void update(String message);
}

//Nhân viên thư viện nhận thông báo
class LibraryStaff implements LibraryObserver {
	private String name;

	public LibraryStaff(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println("Nhân viên " + name + " nhận thông báo: " + message);
	}
}

//Người dùng theo dõi thư viện
class LibraryUser implements LibraryObserver {
	private String name;

	public LibraryUser(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println("Người dùng " + name + " nhận thông báo: " + message);
	}
}
