package data_structures.queues;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class GenericQueue<E> {
    // Declare variables
    private E[] qArray;
    private int putloc, getloc;
    private boolean isEmpty;

    // Constructor
    public GenericQueue(E[] qArray) {
        this.qArray = qArray;
        putloc = getloc = 0;
        isEmpty = true;
    }

    /**
     * Inserts the specified element e into the next available location in the queue,
     * if the array has capacity (is not full).
     *
     * @param e is the element to add
     * @return boolean - true if element was successfully added, else false
     * @throws ArrayIndexOutOfBoundsException - if the queue is full and the element cannot be added
     * @throws InputMismatchException - if the element to be added is of the wrong type
     */
    public synchronized boolean add(E e) {
        try {
            qArray[putloc++] = e;
            return true;
        } catch (ArrayIndexOutOfBoundsException aioob) {
            System.out.println(aioob);
            return false;
        } catch (InputMismatchException ime) {
            System.out.println(ime);
            return false;
        }
    }

    /**
     * Inserts the specified element e into the next available location in the queue,
     * if the array has capacity (is not full).
     *
     * @param e is the element to add
     * @return boolean - true if item was successfully added, else false
     */
    public synchronized boolean offer(E e) {
        if (putloc == qArray.length) {
            System.out.println("Queue is full.");
            return false;
        } else {
            qArray[putloc++] = e;
            return true;
        }
    }

    /**
     * Retrieves and removes whatever element is at the head of the queue, if the queue is
     * not empty.
     *
     * @return element at the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public synchronized E remove() throws NoSuchElementException {
        return qArray[getloc++];
    }

    /**
     * Retrieves and removes whatever element is at the head of the queue, if the queue is
     * not empty.
     *
     * @return element at the head of the queue, null if the queue is empty.
     */
    public synchronized E poll() {
        if (putloc == getloc) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            return qArray[getloc++];
        }
    }

    /**
     * Retrieves, but does not remove, the element is at the head of the queue.
     *
     * @return element at the head of the queue, null if the queue is empty.
     */
    public synchronized E peek() {
        if (putloc == getloc) {
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
}
