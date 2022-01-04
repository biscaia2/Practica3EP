package publicadministrationTests;

import data.Nif;
import exceptions.AnyKeyWordProcedureException;
import exceptions.IncorrectValDateException;
import exceptions.NifNotRegisteredException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.UnifiedPlatform;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UnifiedPlatformTest {
    String correctProcedure;
    String incorrectProcedure;
    Byte opc0;
    Byte opc3;
    String correctAAPP;
    String incorrectAAPP;
    UnifiedPlatform unifiedPlatform;
    Nif validNif;
    Nif invalidNif;
    Date validDate;
    Date invalidDate;

    @BeforeEach
    void setUp() {
        unifiedPlatform = new UnifiedPlatform();
        correctAAPP = "Seguretat Social";
        incorrectAAPP = "Artur Culleres";
        opc0 = 0;
        opc3 = 3;
        correctProcedure = "Informe de vida laboral";
        incorrectProcedure = "Afiliacio";
        validNif = new Nif("1234567");
        invalidNif = new Nif("alksfslkagfhj");
        validDate = new Date(2021, Calendar.JANUARY, 2);
        invalidDate = new Date(2048, Calendar.JANUARY, 27);
    }

    @Test
    void enterKeyWordsTest() {
        Throwable exception = assertThrows(AnyKeyWordProcedureException.class, () -> {unifiedPlatform.enterKeyWords(incorrectProcedure);});
    }

    @Test
    void invalidNifEnterNIFPINobt() {
        Throwable exception = assertThrows(NifNotRegisteredException.class, () -> {unifiedPlatform.enterNIFPINobt(invalidNif, validDate);});
    }

    @Test
    void incorrectDateEnterNIFPINobt() {
        Throwable exception = assertThrows(IncorrectValDateException.class, () -> {unifiedPlatform.enterNIFPINobt(validNif, invalidDate);});

    }
}
