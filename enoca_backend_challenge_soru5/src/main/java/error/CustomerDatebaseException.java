package error;

public class CustomerDatebaseException extends RuntimeException{
    public CustomerDatebaseException() {
        super("Something gone wrong!!!");
    }
}
