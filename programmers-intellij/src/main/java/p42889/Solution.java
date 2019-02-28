package p42889;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> list = init(N);
        calculate(list, stages);
        list.remove(N);
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).getStage();
        }

        return answer;
    }

    void calculate(List<Stage> list, int[] stages) {
        for (int stage : stages) {
            for (int i = 0; i < stage; i++) {
                list.get(i).increasePass();
                if(i == stage - 1) list.get(i).increaseChallenging();
            }
        }
    }

    public List<Stage> init(int n) {
        List<Stage> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new Stage(i + 1));
        }
        return list;
    }
}

class Stage implements Comparable<Stage>{
    private int stage;
    private int pass = 0;
    private int challenging = 0;

    public Stage(int stage) {
        this.stage = stage;
    }

    public void increasePass() {
        pass++;
    }

    public void increaseChallenging() {
        challenging++;
    }

    public double getFailure() {
        if(pass == 0) return 0;
        return (double)challenging / pass;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public int compareTo(Stage o) {
        double thisFailure = getFailure();
        double oFailure = o.getFailure();
        int flag = 0;
        if(oFailure - thisFailure > 0) flag = 1;
        else flag = -1;
        if(thisFailure == oFailure) {
            return stage - o.stage;
        }
        return flag;
    }
}