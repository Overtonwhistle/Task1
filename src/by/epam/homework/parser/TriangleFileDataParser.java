package by.epam.homework.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleFileDataParser {

//	private static final Logger log = LogManager.getLogger(TriangleFileDataParser.class.getName());
	private static final Logger log = LogManager.getLogger();

	public static final String VALUES_DELIMITER = ",";

	public List<double[]> getCoordinatesList(List<String> triangleInputCoordinatesList) {

		List<double[]> listOfCoordinatesArrays = new ArrayList<>();

		for (String triangleString : triangleInputCoordinatesList) {
			String[] coordinatesStringArray = triangleString.split(VALUES_DELIMITER);
			if (coordinatesStringArray.length < 6) {
				log.log(Level.WARN, "Invalid number of parameters: [" + triangleString
						+ "], line will be skipped!");
				continue;
			}

			double[] coordinatesArray = new double[6];

			try {
				for (int i = 0; i < 6; i++) {
					coordinatesArray[i] = Double.parseDouble(coordinatesStringArray[i].trim());
				}
			} catch (NumberFormatException e) {

				log.log(Level.WARN, "Invalid character in line: [" + triangleString
						+ "], line will be skipped!");
				continue;
			}
			listOfCoordinatesArrays.add(coordinatesArray);
		}

		return listOfCoordinatesArrays;
	}

}
