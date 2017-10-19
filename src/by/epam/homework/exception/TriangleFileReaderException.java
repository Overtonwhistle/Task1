package by.epam.homework.exception;

public class TriangleFileReaderException extends TriangleException {

	private static final long serialVersionUID = 1L;

	public TriangleFileReaderException() {
		super();
	}

	public TriangleFileReaderException(String message) {
		super(message);
	}

	public TriangleFileReaderException(Exception e) {
		super(e);
	}

	public TriangleFileReaderException(String message, Exception e) {
		super(message, e);
	}
}
