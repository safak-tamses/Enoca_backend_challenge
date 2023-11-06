package error;

public class OrderDatabaseException extends RuntimeException{
    public OrderDatabaseException() {
        super("Something gone wrong!!!");
    }
}
