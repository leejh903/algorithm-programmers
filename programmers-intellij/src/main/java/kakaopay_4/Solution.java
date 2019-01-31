package kakaopay_4;

import java.util.*;

public class Solution {
    public int solution(int K, String[] user_scores) {
        Queue<Score> queue = init(user_scores);
        List<Score> list = new ArrayList();
        int answer = 0;

        while(!queue.isEmpty()) {
            Score score = queue.poll();
            if(hasChange(list, score, K)) {
                answer++;
            }
            Collections.sort(list);
            reorganizing(K, list);
        }

        return answer;
    }

    private void reorganizing(int k, List<Score> list) {
        if(list.size() > k) {
            for (int i = k; i < list.size(); i++) {
                list.remove(i);
            }
        }
    }

    public Queue<Score> init(String[] user_scores) {
        Queue<Score> queue = new LinkedList<>();
        for (int i = 0; i < user_scores.length; i++) {
            String[] splitted = user_scores[i].split(" ");
            queue.offer(new Score(splitted[0], Integer.parseInt(splitted[1])));
        }
        return queue;
    }

    public boolean hasChange(List<Score> list, Score score, int K) {
        int beforeSize = list.size();
        ExistingUserCheck(list, score);
        int afterSize = list.size();
        if(afterSize > beforeSize && afterSize <= K) return true;
        for (int i = list.size() - 1; i > 0; i--) {
            Score back = list.get(i);
            Score front= list.get(i - 1);
            if(back.score > front.score) return true;
        }
        return false;
    }

    public void ExistingUserCheck(List<Score> list, Score score) {
        boolean existing = false;
        for (Score score1 : list) {
            if(score1.userId.equals(score.userId)) {
                if(score1.score < score.score) {
                    existing = true;
                    break;
                }
                score1.score = score.score;
                existing = true;
                break;
            }
        }
        if(!existing) list.add(score);
    }
}

class Score implements Comparable<Score>{
    String userId;
    int score;

    public Score(String userId, int score) {
        this.userId = userId;
        this.score = score;
    }

    @Override
    public int compareTo(Score o) {
        return o.score - this.score;
    }
}
