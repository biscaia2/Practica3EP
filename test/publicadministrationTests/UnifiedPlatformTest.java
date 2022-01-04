package publicadministrationTests;

import data.Nif;
import data.PINcode;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.UnifiedPlatform;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UnifiedPlatformTest {
    String correctProcedure;
    String incorrectProcedure;

    String correctAAPP;
    String incorrectAAPP;

    UnifiedPlatform unifiedPlatform;

    Nif validNif;
    Nif invalidNif;
    Nif noRegisteredMobileNif;

    Date validDate;
    Date invalidDate;

    PINcode invalidPIN;

    @BeforeEach
    void setUp() {
        unifiedPlatform = new UnifiedPlatform();

        incorrectAAPP = "Ministerio de Hacienda";

        incorrectProcedure = "Afiliacio";

        validNif = new Nif("1234567");
        invalidNif = new Nif("alksfslkagfhj");
        noRegisteredMobileNif = new Nif("0000000");

        validDate = new Date(2021, Calendar.JANUARY, 2);
        invalidDate = new Date(2048, Calendar.JANUARY, 27);

        invalidPIN = new PINcode("0000000");
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

    @Test
    void mobileNotRegisteredEnterNIFPINobt() {
        Throwable exception = assertThrows(AnyMobileRegisteredException.class, () -> {unifiedPlatform.enterNIFPINobt(noRegisteredMobileNif, validDate);});
    }

    @Test
    void invalidPINenterPINtest() {
        Throwable exception = assertThrows(NotValidPINException.class, () -> {unifiedPlatform.enterPIN(invalidPIN);});
    }
}
