package error;

public class CustomerCreationException extends RuntimeException {
    public CustomerCreationException() {
        super("Customer could not be created !!!");
    }
}

