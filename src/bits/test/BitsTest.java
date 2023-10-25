package bits.test;

import bits.Bits;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BitsTest {
    @Test
    public void testFindTwoNumbersFromArray() {
        var arr = new int[]{
                1, 1, 1, 1, 2, 3, 1, 1, 1, 1
        };
        System.out.println(Arrays.toString(Bits.findTwoNumbersFromArray(arr)));
    }
}
