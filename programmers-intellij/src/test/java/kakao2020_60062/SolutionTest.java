package kakao2020_60062;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test1() {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        int result = Solution.solution(n, weak, dist);
        assertEquals(result, 2);
    }
}