package by.epam.homework.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.homework.entity.Triangle;
import by.epam.homework.entity.TriangleData;
import by.epam.homework.exception.TriangleException;
import by.epam.homework.exception.TriangleStorageException;
import by.epam.homework.observer.TriangleObserver;
import by.epam.homework.service.TriangleService;

public class TriangleStorage implements TriangleObserver {

	private static final Logger log = LogManager.getLogger(TriangleStorage.class.getName());

	private static TriangleStorage instance = new TriangleStorage();

	private TriangleStorage() {
	}

	private Map<Triangle, TriangleData> storageMap = new HashMap<Triangle, TriangleData>();

	public static TriangleStorage getInstance() {

		return instance;
	}

	public void addTriangle(Triangle triangle, TriangleData triangleData) {
		triangle.attachObserver(this);
		storageMap.put(triangle, triangleData);

	}

	public int getSize() {

		return storageMap.size();

	}

	public TriangleData getTriangleData(Triangle triangle) throws TriangleException {

		if (triangle == null) {
			throw new TriangleStorageException("Null triangle reference");
		}

		if (storageMap.containsKey(triangle)) {
			return storageMap.get(triangle);
		} else
			throw new TriangleStorageException("Triangle not found");
	}

	public Triangle getTriangleById(int id) throws TriangleException {

		if (id <= 0) {
			throw new TriangleStorageException("Incorrect triangle ID");
		}

		for (Entry<Triangle, TriangleData> entry : storageMap.entrySet()) {
			Triangle triangle = entry.getKey();
			if (triangle.getId() == id) {
				return triangle;
			}
		}
		throw new TriangleStorageException("Triangle not found");
	}

	public TriangleData getTriangleDateById(long id) throws TriangleException {

		if (id <= 0) {
			throw new TriangleStorageException("Incorrect triangle ID");
		}

		for (Entry<Triangle, TriangleData> entry : storageMap.entrySet()) {
			Triangle triangle = entry.getKey();
			if (triangle.getId() == id) {
				return entry.getValue();
			}
		}
		throw new TriangleStorageException("Triangle not found");
	}

	@Override
	public void update(Triangle triangle) {
		TriangleData triangleData;
		try {
			triangleData = getTriangleDateById(triangle.getId());
			triangleData.setPerimeter(TriangleService.calculatePerimeter(triangle));
			triangleData.setSquare(TriangleService.calculateSquare(triangle));
		} catch (TriangleException e) {
			log.log(Level.ERROR, "Unsuccessful data update");
		}
	}

}
