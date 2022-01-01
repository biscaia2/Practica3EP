import data.Nif;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NifTest {
    Nif nullNif;
    Nif wrongNif;
    Nif correctNif;

    @BeforeEach
    void setUp() {
        nullNif = new Nif(null);
        wrongNif = new Nif("hola");
        correctNif = new Nif("012345");
    }

    @Test
    void checkNullNif() {
        Throwable exception = assertThrows(nullCodeException.class, () -> {nullNif.getNif();});
    }

    @Test
    void checkWrongNif() {
        Throwable exception = assertThrows(nonValidNifException.class, () -> {wrongNif.getNif();});
    }

    @Test
    void wellCreatedNif() throws nullCodeException, nonValidNifException {
        assertEquals(correctNif.getNif(), "012345");
    }
}
