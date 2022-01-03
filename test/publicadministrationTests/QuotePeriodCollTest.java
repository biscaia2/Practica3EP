package publicadministrationTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.QuotePeriod;
import publicadministration.QuotePeriodsColl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class QuotePeriodCollTest {
    QuotePeriodsColl qTpC;

    @BeforeEach
    void setUp() {
        qTpC = new QuotePeriodsColl();
    }

    @Test
    void sortedQuotePeriods() {
        qTpC.addQuotePeriod(new QuotePeriod(new Date(2015, Calendar.DECEMBER, 20), 10));
        qTpC.addQuotePeriod(new QuotePeriod(new Date(2012, Calendar.NOVEMBER, 15), 10));
        qTpC.addQuotePeriod(new QuotePeriod(new Date(2005, Calendar.AUGUST, 14), 10));
        qTpC.addQuotePeriod(new QuotePeriod(new Date(2007, Calendar.JUNE, 7), 10));
        qTpC.addQuotePeriod(new QuotePeriod(new Date(2021, Calendar.JANUARY, 2), 10));
        ArrayList<QuotePeriod> sortedList = qTpC.orderQuoteList(new ArrayList<QuotePeriod>());

        QuotePeriodsColl qTpC2 = new QuotePeriodsColl();
        qTpC2.addQuotePeriod(new QuotePeriod(new Date(2005, Calendar.AUGUST, 14), 10));
        qTpC2.addQuotePeriod(new QuotePeriod(new Date(2007, Calendar.JUNE, 7), 10));
        qTpC2.addQuotePeriod(new QuotePeriod(new Date(2012, Calendar.NOVEMBER, 15), 10));
        qTpC2.addQuotePeriod(new QuotePeriod(new Date(2015, Calendar.DECEMBER, 20), 10));
        qTpC2.addQuotePeriod(new QuotePeriod(new Date(2021, Calendar.JANUARY, 2), 10));
        ArrayList<QuotePeriod> wellSortedList = qTpC2.orderQuoteList(new ArrayList<QuotePeriod>());
        assertEquals(sortedList, wellSortedList);
    }
}
