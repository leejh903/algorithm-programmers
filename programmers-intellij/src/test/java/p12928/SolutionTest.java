package p12928;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void 일부터_N까지_수넣기() {
        int n = 10;
        List<Integer> test = IntStream.range(0, n).boxed().collect(Collectors.toList());

        for (Integer integer : test) {
            System.out.println(integer);
        }
    }

    @Test
    public void 숫자_중_약수() {
        int n = 12;
        int answer = IntStream.range(1, n + 1)
                .boxed()
                .filter(i -> n % i == 0)
                .mapToInt(Integer::intValue)
                .sum();

        assertThat(answer).isEqualTo(28);
    }

    @Test
    public void test() {
        assertThat(problem.solution(5)).isEqualTo(6);
    }
}