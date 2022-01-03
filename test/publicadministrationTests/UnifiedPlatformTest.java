package publicadministrationTests;

import exceptions.AnyKeyWordProcedureException;
import exceptions.nullCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.UnifiedPlatform;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnifiedPlatformTest {
    String correctProcedure;
    String incorrectProcedure;
    Byte opc0;
    Byte opc3;
    String correctAAPP;
    String incorrectAAPP;
    UnifiedPlatform unifiedPlatform;

    @BeforeEach
    void setUp() {
        unifiedPlatform = new UnifiedPlatform();
        correctAAPP = "Seguretat Social";
        incorrectAAPP = "Artur Culleres";
        opc0 = 0;
        opc3 = 3;
        correctProcedure = "Informe de vida laboral";
        incorrectProcedure = "Afiliacio";
    }

    @Test
    void correctProcedureKeyWordTest() {
        Throwable exception = assertThrows(AnyKeyWordProcedureException.class, () -> {unifiedPlatform.enterKeyWords(incorrectProcedure);});
    }
}
