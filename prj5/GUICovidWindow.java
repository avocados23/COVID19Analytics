// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Jonathan Awad (jonathana) Omar Siddiqi (omarsiddiqi)
package prj5;

import cs2.Window;
import java.awt.Color;
import java.util.ArrayList;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.WindowSide;

/**
 * Display window
 * 
 * @author Jonathan Awad (jonathana), Omar Siddiqi (omarsiddiqi), Nam Tran
 *         (namht)
 * @version 2020.12.03
 */
public class GUICovidWindow {

    private Window window;
    private CovidCalculator covidCalculator;
    private Button quitButton;
    private Button sortCFRButton;
    private Button sortAlphaButton;
    private Button repDC;
    private Button repGA;
    private Button repMD;
    private Button repNC;
    private Button repTN;
    private Button repVA;
    private TextShape textShape;
    private int lastStateMemory;

    private static int barXPos = 25;
    private static int barYPos = 225;
    private static int spacingSize = 100;
    private int spacingCounter = 1;

    /**
     * Constructor for GUICovidWindow
     * 
     * @param covid
     *            passes CovidCalculator as a parameter
     *
     */
    public GUICovidWindow(CovidCalculator covid) {

        window = new Window();
        window.setTitle("COVID-19 CFR Visualization");
        covidCalculator = covid;
        lastStateMemory = -1; // default value

        // Initializing buttons on bottom of window
        repDC = new Button("Represent DC");
        window.addButton(repDC, WindowSide.SOUTH);
        repDC.onClick(this, "clickedRepDC");

        repGA = new Button("Represent GA");
        window.addButton(repGA, WindowSide.SOUTH);
        repGA.onClick(this, "clickedRepGA");

        repMD = new Button("Represent MD");
        window.addButton(repMD, WindowSide.SOUTH);
        repMD.onClick(this, "clickedRepMD");

        repNC = new Button("Represent NC");
        window.addButton(repNC, WindowSide.SOUTH);
        repNC.onClick(this, "clickedRepNC");

        repTN = new Button("Represent TN");
        window.addButton(repTN, WindowSide.SOUTH);
        repTN.onClick(this, "clickedRepTN");

        repVA = new Button("Represent VA");
        window.addButton(repVA, WindowSide.SOUTH);
        repVA.onClick(this, "clickedRepVA");

        // top of window
        sortAlphaButton = new Button("Sort by Alpha");
        window.addButton(sortAlphaButton, WindowSide.NORTH);
        sortAlphaButton.onClick(this, "clickedSortAlphaButton");

        sortCFRButton = new Button("Sort By CFR");
        window.addButton(sortCFRButton, WindowSide.NORTH);
        sortCFRButton.onClick(this, "clickedSortCFRButton");

        quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuitButton");

        // title
        this.textShape = new TextShape(250, 25, "");
        window.addShape(textShape);

    }


