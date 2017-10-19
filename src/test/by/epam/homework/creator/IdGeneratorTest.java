package test.by.epam.homework.creator;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.homework.creator.IdGenerator;

public class IdGeneratorTest extends Assert {

	IdGenerator idGenerator = new IdGenerator();
	Long testId;

	@Test
	public void generateNewId() {
		testId = IdGenerator.generateNewId();
		Assert.assertTrue(testId >= 1000);
	}

	@Test
	public void getLastId() {
		Assert.assertTrue(testId == IdGenerator.getLastId());
	}
}
