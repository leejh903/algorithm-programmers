package p42840;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem;
    List<int[]> student;
    int[] student1 = {1, 2, 3, 4, 5};
    int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void 학생1_끝나고_돌아가기() {
        int num = 12;
        int index = 0;

        for (int i = 0; i < num; i++) {
            System.out.print(student1[index] + " ");
            index++;
            if (index == student1.length) {
                index = 0;  // 인덱스 초기화
            }
        }
    }

    @Test
    public void 학생1_성적_처리하기() {
        int index = 0;
        int[] answer = {1, 2, 3, 4, 5};
        int score = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == student1[index]) {
                score++;
            }
            index++;
            if (index == student1.length) {
                index = 0;  // 인덱스 초기화
            }
        }
        assertThat(score).isEqualTo(5);
    }

    @Test
    public void 학생2_성적_처리하기() {
        int index = 0;
        int[] answer = {1, 2, 3, 4, 5};
        int score = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == student2[index]) {
                score++;
            }
            index++;
            if (index == student2.length) {
                index = 0;  // 인덱스 초기화
            }
        }
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void 학생3_성적_처리하기() {
        int index = 0;
        int[] answer = {1, 2, 3, 4, 5};
        int score = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == student3[index]) {
                score++;
            }
            index++;
            if (index == student3.length) {
                index = 0;  // 인덱스 초기화
            }
        }
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void 한번에_처리하기() {
        student = new ArrayList<>(Arrays.asList(student1, student2, student3));
        int[] index = new int[student.size()];
        int[] score = new int[student.size()];
        int[] answer = {1, 2, 3, 4, 5};

        for (int j = 0; j < student.size(); j++) {
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == student.get(j)[index[j]]) {
                    score[j]++;
                }
                index[j]++;
                if (index[j] == student.get(j).length) {
                    index[j] = 0;  // 인덱스 초기화
                }
            }
        }
        assertThat(score[0]).isEqualTo(5);
        assertThat(score[1]).isEqualTo(0);
        assertThat(score[2]).isEqualTo(0);
    }

    @Test
    public void score_같을경우_출력() {
        int[] score = {2, 4, 7, 2};
        assertThat(printHighestIndex(score)).isEqualTo(new int[]{3});
    }

    @Test
    public void score_같을경우_출력2() {
        int[] score = {2, 4, 4, 7, 7, 7, 2, 7};
        assertThat(printHighestIndex(score)).isEqualTo(new int[]{4, 5, 6, 8});
    }

    public int[] printHighestIndex(int[] score) {
        int high = 0;
        List<Integer> highestIndex = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] > high) {
                high = score[i];
                highestIndex.clear();
                highestIndex.add(i + 1);
            } else if (score[i] == high) {
                highestIndex.add(i + 1);
            }
        }

        int[] answer = highestIndex.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer;
    }

    @Test
    public void 구현체크() {
        int[] answers = {1,3,2,4,2};
        assertThat(problem.solution(answers)).isEqualTo(new int[]{1,2,3});
    }
}