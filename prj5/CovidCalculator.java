package prj5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * My CovidCalculator class.
 * 
 * @author Nam Tran
 * @version 11.20.20
 *
 */
public class CovidCalculator {

    private LinkedList<State> ll;

    /**
     * Default constructor for CovidCalculator
     * 
     * @param states
     *            States LinkedList that is passed
     */
    public CovidCalculator(LinkedList<State> states) {
        ll = states;
    }

    /**
     * Comparator class for ABC order.
     * 
     * @author Nam Tran (namht)
     * @version 11.20.20
     *
     */
    private class SortABC implements Comparator<Race> {

        /**
         * Compares the two races' names.
         * 
         * @param a
         *            First race
         * @param b
         *            Second race
         * @return String compareTo value
         */
        public int compare(Race a, Race b) {
            return a.getRaceName().compareTo(b.getRaceName());
        }

    }


    /**
     * Comparator class for CFR order.
     * 
     * @author Nam Tran (namht)
     * @version 11.20.20
     *
     */
    private class SortCFR implements Comparator<Race> {

        /**
         * Compares the two races' CFR values.
         * 
         * @param a
         *            First race
         * @param b
         *            Second race
         * @return CFR compareTo value
         */
        public int compare(Race a, Race b) {
            int compareVal = Double.compare(b.getCFR(), a.getCFR());
            if (compareVal == 0) {
                return a.getRaceName().compareTo(b.getRaceName());
            }
            return compareVal;
        }

    }

    /**
     * Sorts by alphabetical order.
     * 
     * @param state
     *            State to sort through
     * @return sorted list by ABC
     */
    public ArrayList<Race> sortByABC(State state) {

        Race[] races = state.getRaces();
        ArrayList<Race> raceList = new ArrayList<Race>(Arrays.asList(races));

        Collections.sort(raceList, new SortABC());

        for (int k = 0; k < raceList.size(); k++) {
            System.out.println(raceList.get(k).toString());
        }
        return raceList;
    }


    /**
     * Sorts by CFR order.
     * 
     * @param state
     *            State to sort through
     * @return the sorted list by CFR
     */
    public ArrayList<Race> sortByCFR(State state) {

        Race[] races = state.getRaces();
        ArrayList<Race> raceList = new ArrayList<Race>(Arrays.asList(races));

        Collections.sort(raceList, new SortCFR());

        for (int j = 0; j < raceList.size(); j++) {
            System.out.println(raceList.get(j).toString());
        }
        return raceList;
    }


    /**
     * Returns the LinkedList of states.
     * 
     * @return ll
     *         List containing the states.
     */
    public LinkedList<State> getLL() {
        return ll;
    }

}
