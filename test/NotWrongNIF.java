import data.Nif;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotWrongNIF {
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
        Throwable exception = assertThrows(Nif.nullCodeException.class, () -> {nullNif.getNif();});
    }

    @Test
    void checkWrongNif() {
        Throwable exception = assertThrows(Nif.nonValidNifException.class, () -> {wrongNif.getNif();});
    }

    @Test
    void wellCreatedNif() throws Nif.nullCodeException, Nif.nonValidNifException {
        assertEquals(correctNif.getNif(), "012345");
    }
}
