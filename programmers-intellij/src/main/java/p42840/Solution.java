package p42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<int[]> student;
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        student = new ArrayList<>(Arrays.asList(student1, student2, student3));
        int[] index = new int[student.size()];
        int[] score = new int[student.size()];

        for (int j = 0; j < student.size(); j++) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == student.get(j)[index[j]]) {
                    score[j]++;
                }
                index[j]++;
                if (index[j] == student.get(j).length) {
                    index[j] = 0;  // 인덱스 초기화
                }
            }
        }

        int[] answer = printHighestIndex(score);
        return answer;
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

        int[] answer = highestIndex.stream().mapToInt(i -> i.intValue()).toArray();
        Arrays.sort(answer);
        return answer;
    }
}