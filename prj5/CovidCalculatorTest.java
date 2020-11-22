package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// --Jonathan Awad (jonathana)

/**
 * Tests the CovidCalculator Class
 * 
 * @author Jonathan Awad (jonathana)
 * @version 2020.11.21
 */
public class CovidCalculatorTest extends student.TestCase {

    private CovidCalculator testCalc;
    private State[] testState = new State[3];
    
    /**
     * setUp() method
     */
    public void setUp() {
        testState[1] = new State("a", null);
        testState[2] = new State("a", null);
        testState[3] = new State("a", null);
        testCalc = new CovidCalculator(testState);
    }
}
