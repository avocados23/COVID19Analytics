package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Nam Tran (namht)

/**
 * State class.
 * 
 * @author Nam Tran (namht)
 * @version 11.20.20
 */

public class State {

    private String stateName;
    private int totalCases;
    private int deaths;
    private Race[] races;

    /**
     * Constructor for a State.
     * 
     * @param sn
     *            State name
     * @param r
     *            Races stored in an array within the State
     */
    public State(String sn, Race[] r) {
        stateName = sn;
        totalCases = 0;
        deaths = 0;
        races = r;
    }


    /**
     * Gets the state name.
     * 
     * @return stateName
     */
    public String getStateName() {
        return stateName;
    }


    /**
     * Gets the races within the State.
     * 
     * @return races
     */
    public Race[] getRaces() {
        return races;
    }


    /**
     * Gets the total number of cases of COVID-19.
     * 
     * @return totalCases
     */
    public int getTotalCases() {
        for (int i = 0; i < races.length; i++) {
            totalCases += races[i].getCaseNum();
        }
        return totalCases;
    }


    /**
     * Gets the total deaths from COVID-19.
     * 
     * @return deaths
     */
    public int getDeaths() {
        for (int j = 0; j < races.length; j++) {
            deaths += races[j].getDeathNum();
        }
        return deaths;
    }

}
