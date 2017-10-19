package test.by.epam.homework.validator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.homework.entity.Point;
import by.epam.homework.exception.TriangleException;
import by.epam.homework.validator.TriangleValidator;

public class TriangleValidatorTest extends Assert {

	private TriangleValidator triangleValidator;

	@DataProvider
	public Object[][] exisingTrianglesData() {
		return new Object[][] { { new Point(1, 1), new Point(3, 5), new Point(0, 7) },
				{ new Point(3.5, 3e1), new Point(-3.22, 15.0), new Point(22.4, -7) }, };
	}

	@DataProvider
	public Object[][] notExisingTrianglesData() {
		return new Object[][] { { new Point(1, 1), new Point(1, 5), new Point(1, 7) },
				{ new Point(3, 2), new Point(0, 0), new Point(-3, -2) }, };
	}

	@BeforeClass(description = "Initializing TriangleValidator reference")
	public void initValidator() {
		triangleValidator = new TriangleValidator();
	}

	@Test(dataProvider = "exisingTrianglesData")
	public void IsTriangleExistTest(Point vertexA, Point vertexB, Point vertexC)
			throws TriangleException {
		boolean test = triangleValidator.isTriangleExist(vertexA, vertexB, vertexC);
		Assert.assertTrue(test, "Triangle exist");
	}

	@Test(dataProvider = "notExisingTrianglesData")
	public void IsTriangleNotExistTest(Point vertexA, Point vertexB, Point vertexC)
			throws TriangleException {
		boolean test = triangleValidator.isTriangleExist(vertexA, vertexB, vertexC);
		Assert.assertFalse(test, "Triangle not exist");
	}

	@Test(expectedExceptions = TriangleException.class)
	public void isTriangleExistWithNull() throws TriangleException {
		Point vertexA = null;
		Point vertexB = new Point(0, -0);
		Point vertexC = new Point(-12, -10);
		triangleValidator.isTriangleExist(vertexA, vertexB, vertexC);

	}

	@AfterClass(description = "Null-ing TriangleValidator reference")
	public void deleteValidator() throws Exception {
		triangleValidator = null;
	}
}
