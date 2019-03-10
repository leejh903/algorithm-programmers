package kakaogroundx_3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StockBuySellTest {
    StockBuySell problem = new StockBuySell();

    @Test
    public void test() {
        int[] gold_prices = {2, 5, 1, 3, 4};
        assertThat(problem.stockBuySell(gold_prices)).isEqualTo(4);
    }

    @Test
    public void test2() {
        int[] gold_prices = {7, 2, 5, 6, 1, 4, 2, 8, 7, 1, 7, 10};
        assertThat(problem.stockBuySell(gold_prices)).isEqualTo(19);
    }
}