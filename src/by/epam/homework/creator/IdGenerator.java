package by.epam.homework.creator;

/**
 * Utility class for {@link TriangleCreator}. Contains methods for consistent
 * generting <b>long</b> type value.
 * 
 * @author Pavel Sorokoletov
 */
public class IdGenerator {

	private static long currentId = 999;

	/**
	 * Returns <b>long</b> type value, beginning of 1000;
	 * 
	 * @return <b>long</b> type value.
	 */
	public static long generateNewId() {
		return ++currentId;
	}

	/**
	 * Returns <b>long</b> type value, equals to the last value returned by the
	 * method {@link generateNewId()}
	 * 
	 * @return <b>long</b> type value.
	 */
	public static long getLastId() {
		return currentId;
	}

}
