package data_structures.queues;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class GenericQueue<E> {
    // Declare variables
    private E[] qArray;
    private int putloc, getloc;
    private boolean isEmpty, isFull;

    // Constructor
    public GenericQueue(int length) {
        this.qArray = (E[]) new Object[length];
        putloc = getloc = 0;
        isEmpty = true;
        isFull = false;
    }

    /**
     * Inserts the specified element e into the next available location in the queue,
     * if the array has capacity (is not full). If adding is successful, isEmpty becomes
     * false, and putloc increases by one index.
     *
     * @param e is the element to add
     * @return boolean true if element was successfully added, else false
     * @throws QueueFullException custom exception if the queue is full
     * @throws InputMismatchException if the element to be added is of the wrong type
     */
    public synchronized boolean add(E e) throws QueueFullException{
        if (isFull || putloc == qArray.length) {
            throw new QueueFullException("Unable to add " + e + "to the queue. The queue is full.");
        }
        try {
            qArray[putloc++] = e;
            isEmpty = false;
            return true;
        } catch (InputMismatchException ime) {
            System.out.println(ime);
            return false;
        }
    }

    /**
     * Retrieves and removes whatever element is at the head of the queue, if the queue is
     * not empty. If removing is successful, isFull is set to false, and getloc increases
     * by one index.
     *
     * @return element at the head of the queue
     * @throws QueueEmptyException custom exception if the queue is empty
     */
    public synchronized E remove() throws QueueEmptyException {
        if (isEmpty || putloc == getloc) {
            throw new QueueEmptyException("Nothing to remove. The queue is empty.");
        } else {
            E e = qArray[getloc++];
            if (getloc == putloc) {
                isEmpty = true;
            }
            return e;
        }
    }

    /**
     * Retrieves, but does not remove, the element is at the head of the queue.
     *
     * @return element at the head of the queue, null if the queue is empty.
     */
    public synchronized E peek() {
        if (isEmpty || putloc == getloc) {
            return null;
        } else {
            return qArray[getloc];
        }
    }

    /**
     * Checks if the queue is empty or not
     *
     * @return true if the queue is empty, else false
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Checks if the queue is full or not
     *
     * @return true if the queue is full, else false
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * Returns the size of the array, based on the length of the underlying array
     *
     * @return array size
     */
    public int size() {
        return this.qArray.length;
    }


}
