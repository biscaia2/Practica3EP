package publicadministration;

import java.util.Date;

public class QuotePeriod { // Represents a quote period as a registered worker
    private final Date initDay;
    private final int numDays;

    public QuotePeriod (Date date, int ndays){
        this.initDay = date;
        this.numDays = ndays;
    }

    //getters
    public Date getDate() { return initDay;}
    public int getNumDays() { return numDays;}

    public String toString () {return "Quoteperiod{" + "Data=" + this.initDay +  "Numero de dies= " + this.numDays +'\'' + '}';} // converts to String
}

