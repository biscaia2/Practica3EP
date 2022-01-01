import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.QuotePeriod;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Calendar;
import java.util.Date;

public class QuotePeriodTest {
    QuotePeriod qTpNULL;
    QuotePeriod qTp;

    @BeforeEach
    void setUp() {
        qTpNULL = null;
        qTp = new QuotePeriod(new Date(2021, Calendar.DECEMBER, 31), 5);
    }

    @Test
    void nullParametersTest() {
        assertNull(qTpNULL);
    }

    @Test
    void wellCreatedQuote() {
        assertNotNull(qTp);
        assertEquals(qTp.getDate(), new Date(2021, Calendar.DECEMBER, 31));
        assertEquals(qTp.getNumDays(), 5);
    }
}
