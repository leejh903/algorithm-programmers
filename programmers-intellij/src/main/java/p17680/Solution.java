package p17680;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String tempCity = cities[i].toLowerCase();
            if (queue.contains(tempCity)) {
                String theCity = queue.remove(queue.indexOf(tempCity));
                queue.offerLast(theCity);
                answer++;
                continue;
            }

            if(queue.size() >= cacheSize) queue.pollFirst();
            if(cacheSize > 0) queue.offerLast(tempCity);
            answer += 5;
        }

        return answer;
    }
}