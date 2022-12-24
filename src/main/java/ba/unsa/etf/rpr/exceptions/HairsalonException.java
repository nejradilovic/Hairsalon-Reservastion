package ba.unsa.etf.rpr.exceptions;

public class HairsalonException extends Exception{

    public HairsalonException(String msg, Exception reason){
        super(msg, reason);
    }

    public HairsalonException(String msg){
        super(msg);
    }
}
