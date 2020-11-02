package p49993;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    p49993.Solution problem = new Solution();

    @Test
    public void example1() {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        assertThat(problem.solution(skill, skillTrees)).isEqualTo(2);
    }
}