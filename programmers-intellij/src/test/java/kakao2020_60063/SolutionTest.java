package kakao2020_60063;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void setEquals() {
        Solution.Coordinate coordinate1 = new Solution.Coordinate(1, 2);
        Solution.Coordinate coordinate2 = new Solution.Coordinate(2, 2);
        List<Solution.Coordinate> set1 = new ArrayList<>();
        set1.add(coordinate1);
        set1.add(coordinate2);
        Solution.Robot robot1 = new Solution.Robot(set1, 0);

        Solution.Coordinate coordinate3 = new Solution.Coordinate(1, 2);
        Solution.Coordinate coordinate4 = new Solution.Coordinate(2, 2);
        List<Solution.Coordinate> set2 = new ArrayList<>();
        set2.add(coordinate3);
        set2.add(coordinate4);
        Solution.Robot robot2 = new Solution.Robot(set2, 0);

        Set<Solution.Robot> robots = new HashSet<>();
        robots.add(robot1);
        robots.add(robot2);

        assertEquals(set1, set2);
        assertEquals(robot1, robot2);
        assertEquals(1, robots.size());
    }

    @Test
    public void name() {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        assertEquals(7, solution.solution(board));
    }
}