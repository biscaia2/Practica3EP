import data.DocPath;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;
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
        Throwable exception = assertThrows(nullCodeException.class, () -> {
            nullDocPath.getDocPath();
        });
    }

    @Test
    void checkWrongDocPath() {
        Throwable exception = assertThrows(nonValidNifException.class, () -> {
            wrongDocPath.getDocPath();
        });
    }

    @Test
    void wellCreatedDocPath() throws nullCodeException, nonValidNifException {
        assertEquals(correctDocPath.getDocPath(), "012345");
    }
}