package prj5;

import java.util.Arrays;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Nam Tran (namht)

/**
 * State test class.
 * 
 * @author Nam Tran (namht)
 * @version 11.20.20
 */

import student.TestCase;

public class StateTest extends TestCase {

    private Race asian = new Race("asian", 50, 100);
    private Race white = new Race("white", 25, 100);
    private Race black = new Race("black", 20, 100);
    private Race latinx = new Race("latinx", 10, 100);
    private Race other = new Race("other", 60, 100);

    private Race[] r = new Race[4];

    private Race[] rSecond = new Race[4];

    private State georgia;
    private State dc;
    private State md;
    private State va;

    /**
     * This is my setUp() method
     */
    public void setUp() {

        r[0] = asian;
        r[1] = white;
        r[2] = black;
        r[3] = latinx;

        rSecond[0] = other;
        rSecond[1] = new Race("asian", 32, 100);
        rSecond[2] = latinx;
        rSecond[3] = white;

        georgia = new State("georgia", r);
        dc = new State("dc", r);
        md = new State("md", r);
        va = new State("va", r);

    }


    /**
     * Tests my getStateName() method
     */
    public void testGetStateName() {
        assertEquals("dc", dc.getStateName());
    }


    /**
     * Tests my getRaces() method
     */
    public void testGetRaces() {
        assertTrue(Arrays.equals(r, georgia.getRaces()));
        assertFalse(Arrays.equals(georgia.getRaces(), rSecond));
    }


    /**
     * Tests my getTotalCases() method
     */
    public void testGetTotalCases() {
        assertEquals(105, md.getTotalCases());
    }


    /**
     * Tests my getDeaths() method
     */
    public void testGetDeaths() {
        assertEquals(400, va.getDeaths());
    }

}
