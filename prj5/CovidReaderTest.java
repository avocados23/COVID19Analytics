package prj5;

import student.TestCase;

public class CovidReaderTest extends TestCase {

    private CovidReader cr;

    /**
     * my setUp() method
     */
    public void setUp() {
        cr = new CovidReader("Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv");
    }
    
    /**
     * test
     */
    public void testCR() {

    }

}
