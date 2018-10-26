package p42583;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem;

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void 테스트1() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        assertThat(problem.solution(bridge_length, weight, truck_weights)).isEqualTo(8);
    }

    @Test
    public void 테스트2() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};
        assertThat(problem.solution(bridge_length, weight, truck_weights)).isEqualTo(101);
    }

    @Test
    public void 테스트3() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertThat(problem.solution(bridge_length, weight, truck_weights)).isEqualTo(110);
    }

    @Test
    public void 테스트4() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertThat(problem.solution(bridge_length, weight, truck_weights)).isEqualTo(110);
    }

    @Test
    public void 테스트5() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {9, 4, 8, 1, 5};
        assertThat(problem.solution(bridge_length, weight, truck_weights)).isEqualTo(9);
    }
}