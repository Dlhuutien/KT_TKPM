package observer;

public class ObserverTest {
	public static void main(String[] args) {
		Task task1 = new Task("Xây dựng API", "Pending");

		TeamMember member1 = new TeamMember("Khánh");
		TeamMember member2 = new TeamMember("Khôi");

		task1.addObserver(member1);
		task1.addObserver(member2);

		System.out.println("Thay đổi trạng thái công việc");
		task1.setStatus("In Progress");
	}
}
