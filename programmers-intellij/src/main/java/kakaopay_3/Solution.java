package kakaopay_3;

import java.util.*;

public class Solution {
    public int[] solution(int N, int[] coffee_times) {
        List<Integer> answer = new ArrayList<>();

        Queue<Coffee> queue;
        Queue<Coffee> working;
        queue = init(coffee_times);
        working = init2(N, queue);

        while(!working.isEmpty()){
            Coffee temp = working.poll();
            answer.add(temp.order);

            Iterator<Coffee> iterator = working.iterator();
            while(iterator.hasNext()) {
                Coffee coffee = iterator.next();
                coffee.time -= temp.time;
                if(coffee.time == 0) {
                    answer.add(coffee.order);
                    iterator.remove();
                }
            }

            while(!queue.isEmpty() && working.size() < N) {
                working.offer(queue.poll());
            }
        }

        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }

    private Queue<Coffee> init2(int n, Queue<Coffee> queue) {
        Queue<Coffee> working = new PriorityQueue<>();
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

class Coffee implements Comparable<Coffee>{
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

    @Override
    public int compareTo(Coffee o) {
        if(this.time == o.time) {
            return this.order - o.order;
        }
        return this.time - o.time;
    }
}
