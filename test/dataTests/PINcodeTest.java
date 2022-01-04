package dataTests;

import data.PINcode;

import exceptions.nonValidStringException;
import exceptions.nullStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PINcodeTest {
    PINcode nullPIN;
    PINcode wrongPIN;
    PINcode correctPIN;

    @BeforeEach
    void setUp() {
        nullPIN = new PINcode(null);
        wrongPIN = new PINcode("hola");
        correctPIN = new PINcode("012345");
    }

    @Test
    void checkNullPINCode() {
        Throwable exception = assertThrows(nullStringException.class, () -> {
            nullPIN.getPINcode();
        });
    }

    @Test
    void checkWrongPINCode() {
        Throwable exception = assertThrows(nonValidStringException.class, () -> {
            wrongPIN.getPINcode();
        });
    }

    @Test
    void wellCreatedPINCode() throws nullStringException, nonValidStringException {
        assertEquals(correctPIN.getPINcode(), "012345");
    }
}