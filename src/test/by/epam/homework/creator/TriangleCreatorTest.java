package test.by.epam.homework.creator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.homework.creator.IdGenerator;
import by.epam.homework.creator.TriangleCreator;
import by.epam.homework.entity.Point;
import by.epam.homework.entity.Triangle;
import by.epam.homework.exception.TriangleCreatorException;
import by.epam.homework.exception.TriangleException;

public class TriangleCreatorTest {

	TriangleCreator triangleCreator = new TriangleCreator();

	@DataProvider
	public Object[][] validVertexData() {
		return new Object[][] { { new Point(1, 1), new Point(3, 1), new Point(3, 3) },
				{ new Point(0, 0), new Point(2, 0), new Point(0, -2) },
				{ new Point(0, 0), new Point(2, 2), new Point(-2, 2) } };
	}

	@DataProvider
	public Object[][] invalidVertexData() {
		return new Object[][] { { new Point(1, 3), new Point(-4, 3), new Point(3, 3) },
				{ new Point(-2, 0), new Point(-2, 4), new Point(-2, -2) },
				{ new Point(4, 4), new Point(0, 0), new Point(3, 3) } };
	}

	@DataProvider
	public Object[][] nullVertexData() {
		return new Object[][] { {null, new Point(-4, 3), new Point(3, 3) },
				{ new Point(-2, 0), null, new Point(-2, -2) },
				{ new Point(4, 4), new Point(0, 0), null } };
	}
	
	@Test(dataProvider = "validVertexData")
	public void createTriangleTest(Point vertexA, Point vertexB, Point vertexC)
			throws TriangleException {
		Triangle localTriangle = new Triangle(1000, vertexA, vertexB, vertexC);
		Triangle testingTriangle = triangleCreator.createTriangle(vertexA, vertexB, vertexC);
		boolean isSame = (localTriangle.getVertexA() == testingTriangle.getVertexA())
				&& (localTriangle.getVertexB() == testingTriangle.getVertexB())
				&& (localTriangle.getVertexC() == testingTriangle.getVertexC())
				&& (IdGenerator.getLastId() == testingTriangle.getId());
		Assert.assertTrue(isSame);

	}

	@Test(dataProvider = "invalidVertexData", expectedExceptions = TriangleCreatorException.class)
	public void createTriangleWithInvalidDataExceptionTest(Point vertexA, Point vertexB, Point vertexC)
			throws TriangleException {
		triangleCreator.createTriangle(vertexA, vertexB, vertexC);
	}
	
	@Test(dataProvider = "nullVertexData", expectedExceptions = TriangleException.class)
	public void createTriangleWithNullDataExceptionTest(Point vertexA, Point vertexB, Point vertexC)
			throws TriangleException {
		triangleCreator.createTriangle(vertexA, vertexB, vertexC);
	}

	// @Test
	// public void getTrianglesList() {
	// throw new RuntimeException("Test not implemented");
	// }
}
