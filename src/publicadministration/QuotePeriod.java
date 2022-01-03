package publicadministration;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;

import java.util.Calendar;
import java.util.Date;

public class QuotePeriod { // Represents a quote period as a registered worker
    private final Date initDay;
    private final int numDays;

    public QuotePeriod (Date date, int ndays){
        this.initDay = date;
        this.numDays = ndays;
    }

    //getters
    public Date getDate() throws nullCodeException, nonValidNifException {
        if (initDay == null) {
            throw new nullCodeException("null date");
        }
        if (initDay.before(new Date(1950, Calendar.JANUARY, 1)) || initDay.after(new Date(2021, Calendar.DECEMBER, 31))) {
            throw new nonValidNifException("invalid date");
        }
        return initDay;
    }
    public int getNumDays() { return numDays;}

    public String toString () {return "Quoteperiod{" + "Data=" + this.initDay +  "Numero de dies= " + this.numDays +'\'' + '}';} // converts to String

    public boolean compareTo(Date d2) {
        return (this.initDay.after(d2));
    }
}

