package p43163;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void 단어를_어떻게_바꿀까() {
        String test = "a";
        String newTest = test.replace(test.charAt(0), 'b');
        System.out.println(newTest);
    }

    @Test
    public void 언제_탐색_그만둘까() {  // 더이상 방문할 게 없을 때
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        List<String> wordList = Arrays.asList(words);
        boolean[] visit = new boolean[wordList.size()];
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            for (int i = 0; i < word.val.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String temp = word.val.replace(word.val.charAt(i), j);
                    if(temp.equals(target)) System.out.println(word.step + 1);  // return으로 바꿔야
                    if (wordList.contains(temp) && !visit[wordList.indexOf(temp)]) {
                        queue.offer(new Word(temp, word.step + 1));
                        visit[wordList.indexOf(temp)] = true;
                    }
                }
            }
        }

        System.out.println("최종");
        System.out.println(0);
    }

    @Test
    public void test1() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        assertThat(problem.solution(begin, target, words)).isEqualTo(4);
    }

    @Test
    public void test2() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        assertThat(problem.solution(begin, target, words)).isEqualTo(0);
    }

    @Test
    public void test3() {
        String begin = "hit";
        String target = "zid";
        String[] words = {"hot", "dot", "did", "iit"};

        assertThat(problem.solution(begin, target, words)).isEqualTo(0);
    }
}

class Word {
    String val;
    int step;

    public Word(String val, int step) {
        this.val = val;
        this.step = step;
    }
}