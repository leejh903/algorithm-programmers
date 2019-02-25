package p42890;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        assertThat(problem.solution(relation)).isEqualTo(2);
    }

    @Test
    public void 조합_인덱스() {
        problem.init(4);
        for (String index : problem.combinations) {
            System.out.println(index);
        }
    }
}