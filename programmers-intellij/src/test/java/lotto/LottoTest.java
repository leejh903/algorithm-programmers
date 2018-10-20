package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test (expected = IllegalArgumentException.class)
    public void checkNums() {
        List<Integer> test = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            test.add(i);
        }
        test.add(5);

        assertThat(Lotto.checkNum(test)).isEqualTo(test);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overTest() {
        Lotto.init(Arrays.asList(0,1,2,3,4,5));

    }

    @Test(expected = IllegalArgumentException.class)
    public void notSix(){
        Lotto.init(Arrays.asList(1,2,3,4,5,6,7));
    }
}