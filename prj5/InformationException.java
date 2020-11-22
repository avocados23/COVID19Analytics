package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Nam Tran (namht)

/**
 * InformationException class.
 *
 * @author Nam Tran
 * @version 11.20.20
 */

@SuppressWarnings("serial")
public class InformationException extends Exception {

    /**
     * constructor for InformationException
     * 
     * @param message
     *            the string output
     */
    public InformationException(String message) {
        super(message);
    }
}
