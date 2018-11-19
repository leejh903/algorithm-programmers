package p43163;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.asList(words);
        boolean[] visit = new boolean[wordList.size()];
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));

        // 방문체크가 각각의 경우 따로 되어야 하는데 다른 경우의 수까지 체크되는 것 같은데

        if(!wordList.contains(target)) return 0;
        while (!queue.isEmpty()) {
            Word word = queue.poll();
            for (int i = 0; i < word.val.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String temp = word.val.replace(word.val.charAt(i), j);
                    if (temp.equals(target) && wordList.contains(temp)) return word.step + 1;
                    if (wordList.contains(temp) && !visit[wordList.indexOf(temp)]) {
                        queue.offer(new Word(temp, word.step + 1));
                        visit[wordList.indexOf(temp)] = true;
                    }
                }
            }
        }

        return 0;  // 이게 실행될 수 있을때는 언제일까?
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