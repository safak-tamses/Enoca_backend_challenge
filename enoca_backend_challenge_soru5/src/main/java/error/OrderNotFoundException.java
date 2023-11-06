package error;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException() {
        super("Customer not found!!!");
    }
}
