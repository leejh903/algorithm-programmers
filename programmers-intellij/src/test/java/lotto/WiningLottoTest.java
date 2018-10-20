package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WiningLottoTest {

    @Test (expected = IllegalArgumentException.class)
    public void boNoCheck() {
        List<Integer> test = Arrays.asList(1,2,3,4,5,6);
        int boNo = 6;

        WiningLotto.init(test, boNo);
    }

    @Test
    public void 등수() {
        List<Integer> test1 = Arrays.asList(1,2,3,4,5,7);
        int bonusNum = 7;

        List<Integer> test2 = Arrays.asList(1,2,3,4,5,6);

        List<Integer> test3 = Arrays.asList(1,2,3,4,7,8);

        Lotto lotto = Lotto.init(test3);
        WiningLotto winingLotto = WiningLotto.init(test2, bonusNum);

        assertThat(winingLotto.isJackpot(lotto)).isEqualTo(4);

    }

}