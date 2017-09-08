package exceptions;

@SuppressWarnings("serial")
public class TypeOfCardNotExist extends Exception {
	public TypeOfCardNotExist() {
		super();
	}
	public TypeOfCardNotExist(String message) {
		super(message);
	}
}
