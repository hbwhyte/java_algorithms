package data_structures.stacks;
/**
 * The <code>TowerOfHanoi</code> class represents a working example of
 * my @GenericStack, while solving the classic
 * [Tower of Hanoi][https://en.wikipedia.org/wiki/Tower_of_Hanoi) game.
 * The object of the game is to move the elements of tower A to tower C
 * following these rules:
 *    - Only one disk can be moved at a time.
 *    - Each move consists of taking the upper disk from one of the
 *      stacks and placing it on top of another stack.
 *    - No disk may be placed on top of a smaller disk.
 *
 * This makes use of the <tt>push()</tt>, <tt>pop()</tt>, <tt>peek()</tt>,
 * and <tt>get()</tt> operations of my GenericStack.
 *
 * The game is solved using the optimal iterative solution, and thus will
 * always be solved in  2^n − 1 moves.
 *
 * @author  Heather Whyte
 */
public class TowerOfHanoi {

    private static int numDiscs = 7;
    private static Integer[] towerA = new Integer[numDiscs];
    private static Integer[] towerB = new Integer[numDiscs];
    private static Integer[] towerC = new Integer[numDiscs];
    private static GenericStack<Integer> stackA = new GenericStack(towerA);
    private static GenericStack<Integer> stackB = new GenericStack(towerB);
    private static GenericStack<Integer> stackC = new GenericStack(towerC);
    private static int a, b, c;
    private static boolean complete = false;
    private static int counter = 0;


    public static void main(String[] args) {
        startGame();
        // Order of optimal moves is different if there are an even or odd number of discs
        if(numDiscs%2 != 0){
            int i = Integer.MAX_VALUE;
            while(!complete){
                move(i%3);
                i--;
            }
        } else {
            int i = 0;
            while(!complete){
                move(i%3);
                i++;
            }
        }
    }

    /**
     * Populates the initial stack, based on the number of discs
     */
    private static void startGame() {
        for (int i = numDiscs; i > 0; i--) {
            stackA.push(i);
        }
        showGame();
        getVals();
    }

    /**
     * Converts null values into comparable integers.
     * If the stack is empty, it is given  a value of (numDiscs + 1) so that any of the discs can be put there.
     * Method is run after every move to refresh the compared values.
     */
    private static void getVals() {
        if (stackA.peek() != null) {
            a = stackA.peek();
        } else {
            a  = numDiscs+1;
        }
        if (stackB.peek() != null) {
            b = stackB.peek();
        } else {
            b  = numDiscs+1;
        }
        if (stackC.peek() != null) {
            c = stackC.peek();
        } else {
            c  = numDiscs+1;
        }
    }

    /** Moves one element in the stack based on the game rules, and based on the optimal solution.
     *
     * @param move which move should be made next
     */
    private static void move(int move) {
        switch (move) {
            // if stackA < stackB, pop stackA to stackB, else pop stackB to stackA
            case 0:
                if (a < b) {
                    stackB.push(stackA.pop());
                } else {
                    stackA.push(stackB.pop());
                }
                nextMove();
                break;
            // if stackA < stackC, pop stackA to stackC, else pop stackC to stackA
            case 1:
                if (a < c) {
                    stackC.push(stackA.pop());
                } else {
                    stackA.push(stackC.pop());
                }
                nextMove();
                break;
            // if stackB < stackC, pop stackB to stackC, else pop stackC to stackB
            case 2:
                if (b < c) {
                    stackC.push(stackB.pop());
                } else {
                    stackB.push(stackC.pop());
                }
                nextMove();
                break;
        }
    }
    /** After every move, prints the current game board, resets values, and checks if
     * the game is complete.
     */
    private static void nextMove(){
        showGame();
        getVals();
        if(towerC[numDiscs-1] != null) {
            System.out.println("Game complete in " + (counter-1) + " moves!");
            complete = true;
        }
    }
    /** Prints the current game board and keeps track of how many moves have been made.
     */
    private static void showGame() {
        System.out.println("Move #" + counter);
        for(int i = numDiscs - 1; i >= 0; i--)
        {
            String d1 = " ", d2 = " ", d3 = " ";
            try
            {
                d1 = String.valueOf(stackA.get(i));
                if (d1 == "null") {
                    d1 = " ";
                }
            }
            catch (Exception e){
            }
            try
            {
                d2 = String.valueOf(stackB.get(i));
                if (d2 == "null") {
                    d2 = " ";
                }
            }
            catch(Exception e){
            }
            try
            {
                d3 = String.valueOf(stackC.get(i));
                if (d3 == "null") {
                    d3 = " ";
                }
            }
            catch (Exception e){
            }
            System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
        }
        System.out.println("-----|-----|-----");
        System.out.println("  A\t |  B  |  C");
        System.out.println("\n");
        counter++;
    }
}
