package observer;

import java.util.ArrayList;
import java.util.List;

public class Task {
	private String name;
	private String status;
	private List<TaskObserver> observers = new ArrayList<>();

	public Task(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}

	public void addObserver(TaskObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(TaskObserver observer) {
		observers.remove(observer);
	}

	private void notifyObservers() {
		for (TaskObserver observer : observers) {
			observer.update(name, status);
		}
	}

	// Thay đổi trạng thái công việc
	public void setStatus(String status) {
		this.status = status;
		notifyObservers();
	}

}
