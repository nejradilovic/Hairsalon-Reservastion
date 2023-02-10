package ba.unsa.etf.rpr.exceptions;
/**
 * HairsalonException is a custom exception class for handling errors related to the projects operations.
 * It extends the base Exception class and provides two constructors for creating instances of the exception.
 * @author Nejra Adilovic
 */
public class HairsalonException extends Exception{

    public HairsalonException(String msg, Exception reason){
        super(msg, reason);
    }

    public HairsalonException(String msg){
        super(msg);
    }
}
