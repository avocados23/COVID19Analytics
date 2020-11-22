package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// --Jonathan Awad (jonathana)

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import spacecolonies.SpaceColonyDataException;

/**
 * Parses through the necessary files and extracts their information
 * 
 * @author Jonathan Awad (jonathana)
 * @version 2020.11.21
 */
public class CovidReader {

    private LinkedList<State> listOfStates;

    public CovidReader(String stateFileName)
        throws FileNotFoundException,
        ParseException,
        InformationException {
        listOfStates = readStatesFile(stateFileName);
        // need to add window and calculator instances
    }


    private LinkedList<State> readStatesFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        InformationException {
        Scanner scanner = new Scanner(new File(fileName));
    }
}
