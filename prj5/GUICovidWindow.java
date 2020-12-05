// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Jonathan Awad (jonathana) Omar Siddiqi (omarsiddiqi)
package prj5;

import cs2.Window;
import java.awt.Color;
import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.TextShape;
import cs2.WindowSide;
import list.AList;

/**
 * Display window
 * 
 * @author Jonathan Awad (jonathana), Omar Siddiqi (omarsiddiqi)
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
    private TextShape black;
    private TextShape white;
    private TextShape asian;
    private TextShape latinx;
    private TextShape other;
	private CovidReader reader;


    /**
     * Constructor for GUICovidWindow
     * 
     * @param covid
     *            passes CovidCalculator as a parameter
     *
     */
    public GUICovidWindow(CovidCalculator covid) {

        window = new Window();
        covidCalculator = covid;

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
        this.textShape = new TextShape(250, 25, "");
        window.addShape(textShape);

        this.asian = new TextShape(90, 225, "asian");
        window.addShape(asian);

        this.black = new TextShape(215, 225, "black");
        window.addShape(black);

        this.latinx = new TextShape(340, 225, "latinx");
        window.addShape(latinx);
        
        this.white = new TextShape(465, 225, "white");
        window.addShape(white);
        
        this.other = new TextShape(590, 225, "other");
        window.addShape(other);


        Shape[] bars = new Shape[5];

        bars[0] = new Shape(100, 100, 17, 120, Color.RED);
        bars[1] = new Shape(225, 100, 17, 120, Color.BLUE);
        bars[2] = new Shape(350, 100, 17, 120, Color.YELLOW);
        bars[3] = new Shape(475, 100, 17, 120, Color.GREEN);
        bars[4] = new Shape(600, 100, 17, 120, Color.BLACK);

        for (int i = 0; i < 5; i++) {
            window.addShape(bars[i]);
        }

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

    }


    /**
     * sets the appropriate title and displays the graph of the values for GA
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepGA(Button button) {
        textShape.setText("GA Case Fatality Ratios by Race");
    }


    /**
     * sets the appropriate title and displays the graph of the values for MD
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepMD(Button button) {
        textShape.setText("MD Case Fatality Ratios by Race");

    }


    /**
     * sets the appropriate title and displays the graph of the values for NC
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepNC(Button button) {
        textShape.setText("NC Case Fatality Ratios by Race");


    }


    /**
     * sets the appropriate title and displays the graph of the values for TN
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepTN(Button button) {
        textShape.setText("TN Case Fatality Ratios by Race");

    }


    /**
     * sets the appropriate title and displays the graph of the values for VA
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedRepVA(Button button) {
        textShape.setText("VA Case Fatality Ratios by Race");

    }


    /**
     * Displays the values sorted in alphabetical order when Sort by Alpha is
     * clicked
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedSortAlphaButton(Button button) {

    }


    /**
     * Displays the CFR values sorted from greatest to least when Sort by CFR is
     * clicked
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedSortCFRButton(Button button) {

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
}
