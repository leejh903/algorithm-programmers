package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTest {
    Test test = new Test();

    @org.junit.Test
    public void test() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        assertThat(test.check(lotto, 2, 3)).isEqualTo(true);
    }
}