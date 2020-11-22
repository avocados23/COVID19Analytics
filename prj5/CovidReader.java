/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.text.ParseException;

/**
 * @author Omar Siddiqi
 *
 */
public class CovidReader {

    private State[] states;
    private LinkedList<State> listOfStates;

    @SuppressWarnings("unused")
    public CovidReader(String state)

        throws InformationException,

        ParseException,

        FileNotFoundException {

        listOfStates = readListFile(theList);

        states = readStateFile(state);

        CovidFrontEnd window = new CovidFrontEnd(new CovidCalculator(
            listOfStates, states));

    }


    private State[] readStateFile(String fileName)
        throws InformationException,

        ParseException,

        FileNotFoundException {

        State[] states = new State();
        Scanner value1 = new Scanner(new File(fileName));

    }


    private LinkedList<State> readListFile(String fileName)
        throws InformationException,

        ParseException,

        FileNotFoundException {

        LinkedList<State> listOfStates = new LinkedList();
        Scanner value2 = new Scanner(new File(fileName));

    }

}
