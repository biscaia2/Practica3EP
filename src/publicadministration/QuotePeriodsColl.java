package publicadministration;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;

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

    public ArrayList<QuotePeriod> orderQuoteList(ArrayList<QuotePeriod> quoteList){
        quoteList.sort((d1,d2) -> {
            try {
                return d1.getDate().compareTo(d2.getDate());
            } catch (nullCodeException | nonValidNifException e) {
                e.printStackTrace();
            }
            return 0;
        });
        return quoteList;
    }
    public String toString () {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < quoteList.size() - 1; i++){
            try {
                result.append("Data").append(quoteList.get(i).getDate()).append("\n");
            } catch (nullCodeException | nonValidNifException e) {
                e.printStackTrace();
            }
        }
        return "QuoteperiodColl{" + result +'\'' + '}';
} // Converts to String
}

