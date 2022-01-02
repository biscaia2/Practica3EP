package publicadministration;

import java.util.ArrayList;
import java.util.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class QuotePeriodsColl { // Represents the total quote periods known as a registered worker
    // Its components, that is, the set of quote periods

    ArrayList<QuotePeriod> quoteList;

    public QuotePeriodsColl (){
        quoteList = new ArrayList<QuotePeriod>();
    } // Initializes the object

    public ArrayList<QuotePeriod> getQuoteList(){
        return quoteList;
    }
    // the getters

    public void addQuotePeriod (QuotePeriod qPd){
        quoteList.add(qPd);
        this.quoteList = orderQuoteList(quoteList);
    } // Adds a quote period, always respecting the sorting by date, from oldest to later in time

    private ArrayList<QuotePeriod> orderQuoteList(ArrayList<QuotePeriod> quoteList){
        quoteList.sort((d1,d2) -> d1.getDate().compareTo(d2.getDate()));
        return quoteList;
    }
    public String toString () {
        String result = "";
        for(int i = 0; i < quoteList.size() - 1; i++){
            result += "Data" + quoteList.get(i).getDate() + "\n";
        }
        return "QuoteperiodColl{" + result +'\'' + '}';
} // Converts to String
}

