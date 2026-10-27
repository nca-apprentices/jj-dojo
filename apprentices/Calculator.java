import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}

class CalculatorTest {
    @Test
    void addsTwoNumbers() {
        assertEquals(5, Calculator.add(2, 3));
        assertEquals(0, Calculator.add(-1, 1));
    }
}
