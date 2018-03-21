package data_structures.queues;

public class BasicQueue {
    public static void main(String[] args) {
        GenericQueue newQueue = new GenericQueue(101);

        // populates an int[] queue with the numbers 0 to 100;
        for (int i = 0; i < newQueue.size(); i++) {
            try {
                newQueue.add(i);
            } catch (QueueFullException e) {
                e.printStackTrace();
            }
        }
        // prints out every even item in the queue
        for (int i = 0; i < newQueue.size(); i++) {
            if(i%2 == 0) {
                try {
                    System.out.println(newQueue.remove());
                } catch (QueueEmptyException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    newQueue.remove();
                } catch (QueueEmptyException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
