package data_structures.queues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PartnerQueues {

    public static void main(String[] args) {
        PartnerQueues pq = new PartnerQueues();
        pq.getNames();
    }

    /**
     * Defines the number of participants, then collects each participants name using
     * a Scanner. It places each participant into alternating queues. {@code numPartners} counts the
     * number of partners that are needed. It calls {@code partnerUp()} to match those participants.
     */
    public synchronized void getNames() {
        Scanner scanner = new Scanner(System.in);

        int numPeople = 0;
        // Validates that people input an int
        // If they didn't, it retries getting new user input until it is an int
        boolean isInt = false;
        do {
            try {
                System.out.println("How many people are there?");
                numPeople = scanner.nextInt();
                isInt = true;
            } catch (InputMismatchException ime) {
                System.out.println("Input Mismatch Exception, please enter an integer.");
                scanner.next();
            }
        } while (!isInt);

        // Creates 2 queues so that partners will be mixed up
        GenericQueue<String> group1 = new GenericQueue<>(numPeople / 2 + numPeople % 2);
        GenericQueue<String> group2 = new GenericQueue<>(numPeople / 2);

        int numPartners = 0;
        // Collects participant names, adds them to either group
        for (int i = 0; i < numPeople; i++) {
            System.out.println("Please enter the next participant's name: ");
            String name = scanner.next();
            if (i < group1.size()) {
                try {
                    group1.add(name);
                } catch (QueueFullException e) {
                    e.printStackTrace();
                }
                numPartners++;
            } else {
                try {
                    group2.add(name);
                } catch (QueueFullException e) {
                    e.printStackTrace();
                }
            }
        }
        partnerUp(group1, group2, numPartners);
    }

    /**
     * Matches two groups of people into partners, based on who were first into their queue (FIFO).
     */
    private synchronized void partnerUp(GenericQueue group1, GenericQueue group2, int numPartners) {
        for (int i = 0; i < (numPartners); i++) {
            try {
                if (group2.peek() == null) {
                        System.out.println("Uneven groups means " + group1.remove() + " doesn't get a partner :(");
                } else {
                        System.out.println(group1.remove() + " and " + group2.remove() + " are now partners.");
                }
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}
