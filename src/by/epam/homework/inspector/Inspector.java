package by.epam.homework.inspector;

import java.util.ArrayList;
import java.util.List;

import by.epam.homework.creator.TriangleCreator;
import by.epam.homework.entity.Point;
import by.epam.homework.entity.Triangle;
import by.epam.homework.entity.TriangleData;
import by.epam.homework.exception.TriangleException;
import by.epam.homework.parser.TriangleFileDataParser;
import by.epam.homework.reader.TriangleFileReader;
import by.epam.homework.service.TriangleService;
import by.epam.homework.storage.TriangleStorage;

public class Inspector {

	// private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) throws TriangleException {
		// log.error("Test error!");
		// log.debug("Test debug!");
		// log.info("Test info!");
		// Point a1 = new Point(1, 1);
		// Point b1 = new Point(3, 3);
		// Point c1 = new Point(-2, -7);
		// Triangle tr1 = new Triangle(1000, a1, b1, c1);
		// TriangleData td1 = new TriangleData(TriangleService.calculateSquare(tr1),
		// TriangleService.calculatePerimeter(tr1));
		// // System.out.println(tr1);
		// System.out.println(td1);

		TriangleStorage storage = TriangleStorage.getInstance();
		// storage.addTriangle(tr1, td1);
		// System.out.println(storage.getSize());
		// Triangle tr2 = storage.getTriangleById(1000);
		// System.out.println(tr1.equals(tr2));
		// System.out.println(storage.getTriangleDateById(1000));

		TriangleFileReader reader = new TriangleFileReader();
		List<String> triangleFileDataList = reader.readTrianglesCoordinatesFile();
		// System.out.println(triangleFileDataList);

		TriangleFileDataParser triangleFileDataParser = new TriangleFileDataParser();
		List<double[]> CoordinatesList = triangleFileDataParser
				.getCoordinatesList(triangleFileDataList);

		// TriangleValidator validator = new TriangleValidator();
		for (double[] doubles : CoordinatesList) {
			for (int i = 0; i < doubles.length; i++) {
				System.out.print(doubles[i] + " ");
			}
			System.out.println();

		}

		TriangleCreator triangleCreator = new TriangleCreator();
		List<Triangle> TrianglesList = new ArrayList<>();
		TrianglesList = triangleCreator.getTrianglesList(CoordinatesList);
		// System.out.println(TrianglesList);

		for (Triangle triangle : TrianglesList) {
			storage.addTriangle(triangle,
					new TriangleData(TriangleService.calculateSquare(triangle),
							TriangleService.calculatePerimeter(triangle)));
		}

		Triangle testTriangle = storage.getTriangleById(1000);
		System.out.println("DATA:" + storage.getTriangleDateById(1000));
		testTriangle.setVertexA(new Point(4, 2));
		System.out.println("DATA:" + storage.getTriangleDateById(1000));
	}

}
