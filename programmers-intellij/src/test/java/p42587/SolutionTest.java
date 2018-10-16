package p42587;

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
    public void solution() {
        int[] priorities = {2, 1, 3, 2};
//        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
//        int location = 0;
        assertThat(1).isEqualTo(problem.solution(priorities, location));

    }

}