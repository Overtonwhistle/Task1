package test.by.epam.homework.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.homework.entity.Point;
import by.epam.homework.entity.Triangle;
import by.epam.homework.exception.TriangleException;
import by.epam.homework.service.TriangleService;

public class TriangleServiceTest extends Assert {

	@DataProvider
	public Object[][] isRightTrianglesData() {
		return new Object[][] {
				{ new Triangle(1000, new Point(1, 1), new Point(3, 1), new Point(3, 3)) },
				{ new Triangle(1001, new Point(0, 0), new Point(2, 0), new Point(0, -2)) },
				{ new Triangle(1002, new Point(0, 0), new Point(2, 2), new Point(-2, 2)) }, };
	}

	@DataProvider
	public Object[][] isNotRightTrianglesData() {
		return new Object[][] {
				{ new Triangle(1000, new Point(1, 3), new Point(3, 1), new Point(3, 3)) },
				{ new Triangle(1001, new Point(-2, 0), new Point(2, 4), new Point(0, -2)) },
				{ new Triangle(1000, new Point(4, 3), new Point(3, 1), new Point(3, 3)) }, };
	}

	@Test
	public void calculatePerimeter() throws TriangleException {
		Point vertexA = new Point(0, 0);
		Point vertexB = new Point(2, 0);
		Point vertexC = new Point(2, 2);
		Triangle triangle = new Triangle(1000, vertexA, vertexB, vertexC);
		double actual = TriangleService.calculatePerimeter(triangle);
		double expected = 4 + Math.sqrt(8);
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void calculateSquare() throws TriangleException {
		Point vertexA = new Point(0, 0);
		Point vertexB = new Point(2, 0);
		Point vertexC = new Point(2, 2);
		Triangle triangle = new Triangle(1000, vertexA, vertexB, vertexC);
		double actual = TriangleService.calculateSquare(triangle);
		double expected = 2;
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "isRightTrianglesData")
	public void isRightTriangle(Triangle triangle) throws TriangleException {
		boolean actual = TriangleService.isRightTriangle(triangle);
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "isNotRightTrianglesData")
	public void isNotRightTriangle(Triangle triangle) throws TriangleException {
		boolean actual = TriangleService.isRightTriangle(triangle);
		boolean expected = false;
		Assert.assertNotEquals(actual, expected);
	}

	@Test(expectedExceptions = TriangleException.class)
	public void calculatePerimeterWithNull() throws TriangleException {
		TriangleService.calculateSquare(null);
	}

	@Test(expectedExceptions = TriangleException.class)
	public void calculateSquareWithNull() throws TriangleException {
		TriangleService.calculateSquare(null);
	}

	@Test(expectedExceptions = TriangleException.class)
	public void isRightTriangleWithNull() throws TriangleException {
		TriangleService.isRightTriangle(null);
	}

}
