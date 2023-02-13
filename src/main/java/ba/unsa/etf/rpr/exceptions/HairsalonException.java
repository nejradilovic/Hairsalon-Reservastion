package ba.unsa.etf.rpr.exceptions;
/**
 * HairsalonException is a custom exception class for handling errors related to the projects operations.
 * It extends the base Exception class and provides two constructors for creating instances of the exception.
 * @author Nejra Adilovic
 */
public class HairsalonException extends Exception{
    /**
     * Two-parameter constructor
     * @param msg String
     * @param reason Exception
     */
    public HairsalonException(String msg, Exception reason){
        super(msg, reason);
    }
    /**
     * One-parameter constructor
     * @param msg String
     */
    public HairsalonException(String msg){
        super(msg);
    }
}
