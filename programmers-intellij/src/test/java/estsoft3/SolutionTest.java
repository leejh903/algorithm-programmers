package estsoft3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String[] B = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        assertThat(problem.solution(B)).isEqualTo(2);
    }

    @Test
    public void test2() {
        String[] B = {"X....", ".X...", "..O..", "...X.", "....."};
        assertThat(problem.solution(B)).isEqualTo(0);
    }

    @Test
    public void test3() {
        String[] B = {"..X...", "......", "....X.", ".X...X", "..X.X.", "...O.."};
        assertThat(problem.solution(B)).isEqualTo(0);
    }

    @Test
    public void test4() {
        String[] B = {"..X...", "......", "......", ".X....", "..X.X.", "...O.."};
        assertThat(problem.solution(B)).isEqualTo(1);
    }


    @Test
    public void findPawn() {
        String[] B = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        Point point = problem.findPawn(B);
        System.out.println(point);
    }

    @Test
    public void isOutofBoard() {
        String[] B = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        assertThat(problem.isOutofBoard(B, 6, 2)).isTrue();
    }

    @Test
    public void isOutofBoard2() {
        String[] B = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        assertThat(problem.isOutofBoard(B, 3, 2)).isFalse();
    }

    @Test
    public void getChar() {
        String[] B = {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."};
        assertThat(problem.getChar(B, 0, 2)).isEqualTo('X');
    }
}