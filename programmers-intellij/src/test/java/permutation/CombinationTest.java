package permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationTest {
    Combination combination = new Combination();

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;
        int[] data = new int[r];
        int n = arr.length;
        combination.combination(arr, data, 0, n, 0, r);
    }
}