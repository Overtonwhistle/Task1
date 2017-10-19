package by.epam.homework.validator;

import by.epam.homework.entity.Point;
import by.epam.homework.exception.TriangleException;

public class TriangleValidator {

	public TriangleValidator() {
	};

	public boolean isTriangleExist(Point a, Point b, Point c) throws TriangleException {

		if ((a == null) || (b == null) || (c == null)) {
			throw new TriangleException("Null triangle reference");
		}

		double xA = a.getX();
		double yA = a.getY();
		double xB = b.getX();
		double yB = b.getY();
		double xC = c.getX();
		double yC = c.getY();
		double square = Math.abs((xB - xA) * (yC - yA) - (xC - xA) * (yB - yA)) / 2;
		return square != 0;

	}

}
