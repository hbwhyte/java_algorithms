package data_structures.queues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PartnerQueues {

    public static void main(String[] args) {
        PartnerQueues partnerQueue = new PartnerQueues();
        partnerQueue.getNames();
    }

    /**
     * Defines the number of participants, then collects each participants name using
     * a Scanner. It places each participant into alternating queues. {@code numPartners} counts the
     * number of partners that are needed. It calls {@code partnerUp()} to match those participants.
     */
    private synchronized void getNames() {
        String[] participants;
        String[] participants2;
        Scanner scanner = new Scanner(System.in);

        int numPeople = 0;
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

        participants = new String[numPeople / 2 + numPeople % 2];
        participants2 = new String[numPeople / 2];

        GenericQueue<String> group1 = new GenericQueue<>(participants);
        GenericQueue<String> group2 = new GenericQueue<>(participants2);

        int numPartners = 0;
        for (int i = 0; i < numPeople; i++) {
            System.out.println("Please enter the next participant's name: ");
            String name = scanner.next();
            if (i % 2 == 0) {
                group1.offer(name);
                numPartners++;
            } else {
                group2.offer(name);
            }
        }
        partnerUp(group1, group2, numPartners);
    }

    /**
     * Matches two groups of people into partners, based on who were first into their queue (FIFO).
     */
    private synchronized void partnerUp(GenericQueue group1, GenericQueue group2, int numPartners) {
        for (int i = 0; i < (numPartners); i++) {
            if (group1.peek() == null || group2.peek() == null) {
                System.out.println("Uneven groups means " + group1.peek() + " doesn't get a partner :(");
            } else {
                System.out.println(group1.poll() + " and " + group2.poll() + " are now partners.");
            }
        }
    }
}
