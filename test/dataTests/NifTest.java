package dataTests;

import data.Nif;

import exceptions.nonValidStringException;
import exceptions.nullStringException;
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
        Throwable exception = assertThrows(nullStringException.class, () -> {nullNif.getNif();});
    }

    @Test
    void checkWrongNif() {
        Throwable exception = assertThrows(nonValidStringException.class, () -> {wrongNif.getNif();});
    }

    @Test
    void wellCreatedNif() throws nullStringException, nonValidStringException {
        assertEquals(correctNif.getNif(), "012345");
    }
}
