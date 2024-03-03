package linkedList;

public class NoSuchElementException extends Exception {
	NoSuchElementException(){
		super("There is no element for the operation you have chosen:NoSuchElementException");
	}
	NoSuchElementException(String message){
	super(message);
	}

}
