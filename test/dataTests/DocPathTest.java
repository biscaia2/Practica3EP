package dataTests;

import data.DocPath;

import exceptions.nonValidStringException;
import exceptions.nullStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocPathTest {
    DocPath nullDocPath;
    DocPath wrongDocPath;
    DocPath correctDocPath;

    @BeforeEach

    void setUp() {
        nullDocPath = new DocPath(null);
        wrongDocPath = new DocPath("hola");
        correctDocPath = new DocPath("012345");
    }

    @Test
    void checkNullDocPath() {
        Throwable exception = assertThrows(nullStringException.class, () -> {
            nullDocPath.getDocPath();
        });
    }

    @Test
    void checkWrongDocPath() {
        Throwable exception = assertThrows(nonValidStringException.class, () -> {
            wrongDocPath.getDocPath();
        });
    }

    @Test
    void wellCreatedDocPath() throws nullStringException, nonValidStringException {
        assertEquals(correctDocPath.getDocPath(), "012345");
    }
}