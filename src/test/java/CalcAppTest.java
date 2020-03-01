import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcAppTest {

    private CalcApp calcApp;

    @BeforeEach
    void setUp(){
        calcApp = new CalcApp();
    }

    //@Test
    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 1, 8, 10, 100})
    void addValues(double expected) {
        //double expected = 8;
        double actual = calcApp.addValues(3,5);
        assertEquals(expected,actual);
        //assertNotNull(actual);
    }

    @Test
    void addValuesToZero() {
        double expected = 10;
        // test (0, 10)
        double actual = calcApp.addValues(-1,11);
        assertEquals(expected, actual, "Pierwszy składnik = 0");
    }

    @Test
    void ilLessThanTen(){
        assertTrue(calcApp.isLessThanTen(7));
    }

    // Zadanie z prezentacji:
    //@Test
    @ParameterizedTest
    @CsvSource(value = {
            "11:12:-1",
            "33:12:21",
            "100:-100:0"
            }, delimiter = ':')
    void subtValues(double val1, double val2, double expected){
        assertEquals(expected, calcApp.subtValues(val1,val2));
    }

    @Test
    void subtValuesIsNotNull(){
        assertNotNull(calcApp.subtValues(0,0));
    }

    @Test
    void subtValuesNotThrows(){
        assertDoesNotThrow(() -> calcApp.subtValues(1.0, -1.0));
    }

    @Test
    void subtValuesGreaterThanZero(){
        assertTrue(
                calcApp.subtValues(50,49) > 0,
                "Subrtaction result is less than or eq 0");
    }
}