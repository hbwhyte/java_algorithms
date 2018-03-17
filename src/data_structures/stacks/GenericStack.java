package data_structures.stacks;

public class GenericStack<E> {

    private E[] sArray;
    private int putloc, getloc;
    private boolean isEmpty;

    public GenericStack(E[] sArray) {
        this.sArray = sArray;
        putloc = getloc = 0;
        isEmpty = true;
    }

    public GenericStack() {
        putloc = getloc = 0;
        isEmpty = true;
    }

    /** Adds element e to the top of the stack.
     *
     * @param e element to be added
     */
    public void push(E e) {
        if (putloc == sArray.length) {
            System.out.println("Sorry, the stack is full.");
        }
        sArray[putloc++] = e;
        getloc++;
        isEmpty = false;
    }

    /** Returns and removes the element at the top of the stack.
     *
     * @return top element of the stack to be removed
     */
    public E pop() {
        if (putloc == 0) {
            System.out.println("Sorry, the stack is empty.");
            return null;
        }

        E e = peek();
        sArray[--getloc] = null;
        --putloc;

        // check if isEmpty after pop
        if (putloc == 0) {isEmpty = true;}

        return e;
    }


    /** Returns the element at the top of the stack, but does not remove it.
     *
     * @return top element of the stack
     */
    public E peek() {
        if (putloc == 0) {
            return null;
        }
        return sArray[getloc-1];
    }

    /** Returns the element at the specified index, but does not remove it.
     *
     * @param index
     * @return element at the specified index
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *({@code index < 0 || index >= size()})
     */
    public E get(int index) {
        try {
            return sArray[index];
        } catch (ArrayIndexOutOfBoundsException exc) {
            return null;
        }
    }


    /** Checks if the stack is empty or not
     *
     * @return boolean - if true, stack is empty
     */
    public boolean isEmpty() {
        return isEmpty;
    }
}
