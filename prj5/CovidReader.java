package prj5;

import java.io.*;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nam Tran (namht)

/**
 * My ColonyReader class for Project 5.
 * 
 * @author Nam Tran (namht)
 * @version 2020.11.20
 *
 */

public class CovidReader {

    private static LinkedList<State> states;

    /**
     * CovidReader constructor.
     * 
     * @param fileName
     *            File name
     */
    public CovidReader(String fileName) {
        LinkedList<State> stateFile = readStates(fileName);
    }


    private static LinkedList<State> readStates(String fileName) {

        states = new LinkedList<State>();
        String[] stateInfoLines = new String[6];

        try {
            Scanner sc = new Scanner(new File(fileName));
            int i = 0;

            // skip first line
            sc.nextLine();

            while (i < 6 && sc.hasNextLine()) {
                stateInfoLines[i] = sc.nextLine();
                String[] stateInfo = stateInfoLines[i].split(", *");

                String stateName = stateInfo[0];
                int whiteCases = Integer.parseInt(stateInfo[1]);
                int blackCases = Integer.parseInt(stateInfo[2]);
                int latinXCases = Integer.parseInt(stateInfo[3]);
                int asianCases = Integer.parseInt(stateInfo[4]);
                int otherCases = Integer.parseInt(stateInfo[5]);

                int whiteDeaths = Integer.parseInt(stateInfo[6]);
                int blackDeaths = Integer.parseInt(stateInfo[7]);
                int latinXDeaths = Integer.parseInt(stateInfo[8]);
                int asianDeaths = Integer.parseInt(stateInfo[9]);
                int otherDeaths = Integer.parseInt(stateInfo[10]);

                // now, set up race values

                Race[] races = new Race[5];
                races[0] = new Race("white", whiteCases, whiteDeaths);
                races[1] = new Race("black", blackCases, blackDeaths);
                races[2] = new Race("latinx", latinXCases, latinXDeaths);
                races[3] = new Race("asian", asianCases, asianDeaths);
                races[4] = new Race("other", otherCases, otherDeaths);

                states.add(new State(stateName, races));
                i++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return states;
    }
}
