package publicadministrationTests;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.QuotePeriod;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuotePeriodTest {
    QuotePeriod nullPeriod;
    QuotePeriod correctPeriod;
    QuotePeriod wrongPeriod;

    @BeforeEach
    void setUp() {
        Date date = new Date(2003, Calendar.DECEMBER, 12);
        nullPeriod = new QuotePeriod(null, 0);
        correctPeriod = new QuotePeriod(date, 81);
        wrongPeriod = new QuotePeriod(new Date(2024, Calendar.JANUARY, 21),0);
    }

    @Test
    void checkNullQuotePeriod() {
        Throwable exception = assertThrows(nullCodeException.class, () -> {nullPeriod.getDate();});
    }

    @Test
    void checkWrongQuotePeriod() {
        Throwable exception = assertThrows(nonValidNifException.class, () -> {wrongPeriod.getDate();});
    }

    @Test
    void wellCreatedQuotePeriod() throws nullCodeException, nonValidNifException {
        assertEquals(correctPeriod.getDate(), new Date(2003, Calendar.DECEMBER, 12));
    }
}

