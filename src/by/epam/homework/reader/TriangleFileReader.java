package by.epam.homework.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.homework.exception.TriangleFileReaderException;

public class TriangleFileReader {

	private final static Logger log = LogManager.getLogger(TriangleFileReader.class.getName());
	private final static String TRIANGLE_DEFAULT_DATA_PATH = "./src/by/epam/homework/files/triangle_data.txt";

	public TriangleFileReader() {
	}


	public List<String> readTrianglesCoordinatesFile(String filepath)
			throws TriangleFileReaderException {

		List<String> triangleInputCoordinatesList = new ArrayList<>();

		try {
			triangleInputCoordinatesList = Files.readAllLines(Paths.get(filepath),
					StandardCharsets.UTF_8);
		} catch (IOException e) {

			log.log(Level.ERROR, "File reading error.");
			throw new TriangleFileReaderException("File reading error", e);

		}

		return triangleInputCoordinatesList;
	}

	public List<String> readTrianglesCoordinatesFile() throws TriangleFileReaderException {
		return readTrianglesCoordinatesFile(TRIANGLE_DEFAULT_DATA_PATH);
	}

}
