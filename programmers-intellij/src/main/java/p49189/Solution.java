package p49189;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int length = 0;
        int answer = 0;
        Map<Integer, List<Integer>> map = init(edge);
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        visit[1] = true;
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nNum = node.num;
            int nLength = node.length;

            if (nLength == length) answer++;
            else {
                length = nLength;
                answer = 1;
            }

            for (Integer integer : map.getOrDefault(nNum, new ArrayList<>())) {
                if (!visit[integer]) {
                    queue.add(new Node(integer, nLength + 1));
                    visit[integer] = true;
                }
            }
        }

        return answer;
    }

    public Map<Integer, List<Integer>> init(int[][] edge) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : edge) {
            int num1 = ints[0];
            int num2 = ints[1];
            List<Integer> values = map.getOrDefault(num1, new ArrayList<>());
            List<Integer> values2 = map.getOrDefault(num2, new ArrayList<>());
            values.add(num2);
            values2.add(num1);
            map.put(num1, values);
            map.put(num2, values2);
        }
        return map;
    }
}

class Node {
    int num;
    int length;

    public Node(int num, int length) {
        this.num = num;
        this.length = length;
    }
}