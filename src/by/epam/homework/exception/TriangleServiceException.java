package by.epam.homework.exception;

public class TriangleServiceException extends TriangleException {

	private static final long serialVersionUID = 1L;

	public TriangleServiceException() {
		super();
	}

	public TriangleServiceException(String message) {
		super(message);
	}

	public TriangleServiceException(Exception e) {
		super(e);
	}

	public TriangleServiceException(String message, Exception e) {
		super(message, e);
	}
}