    /**
     * Exits the window when quit is clicked
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedQuitButton(Button button) {
        System.exit(0);
    }


    /**
     * sets the appropriate title and displays the graph of the values for DC
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepDC(Button button) {
        textShape.setText("DC Case Fatality Ratios by Race");
        this.updateRace(0);
        this.updateCFR(0);
        this.updateBar(0);
    }


    /**
     * sets the appropriate title and displays the graph of the values for GA
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepGA(Button button) {
        textShape.setText("GA Case Fatality Ratios by Race");
        this.updateRace(1);
        this.updateCFR(1);
        this.updateBar(1);
    }


    /**
     * sets the appropriate title and displays the graph of the values for MD
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepMD(Button button) {
        textShape.setText("MD Case Fatality Ratios by Race");
        this.updateRace(2);
        this.updateCFR(2);
        this.updateBar(2);
    }


    /**
     * sets the appropriate title and displays the graph of the values for NC
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepNC(Button button) {
        textShape.setText("NC Case Fatality Ratios by Race");
        this.updateRace(3);
        this.updateCFR(3);
        this.updateBar(3);
    }


    /**
     * sets the appropriate title and displays the graph of the values for TN
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepTN(Button button) {
        textShape.setText("TN Case Fatality Ratios by Race");
        this.updateRace(4);
        this.updateCFR(4);
        this.updateBar(4);
    }


    /**
     * sets the appropriate title and displays the graph of the values for VA
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepVA(Button button) {
        textShape.setText("VA Case Fatality Ratios by Race");
        this.updateRace(5);
        this.updateCFR(5);
        this.updateBar(5);
    }


    /**
     * Displays the values sorted in alphabetical order when Sort by Alpha is
     * clicked
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedSortAlphaButton(Button button) {
        this.updateRaceABC(lastStateMemory);
        this.updateCFRABC(lastStateMemory);
        this.updateBarABC(lastStateMemory);
    }


    /**
     * Displays the CFR values sorted from greatest to least when Sort by CFR is
     * clicked
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedSortCFRButton(Button button) {
        this.updateRaceCFR(lastStateMemory);
        this.updateCFRCFR(lastStateMemory);
        this.updateBarCFR(lastStateMemory);
    }


    /**
     * 
     * It will match the color for the item removed from the bag
     * 
     */
    public void colorText() {
        String theColor = textShape.getText();
        if (theColor.contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else if (theColor.contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }
    }


    /**
     * the function will move the text to the center
     */
    public void centerText() {
        int theHeight = window.getGraphPanelHeight() / 2;
        int theWidth = window.getGraphPanelWidth() / 2;
        int writingHeight = textShape.getHeight() / 2;
        int writingWidth = textShape.getWidth() / 2;
        textShape.setY(theHeight - writingHeight);
        textShape.setX(theWidth - writingWidth);
    }


    /**
     * Updates the race
     * 
     * @param num
     */
    private void updateRace(int num) {
        window.removeAllShapes();

        if (!(num < 0)) {
            State currentState = covidCalculator.getLL().get(num);
            Race[] currentRaces = currentState.getRaces();

            for (int i = 0; i < currentRaces.length; i++) {
                String currentRace = currentRaces[i].getRaceName();
                TextShape raceNameShape = new TextShape(0, 0, currentRace);

                raceNameShape.moveTo(barXPos + (spacingSize * spacingCounter),
                    barYPos);
                window.addShape(raceNameShape);
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the races alphabetically
     * 
     * @param num
     */
    private void updateRaceABC(int num) {
        window.removeAllShapes();

        if (!(num < 0)) {
            State currentState = covidCalculator.getLL().get(num); // state
            ArrayList<Race> currentRacesSorted = covidCalculator.sortByABC(
                currentState);

            for (int i = 0; i < currentRacesSorted.size(); i++) {
                String currentRace = currentRacesSorted.get(i).getRaceName();
                TextShape raceNameShape = new TextShape(0, 0, currentRace);

                raceNameShape.moveTo(barXPos + (spacingSize * spacingCounter),
                    barYPos);
                window.addShape(raceNameShape);
                spacingCounter++;
            }

        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the race in ascending order of CFR
     * 
     * @param num
     */
    private void updateRaceCFR(int num) {
        window.removeAllShapes();

        if (!(num < 0)) {
            State currentState = covidCalculator.getLL().get(num); // state
            ArrayList<Race> currentRacesSorted = covidCalculator.sortByCFR(
                currentState);

            for (int i = 0; i < currentRacesSorted.size(); i++) {
                String currentRace = currentRacesSorted.get(i).getRaceName();
                TextShape raceNameShape = new TextShape(0, 0, currentRace);

                raceNameShape.moveTo(barXPos + (spacingSize * spacingCounter),
                    barYPos);
                window.addShape(raceNameShape);
                spacingCounter++;
            }

        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the CFR
     * 
     * @param num
     */
    private void updateCFR(int num) {
        if (num < 0) {
            window.removeAllShapes();
        }
        else {
            State currentState = covidCalculator.getLL().get(num);
            Race[] currentRaces = currentState.getRaces();

            for (int i = 0; i < currentRaces.length; i++) {
                String cfrPercentage = String.valueOf(currentRaces[i].getCFR());

                if (!cfrPercentage.equals("-1%")) {
                    TextShape cfrName = new TextShape(0, 0, cfrPercentage);
                    cfrName.moveTo(barXPos + (spacingSize * spacingCounter),
                        +barYPos + 25);
                    window.addShape(cfrName);
                }
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the CFR alphabetical order
     * 
     * @param num
     */
    private void updateCFRABC(int num) {
        if (num < 0) {
            window.removeAllShapes();
        }
        else {
            State currentState = covidCalculator.getLL().get(num);
            ArrayList<Race> currentRacesSorted = covidCalculator.sortByABC(
                currentState);

            for (int i = 0; i < currentRacesSorted.size(); i++) {
                String cfrPercentage = String.valueOf(currentRacesSorted.get(i)
                    .getCFR());

                if (!cfrPercentage.equals("-1%")) {
                    TextShape cfrName = new TextShape(0, 0, cfrPercentage);
                    cfrName.moveTo(barXPos + (spacingSize * spacingCounter),
                        +barYPos + 25);
                    window.addShape(cfrName);
                }
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the CFR in ascending order
     * 
     * @param num
     */
    private void updateCFRCFR(int num) {
        if (num < 0) {
            window.removeAllShapes();
        }
        else {
            State currentState = covidCalculator.getLL().get(num);
            ArrayList<Race> currentRacesSorted = covidCalculator.sortByCFR(
                currentState);

            for (int i = 0; i < currentRacesSorted.size(); i++) {
                String cfrPercentage = String.valueOf(currentRacesSorted.get(i)
                    .getCFR());

                if (!cfrPercentage.equals("-1%")) {
                    TextShape cfrName = new TextShape(0, 0, cfrPercentage);
                    cfrName.moveTo(barXPos + (spacingSize * spacingCounter),
                        +barYPos + 25);
                    window.addShape(cfrName);
                }
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the bar.
     * 
     * @param num
     *            of the state
     */
    private void updateBar(int num) {
        if (num < 0) {
            window.removeAllShapes();
        }
        else {
            State currentState = covidCalculator.getLL().get(num);
            Race[] currentRaces = currentState.getRaces();

            for (int i = 0; i < currentRaces.length; i++) {
                double currentCFR = currentRaces[i].getCFR();
                if (currentCFR > 0) {
                    Shape cfrBar = new Shape(0, 0, 25, (int)(10 * currentCFR),
                        Color.RED);
                    cfrBar.moveTo(barXPos + (spacingSize * spacingCounter) + 5,
                        barYPos - cfrBar.getHeight());
                    window.addShape(cfrBar);
                }
                else {
                    TextShape name = new TextShape(0, 0, "NA");
                    name.moveTo(barXPos + (spacingSize * spacingCounter) + 5,
                        barYPos - 20);
                }
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the bar in ABC order
     * 
     * @param num
     */
    private void updateBarABC(int num) {
        if (num < 0) {
            window.removeAllShapes();
        }
        else {
            State currentState = covidCalculator.getLL().get(num);
            ArrayList<Race> currentRacesSorted = covidCalculator.sortByABC(
                currentState);

            for (int i = 0; i < currentRacesSorted.size(); i++) {
                double currentCFR = currentRacesSorted.get(i).getCFR();
                if (currentCFR > 0) {
                    Shape cfrBar = new Shape(0, 0, 25, (int)(10 * currentCFR),
                        Color.RED);
                    cfrBar.moveTo(barXPos + (spacingSize * spacingCounter) + 5,
                        barYPos - cfrBar.getHeight());
                    window.addShape(cfrBar);
                }
                else {
                    TextShape name = new TextShape(0, 0, "NA");
                    name.moveTo(barXPos + (spacingSize * spacingCounter) + 5,
                        barYPos - 20);
                }
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }


    /**
     * Updates the bar in order of CFR
     * 
     * @param num
     */
    private void updateBarCFR(int num) {
        if (num < 0) {
            window.removeAllShapes();
        }
        else {
            State currentState = covidCalculator.getLL().get(num);
            ArrayList<Race> currentRacesSorted = covidCalculator.sortByCFR(
                currentState);

            for (int i = 0; i < currentRacesSorted.size(); i++) {
                double currentCFR = currentRacesSorted.get(i).getCFR();
                if (currentCFR > 1) {
                    Shape cfrBar = new Shape(0, 0, 25, (int)(10 * currentCFR),
                        Color.RED);
                    cfrBar.moveTo(barXPos + (spacingSize * spacingCounter) + 5,
                        barYPos - cfrBar.getHeight());
                    window.addShape(cfrBar);
                }
                else {
                    TextShape name = new TextShape(0, 0, "NA");
                    name.moveTo(barXPos + (spacingSize * spacingCounter) + 5,
                        barYPos - 20);
                }
                spacingCounter++;
            }
        }
        lastStateMemory = num;
        spacingCounter = 1;
    }

}
