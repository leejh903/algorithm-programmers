package permutation;

import org.junit.Test;

import java.util.Arrays;


public class t20181019Test {
    t20181019 test = new t20181019();
    int[] arr = {1, 2, 3, 4, 5, 6};

    @Test
    public void test() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 3)));
    }

    @Test
    public void test2() {
        test.permutation(arr, 0, 4, 3);
    }
}