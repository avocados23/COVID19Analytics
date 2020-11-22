package prj5;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @author Omar Siddiqi
 * @version 11.20.20
 *
 */
public class Input {

    /**
     * 
     * The project runner
     * 
     * @param args
     * 
     * @throws ParseException
     *             is there is a parse exception
     * 
     * @throws Information
     *             Exception
     *             if there is some information exception
     * 
     * @throws FileNotFoundException
     *             if the file is not found
     * 
     */
    public static void main(String[] args)
        throws ParseException,

        InformationException,

        FileNotFoundException {

        Scanner file1 = new Scanner(new File(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv"));
        Scanner file2 = new Scanner(new File(
            "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv"));

        System.out.println(file1);
        System.out.println(file2);

    }

}
