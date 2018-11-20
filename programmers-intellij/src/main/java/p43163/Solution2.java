package p43163;

import java.util.Arrays;
import java.util.List;

class Solution2 {
    List<String> wordList;
    boolean[] visit;
    int answer;

    public int solution(String begin, String target, String[] words) {
        wordList = Arrays.asList(words);
        visit = new boolean[wordList.size()];
        answer = words.length + 1;

        dfs(new Word(begin, 0), target);
        if(answer == words.length + 1) return 0;
        return answer;
    }

     void dfs(Word word, String target) {
        for (int i = 0; i < word.val.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                StringBuilder sb = new StringBuilder(word.val);
                sb.setCharAt(i, j);
                String temp = sb.toString();
                if(temp.equals(word.val)) continue;
                if(temp.equals(target) && wordList.contains(temp)) {
                    answer = Math.min(answer, word.step + 1);
                }
                if (wordList.contains(temp) && !visit[wordList.indexOf(temp)]) {
                    visit[wordList.indexOf(temp)] = true;
                    dfs(new Word(temp, word.step + 1), target);
                    visit[wordList.indexOf(temp)] = false;
                }
            }
        }
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