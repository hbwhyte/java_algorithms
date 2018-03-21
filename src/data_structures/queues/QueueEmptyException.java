package data_structures.queues;

public class QueueEmptyException extends Exception {

    public QueueEmptyException(String message) {
        super(message);
    }

    public String toString() {
        return "QueueEmptyException {message = \'" + getMessage() + "\'}";
    }
}
