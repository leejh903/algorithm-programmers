package kakaopay_4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int K = 3;
        String[] user_scores = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        assertThat(problem.solution(K, user_scores)).isEqualTo(4);
    }

    @Test
    public void test2() {
        int K = 3;
        String[] user_scores = {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
        assertThat(problem.solution(K, user_scores)).isEqualTo(3);
    }

    @Test
    public void test3() {
        int K = 2;
        String[] user_scores = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};
        assertThat(problem.solution(K, user_scores)).isEqualTo(3);
    }

    @Test
    public void init() {
        int K = 3;
        String[] user_scores = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        problem.init(user_scores);
    }

//    @Test
//    public void hasChange() {
//        List<Score> list = new ArrayList<>();
//        list.add(new Score("alex111", 100));
//        list.add(new Score("cheries2", 200));
//        list.add(new Score("coco", 150));
//        Collections.sort(list);
//        Score score = new Score("alex111", 160);
//        int K = 3;
//        assertThat(problem.hasChange(list, score, K)).isTrue();
//    }

    @Test
    public void ExistingUserCheck() {
        List<Score> list = new ArrayList<>();
        list.add(new Score("alex111", 100));
        list.add(new Score("cheries2", 200));
        list.add(new Score("coco", 150));
        Collections.sort(list);
        Score score = new Score("alex111", 160);
        problem.ExistingUserCheck(list, score);

        for (Score score1 : list) {
            System.out.println(score1);
        }
    }

    @Test
    public void ExistingUserCheck2() {
        List<Score> list = new ArrayList<>();
        list.add(new Score("alex111", 100));
        list.add(new Score("cheries2", 200));
        list.add(new Score("coco", 150));
        Collections.sort(list);
        Score score = new Score("addddlex111", 160);
        problem.ExistingUserCheck(list, score);

        for (Score score1 : list) {
            System.out.println(score1);
        }
    }
}