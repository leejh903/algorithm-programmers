package p17684;

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = init();
        Queue<String> queue = new LinkedList(Arrays.asList(msg.split("")));

        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(queue.peek());
            while (!queue.isEmpty() && map.containsKey(sb.toString())) {
                queue.poll();
                sb.append(queue.peek());
            }

            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.size() + 1);
                String temp = sb.subSequence(0, sb.length() - 1).toString();
                answer.add(map.get(temp));
            } else {
                answer.add(map.get(sb.toString()));
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    public Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), i - 'A' + 1);
        }
        return map;
    }
}