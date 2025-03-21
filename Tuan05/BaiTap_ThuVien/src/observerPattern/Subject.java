package observerPattern;

public interface Subject {
	void addObserver(LibraryObserver observer);
    void removeObserver(LibraryObserver observer);
    void notifyObservers(String message);
}
