package edu.curso.control;
public class ControlException extends Exception {
	public ControlException() {
		super();
	}

	public ControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ControlException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControlException(String message) {
		super(message);
	}

	public ControlException(Throwable cause) {
		super(cause);
	}
}
