package data_structures.queues;

public class GenericQueue<E> {
    // Declare variables
    private E[] qArray;
    private int putloc;
    private int getloc;

    // Constructor
    public GenericQueue(E[] qArray) {
        this.qArray = qArray;
        putloc = getloc = 0;
    }

    /** This add() inserts the specified element {@code a} into the next available location in the queue,
     * if the array has capacity (is not full).
     * */
    public synchronized void add(E a) {
        // should this throw an exception instead of an if statement?
        if (putloc == qArray.length) {
            System.out.println("Queue is full.");
            return;
        } else {
        qArray[putloc++] = a;
        }
    }

    /** This {@code remove()} retrieves and removes whatever element is at the head of the queue, if the queue is
     * not empty.
     * */
    public synchronized E remove() {
        if (putloc == getloc) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            return qArray[getloc++];
        }
    }

    /** This {@code peek()} retrieves, but does not remove, the element is at the head of the queue. If the queue is
     * empty, it returns null.
     * */
    public synchronized E peek() {
        if (putloc == getloc) {
            return null;
        } else {
            return qArray[getloc];
        }
    }
}
