package observer;

public class TeamMember implements TaskObserver {
	private String name;
	
	public TeamMember(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String taskName, String status) {
		System.out.println(name + " nhận thông báo: Công việc " + taskName + " có trạng thái mới: " + status);
	}
}
