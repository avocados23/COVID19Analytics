package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nam Tran (namht)

/**
 * My InformationException test class for Project 5
 * 
 * @author Nam Tran (namht)
 * @version 2020.11.20
 *
 */

public class InformationExceptionTest extends TestCase {

    private Exception ie;

    /**
     * This is my setUp() method
     */
    public void setUp() {
        ie = new InformationException("Information exception");
    }


    /**
     * Tests constructor of a SpaceColonyDataException
     */
    public void testSpaceColonyDataException() {
        assertTrue("Information exception", ie instanceof InformationException);
    }
}
