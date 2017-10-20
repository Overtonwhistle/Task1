package by.epam.homework.creator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.homework.entity.Point;
import by.epam.homework.entity.Triangle;
import by.epam.homework.exception.TriangleCreatorException;
import by.epam.homework.exception.TriangleException;
import by.epam.homework.validator.TriangleValidator;

/**
 * Creator class for {@link Triangle}. Contains methods for constructing one
 * Triangle object and a {@link List} of Triangles.
 * 
 * @author Pavel Sorokoletov
 */

public class TriangleCreator {

	private static final Logger log = LogManager.getLogger();
	private static final int ARRAY_INDEX_OFFSET = 1;

	TriangleValidator coordinatesValidator = new TriangleValidator();

	/**
	 * Returns a new {@link Triangle} class instance. Takes as parameters three
	 * {@link Point} class objects
	 * <p>
	 * NOTE: Points A B � do not be on the same geometric line, otherwise the method
	 * throws an exception.
	 * 
	 * @param vertexA
	 *            coordinates of triangle vertex A.
	 * @param vertexB
	 *            coordinates of triangle vertex B.
	 * @param vertexC
	 *            coordinates of triangle vertex C.
	 * @return Triangle class instance.
	 * @throws TriangleException
	 */
	public Triangle createTriangle(Point vertexA, Point vertexB, Point vertexC)
			throws TriangleException {
		if (coordinatesValidator.isTriangleExist(vertexA, vertexB, vertexC)) {
			return new Triangle(IdGenerator.generateNewId(), vertexA, vertexB, vertexC);
		} else {
			log.log(Level.WARN, "Incorrect vertex coordinates.");
			throw new TriangleCreatorException("Triangle can not be created, wrong coordinates.");
		}
	}

	/**
	 * Returns new {@link List} of {@link Triangle} class instances. Takes as
	 * parameters {@link List} of primitive double[6] array. The array must contain
	 * six values of the type double that are the coordinates of the three vertices
	 * of the triangle.
	 * <p>
	 * If number of coordinates (double[] array lenght) not equals 6, or coordinates
	 * defines three points placed on the same straight line, this input List
	 * element will be skipped.
	 * 
	 * @param listOf�oordinatesArrays
	 *            - {@link List} of double[6] arrays.
	 * 
	 * @return {@link List} of {@link Triangle} class instances.
	 * @throws TriangleException
	 */
	public List<Triangle> getTrianglesList(List<double[]> listOfCoordinatesArrays) {

		List<Triangle> TrianglesList = new ArrayList<>();

		for (int i = 0; i < listOfCoordinatesArrays.size(); i++) {

			double[] coordinates = listOfCoordinatesArrays.get(i);

			if (coordinates.length != 6) {
				log.log(Level.WARN, "Incorrect number of paraneters in line " + (i + 1)
						+ ", this line will be skipped!");
				continue;
			}

			Point vertexA = new Point(coordinates[0], coordinates[1]);
			Point vertexB = new Point(coordinates[2], coordinates[3]);
			Point vertexC = new Point(coordinates[4], coordinates[5]);

			try {
				TrianglesList.add(createTriangle(vertexA, vertexB, vertexC));
			} catch (TriangleException e) {
				log.log(Level.WARN, "Incorrect vertex coordinates in line "
						+ (i + ARRAY_INDEX_OFFSET) + ", this triangle will be skipped!");
				continue;
			}
		}
		return TrianglesList;

	}
}
