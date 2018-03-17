package data_structures.stacks;

import java.util.*;
/**
 * The <code>TowerOfHanoi2</code> class solves the
 * [Tower of Hanoi](https://en.wikipedia.org/wiki/Tower_of_Hanoi) game
 * using the recursive solution. My GenericStack lacks the functionality
 * to do this cleanly, so this uses Java's default Stack class.
 *
 * The game is still solved using the optimal solution, and thus will
 * always be solved in  2^n − 1 moves.
 */
public class ToHRecursive {
    private static int numDiscs = 3;
    private static int counter = 0;
    // Create stack array
    private static Stack<Integer>[] tower = new Stack[4];

    public static void main(String[] args) {
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();

        startGame();
        System.out.println("Game complete in " + (counter-1) + " moves!");
    }

    private static void startGame(){
        for (int i = numDiscs; i > 0; i--) {
            tower[1].push(i);
        }
        showGame();
        move(numDiscs, 1, 2, 3);
    }

    private static void move(int n, int a, int b, int c){
        if (n > 0) {
            move(n-1, a, c, b);
            int disc = tower[a].pop();
            tower[c].push(disc);
            showGame();
            move(n-1, b, a, c);
        }
    }

    private static void showGame() {
        System.out.println("Move #" + counter);
        for(int i = numDiscs - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try
            {
                d1 = String.valueOf(tower[1].get(i));
            }
            catch (Exception exc){
            }
            try
            {
                d2 = String.valueOf(tower[2].get(i));
            }
            catch(Exception exc){
            }
            try
            {
                d3 = String.valueOf(tower[3].get(i));
            }
            catch (Exception exc){
            }
            System.out.println("  " + d1 + "  |  " + d2 + "  |  " + d3);
        }
        System.out.println("-----|-----|-----");
        System.out.println("  A  |  B  |  C");
        System.out.println();
        counter++;
    }
}
