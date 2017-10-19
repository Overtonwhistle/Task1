package by.epam.homework.observer;

public interface Observable {
	
	void attachObserver(TriangleObserver o);

	void detachObserver(TriangleObserver o);

	void notifyObservers();
}
