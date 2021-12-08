package probekurzarbeit;

import java.util.Date;

public class PruefeException extends Exception {

    private final Date time;

    {
        time = new Date();
    }
    
    public PruefeException() {
    }

    public PruefeException(String string) {
        super(string);
    }

    public PruefeException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PruefeException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PruefeException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

    public Date getTime() {
        return time;
    }
    
}
