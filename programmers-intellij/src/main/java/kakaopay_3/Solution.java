package kakaopay_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int N, int[] coffee_times) {
        List<Integer> answer = new ArrayList<>();

        Queue<Coffee> queue;
        Queue<Coffee> working;
        queue = init(coffee_times);
        working = init2(N, queue);

        while(!working.isEmpty()){
            for (int i = 0; i < working.size(); i++) {
                Coffee coffee = working.poll();
                coffee.time--;
                if(coffee.time == 0) {
                    answer.add(coffee.order);
                    if(!queue.isEmpty()) working.offer(queue.poll());
                    continue;
                }
                working.offer(coffee);
            }
        }

        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }

    private Queue<Coffee> init2(int n, Queue<Coffee> queue) {
        Queue<Coffee> working = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            working.add(queue.poll());
        }
        return working;
    }

    public Queue<Coffee> init(int[] coffee_times) {
        Queue<Coffee> queue = new LinkedList<>();
        for (int i = 0; i < coffee_times.length; i++) {
            queue.add(new Coffee(i + 1, coffee_times[i]));
        }
        return queue;
    }
}

class Coffee {
    int order;
    int time;

    public Coffee(int order, int time) {
        this.order = order;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "order=" + order +
                ", time=" + time +
                '}';
    }
}
