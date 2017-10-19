package by.epam.homework.exception;

public class TriangleStorageException extends TriangleException {

	private static final long serialVersionUID = 1L;

	public TriangleStorageException() {
		super();
	}

	public TriangleStorageException(String message) {
		super(message);
	}

	public TriangleStorageException(Exception e) {
		super(e);
	}

	public TriangleStorageException(String message, Exception e) {
		super(message, e);
	}
}
