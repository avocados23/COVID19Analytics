package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Nam Tran (namht)

/**
 * The Race class
 * 
 * @author Nam Tran (namht)
 * @version 11.20.20
 *
 */
public class Race {

    private String raceName;
    private int caseNum;
    private int deathNum;

    /**
     * Default constructor for Race.
     * 
     * @param rn
     *            Race name
     * @param c
     *            Cases number
     * @param d
     *            Deaths number
     */
    public Race(String rn, int c, int d) {
        raceName = rn;
        caseNum = c;
        deathNum = d;
    }


    /**
     * Returns the race name.
     * 
     * @return raceName
     */
    public String getRaceName() {
        return raceName;
    }


    /**
     * Returns the number of cases that a particular race has.
     * 
     * @return caseNum
     */
    public int getCaseNum() {
        return caseNum;
    }


    /**
     * Returns the number of deaths that a particular race has.
     * 
     * @return deathNum
     */
    public int getDeathNum() {
        return deathNum;
    }


    /**
     * Changes the value of the caseNum variable.
     * 
     * @param num
     *            Number of cases to set it to.
     */
    public void setCaseNum(int num) {
        caseNum = num;
    }


    /**
     * Changes the value of the deathNum variable.
     * 
     * @param num
     *            Number of deaths to set it to.
     */
    public void setDeathNum(int num) {
        deathNum = num;
    }


    /**
     * Calculates the CFR.
     * 
     * @return CFR
     */
    public double CFR() {
        return round((deathNum / caseNum) * 100);
    }


    /**
     * Rounds CFR to one decimal place.
     * 
     * @param val
     *            Value to be passed
     * @return decimal version of val to one decimal place
     */
    private double round(double val) {
        int scale = (int)Math.pow(10, 1);
        return (double)Math.round(val * scale) / scale;
    }


    /**
     * toString() method to represent the race.
     * 
     * @return String representation of a race name, cases, and CFR ratio
     */
    public String toString() {
        return raceName + ": " + caseNum + " cases, " + CFR() + "% CFR";
    }


    /**
     * equals() method for a race
     * 
     * @return true if a race has the same name, same cases, and same death
     */
    public boolean equals(Object obj) {
        if (obj instanceof Race) {
            return raceName.equals(((Race)obj).getRaceName())
                && deathNum == ((Race)obj).getDeathNum()
                && caseNum == ((Race)obj).getCaseNum();
        }
        return false;
    }

}
