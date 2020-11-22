package prj5;

import student.TestCase;
import java.util.ArrayList;

/**
 * My test class for CovidCalculator.
 * 
 * @author Nam Tran (namht)
 * @version 11.20.20
 */
public class CovidCalculatorTest extends TestCase {

    private CovidCalculator cc;
    private LinkedList<State> states = new LinkedList<State>();
    private Race[] races = new Race[4];

    /**
     * This is my setUp() method
     */
    public void setUp() {
        races[0] = new Race("asian", 10, 20);
        races[1] = new Race("black", 5, 20);
        races[2] = new Race("other", 5, 20);
        races[3] = new Race("latinx", 15, 20);

        states.add(new State("VA", races));
        cc = new CovidCalculator(states);
    }


    /**
     * Tests the constructor
     */
    public void testCovidCalculator() {
        assertNotNull(cc);
    }


    /**
     * Tests retrieving the LinkedList
     */
    public void testGetLL() {
        assertEquals(states, cc.getLL());
    }


    /**
     * Tests sorting by ABC
     */
    public void testSortByABC() {
        ArrayList<Race> sorted = cc.sortByABC(states.get(0));
        assertEquals(races[0], sorted.get(0));
    }


    /**
     * Tests sorting by CFR
     */
    public void testSortByCFR() {
        ArrayList<Race> sorted = cc.sortByCFR(states.get(0));
        assertEquals(races[1], sorted.get(0));
    }

}
