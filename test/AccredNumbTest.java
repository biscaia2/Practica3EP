import data.AccredNumb;

import exceptions.nonValidNifException;
import exceptions.nullCodeException;
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
        Throwable exception = assertThrows(nullCodeException.class, () -> {
            nullAccNum.getAccredNumb();
        });
    }

    @Test
    void checkWrongAccNum() {
        Throwable exception = assertThrows(nonValidNifException.class, () -> {
            wrongAccNum.getAccredNumb();
        });
    }

    @Test
    void wellCreatedAccNum() throws nullCodeException, nonValidNifException {
        assertEquals(correctAccNum.getAccredNumb(), "012345");
    }
}