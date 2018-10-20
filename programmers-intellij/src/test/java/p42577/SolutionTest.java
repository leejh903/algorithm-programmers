package p42577;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem;

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void soluetion() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(problem.solution(phone_book));
    }
}