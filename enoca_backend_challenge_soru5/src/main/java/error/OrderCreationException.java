package error;

public class OrderCreationException extends RuntimeException{
    public OrderCreationException() {
        super("Order could not be created !!!");
    }
}
