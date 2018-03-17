package data_structures.queues;

public class BasicQueue {
    public static void main(String[] args) {
        Integer[] intArray = new Integer[101];
        GenericQueue newQueue = new GenericQueue(intArray);

        // populates an int[] queue with the numbers 0 to 100;
        for (int i = 0; i < intArray.length; i++) {
            newQueue.add(i);
        }
        // prints out every even item in the queue
        for (int i = 0; i < intArray.length; i++) {
            if(i%2 == 0) {
                System.out.println(newQueue.remove());
            } else {
                newQueue.remove();
            }
        }
    }
}
