import data.Nif;
import data.PINcode;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;
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
        Throwable exception = assertThrows(nullCodeException.class, () -> {
            nullPIN.getPINcode();
        });
    }

    @Test
    void checkWrongPINCode() {
        Throwable exception = assertThrows(nonValidNifException.class, () -> {
            wrongPIN.getPINcode();
        });
    }

    @Test
    void wellCreatedPINCode() throws nullCodeException, nonValidNifException {
        assertEquals(correctPIN.getPINcode(), "012345");
    }
}