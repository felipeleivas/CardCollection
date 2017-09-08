package exceptions;

@SuppressWarnings("serial")
public class CardWithThatNameAlreadyExistException extends Exception {
	public CardWithThatNameAlreadyExistException(){
		super();
	}
	
	public CardWithThatNameAlreadyExistException(String message){
		super(message);
	}
}
