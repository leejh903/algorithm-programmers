package lotto;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 일등() {
        int rank = LottoGame.match("1,2,3,4,5,6", "1,2,3,4,5,6", "7");
        assertThat(rank).isEqualTo(1);
    }
}