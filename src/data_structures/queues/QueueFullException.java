package data_structures.queues;

public class QueueFullException extends Exception{

    public QueueFullException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "QueueFullException {message = '" + getMessage() + "'}";
    }
}
