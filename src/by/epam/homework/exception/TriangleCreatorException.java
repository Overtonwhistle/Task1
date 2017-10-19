package by.epam.homework.exception;

public class TriangleCreatorException extends TriangleException {

	private static final long serialVersionUID = 1L;

	public TriangleCreatorException() {
		super();
	}

	public TriangleCreatorException(String message) {
		super(message);
	}

	public TriangleCreatorException(Exception e) {
		super(e);
	}

	public TriangleCreatorException(String message, Exception e) {
		super(message, e);
	}
}
