package by.epam.homework.entity;

import java.util.LinkedList;
import java.util.List;

import by.epam.homework.observer.Observable;
import by.epam.homework.observer.TriangleObserver;

public class Triangle implements Observable {

	private long id;
	private Point vertexA;
	private Point vertexB;
	private Point vertexC;
	private List<TriangleObserver> observers;

	public Triangle() {
		observers = new LinkedList<>();
	}

	public Triangle(long id, Point pointA, Point pointB, Point pointC) {
		this();
		this.id = id;
		this.vertexA = pointA;
		this.vertexB = pointB;
		this.vertexC = pointC;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point getVertexA() {
		return vertexA;
	}

	public void setVertexA(Point pointA) {
		this.vertexA = pointA;
		notifyObservers();
	}

	public Point getVertexB() {
		return vertexB;
	}

	public void setVertexB(Point pointB) {
		this.vertexB = pointB;
		notifyObservers();
	}

	public Point getVertexC() {
		return vertexC;
	}

	public void setVertexC(Point pointC) {
		this.vertexC = pointC;
		notifyObservers();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((vertexB == null) ? 0 : vertexB.hashCode());
		result = prime * result + ((vertexC == null) ? 0 : vertexC.hashCode());
		result = prime * result + ((vertexA == null) ? 0 : vertexA.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (id != other.id)
			return false;
		if (vertexB == null) {
			if (other.vertexB != null)
				return false;
		} else if (!vertexB.equals(other.vertexB))
			return false;
		if (vertexC == null) {
			if (other.vertexC != null)
				return false;
		} else if (!vertexC.equals(other.vertexC))
			return false;
		if (vertexA == null) {
			if (other.vertexA != null)
				return false;
		} else if (!vertexA.equals(other.vertexA))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Triangle [id:" + id + ", A:" + vertexA + ", B:" + vertexB + ", C:" + vertexC + "]";
	}

	@Override
	public void attachObserver(TriangleObserver o) {
		observers.add(o);

	}

	@Override
	public void detachObserver(TriangleObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (TriangleObserver observer : observers) {
			observer.update(this);
		}
	}

}
