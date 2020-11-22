package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// --Jonathan Awad (jonathana)

<<<<<<< Updated upstream
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nam Tran (namht)

/**
 * CovidCalculator class
 * 
 * @author Nam Tran (namht), Jonathan Awad
 * @version 11.20.20
 */

=======
import java.util.Arrays;

/**
 * Sorts the states by alphabetical order and the races by highest to lowest CFR
 * 
 * @author Jonathan Awad (jonathana)
 * @verson 2020.11.21
 */
>>>>>>> Stashed changes
public class CovidCalculator {

    /**
     * the total number of states
     */
    public static final int NUM_STATES = 6;
    private LinkedList<State> linkedList;
    private State[] states;

    /**
     * CovidCalculator constructor
     * 
     * @param stateName
     * @param list
     */
    public CovidCalculator(State[] stateName) {
        states = new State[NUM_STATES];
    }

    /**
     * sorts the states by alphabetical order
     */
    public void sortByABC() {
        State[] sortAlpha = Arrays.copyOf(states, states.length);
        Arrays.sort(sortAlpha, 1, sortAlpha.length);
    }


    /**
     * sorts the states by Case Fatality Ratio
     */
    public void sortByCFR() {

    }
}
