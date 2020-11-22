package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// --Jonathan Awad (jonathana)

/**
 * Tests the Race class
 * 
 * @author Jonathan Awad (jonathana)
 * @version 2020.11.21
 */
public class RaceTest extends student.TestCase {

    private Race race;
    private Race negative;
    private Race cfrtest;

    /**
     * setUp() method
     */
    public void setUp() {
        race = new Race("test", 1, 5);
        negative = new Race("abc", -1, 10);
        cfrtest = new Race("cfr", 100, 1);
    }


    /**
     * tests the getRaceName() method
     */
    public void testGetRaceName() {
        assertEquals("test", race.getRaceName());
    }


    /**
     * tests the getRaceName() method
     */
    public void testGetCaseNum() {
        assertEquals(1, race.getCaseNum());
    }


    /**
     * tests the getRaceName() method
     */
    public void testGetDeathNum() {
        assertEquals(5, race.getDeathNum());
    }


    /**
     * test setCaseNum() method
     */
    public void testSetCaseNum() {
        race.setCaseNum(3);
        assertEquals(3, race.getCaseNum());
    }


    /**
     * test setDeathNum() method
     */
    public void testSetDeathNum() {
        race.setDeathNum(10);
        assertEquals(10, race.getDeathNum());
    }


    /**
     * test getCFR() method
     */
    public void testGetCFR() {
        race.setDeathNum(1);
        race.setCaseNum(1);
        assertEquals(100, race.getCFR(), .1);
        assertEquals(-1, negative.getCFR(), .1);
    }


    /**
     * test toString() method
     */
    public void testToString() {
        assertEquals("test: 1 cases, 500% CFR", race.toString());
        assertTrue(negative.toString().equals("abc: -1 cases, -1% CFR"));
        assertTrue(cfrtest.toString().equals("cfr: 100 cases, 1% CFR"));

    }


    /**
     * test equals() method
     */
    public void testEquals() {
        Race other = new Race("test", 1, 5);
        assertTrue(race.equals(other));
        Race test = new Race("wrong", 1, 5);
        assertFalse(race.equals(test));
        other.setCaseNum(10);
        assertFalse(race.equals(other));
        Race other1 = new Race("test", 1, 6);
        assertFalse(race.equals(other1));
        assertFalse(race.equals("t"));
    }
}
