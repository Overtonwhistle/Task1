package by.epam.homework.exception;

public class TriangleException extends Exception {

	private static final long serialVersionUID = 1L;

	public TriangleException() {
		super();
	}

	public TriangleException(String message) {
		super(message);
	}

	public TriangleException(Exception e) {
		super(e);
	}

	public TriangleException(String message, Exception e) {
		super(message, e);
	}
}
