package dataTests;

import data.AccredNumb;

import exceptions.nonValidStringException;
import exceptions.nullStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccredNumbTest {
    AccredNumb nullAccNum;
    AccredNumb wrongAccNum;
    AccredNumb correctAccNum;

    @BeforeEach

    void setUp() {
        nullAccNum = new AccredNumb(null);
        wrongAccNum = new AccredNumb("hola");
        correctAccNum = new AccredNumb("012345");
    }

    @Test
    void checkNullAccNum() {
        Throwable exception = assertThrows(nullStringException.class, () -> {
            nullAccNum.getAccredNumb();
        });
    }

    @Test
    void checkWrongAccNum() {
        Throwable exception = assertThrows(nonValidStringException.class, () -> {
            wrongAccNum.getAccredNumb();
        });
    }

    @Test
    void wellCreatedAccNum() throws nullStringException, nonValidStringException {
        assertEquals(correctAccNum.getAccredNumb(), "012345");
    }
}