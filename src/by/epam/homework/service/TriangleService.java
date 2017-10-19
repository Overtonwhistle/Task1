package by.epam.homework.service;

import by.epam.homework.entity.Point;
import by.epam.homework.entity.Triangle;
import by.epam.homework.exception.TriangleException;

public class TriangleService {

	public static double calculateSquare(Triangle triangle) throws TriangleException {

		if (triangle == null) {
			throw new TriangleException("Null triangle reference");
		}

		double square;
		Point a = triangle.getVertexA();
		Point b = triangle.getVertexB();
		Point c = triangle.getVertexC();

		square = Math.abs(((a.getX() - c.getX()) * (b.getY() - c.getY())
				- (b.getX() - c.getX()) * (a.getY() - c.getY())) * 0.5);

		return square;
	}

	public static double calculatePerimeter(Triangle triangle) throws TriangleException {

		if (triangle == null) {
			throw new TriangleException("Null triangle reference");
		}

		double perimeter;
		Point a = triangle.getVertexA();
		Point b = triangle.getVertexB();
		Point c = triangle.getVertexC();

		double sideAB = Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
		double sideAC = Math.hypot(a.getX() - c.getX(), a.getY() - c.getY());
		double sideBC = Math.hypot(b.getX() - c.getX(), b.getY() - c.getY());

		perimeter = sideAB + sideAC + sideBC;

		return perimeter;
	}

	public static boolean isRightTriangle(Triangle triangle) throws TriangleException {

		if (triangle == null) {
			throw new TriangleException("Null triangle reference");
		}

		Point a = triangle.getVertexA();
		Point b = triangle.getVertexB();
		Point c = triangle.getVertexC();

		double edgeSqAB = Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2);
		double edgeSqAC = Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2);
		double edgeSqBC = Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2);

		return edgeSqAB + edgeSqAC == edgeSqBC || edgeSqAC + edgeSqBC == edgeSqAB
				|| edgeSqBC + edgeSqAB == edgeSqAC;

	}

}
