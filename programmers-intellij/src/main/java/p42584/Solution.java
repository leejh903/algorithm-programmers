package p42584;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> timeArray = new ArrayList<>();
        for (int price : prices) {
            queue.offer(price);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int time = 0;
            for (Integer integer : queue) {
                time++;
                if (integer < num) {
                    break;
                }
            }
            timeArray.add(time);
        }

        return timeArray.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
