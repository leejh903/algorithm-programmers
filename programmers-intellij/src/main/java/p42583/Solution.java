package p42583;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> before = new LinkedList();
        LinkedList<Integer> middle = new LinkedList<>();
        int answer = 0;  // 경과 시간
        int curWeight = 0;  // 다리 무게
        int truckIndex = 0;  // 트럭 무게 알기위함

        for (int i = 0; i < truck_weights.length; i++) {
            before.offer(truck_weights[i]);
        }

        while (true) {
            answer++;

            // 거리 증감부터 하는 이유는 트럭 추가 후 바로 거리 증가를 막기위함
            if (!middle.isEmpty()) {
                for (int i = 0; i < middle.size(); i++) {
                    middle.set(i, middle.get(i) + 1);  // 다리 위 트럭 모두 거리 +1 증가
                }

                // 모두 증가시키고 이후에 비교하여야함. 안 그러면 poll() 때문에 인덱스 변경 발생
                if (middle.getFirst() == bridge_length) {
                    middle.poll();
                    curWeight -= truck_weights[truckIndex];
                    truckIndex++;  // 트럭이 들어온 순서대로 빠지기 때문에 차례로 인덱스 늘려주면 됨
                }
            }

            // 트럭 추가
            if (!before.isEmpty() && curWeight + before.peek() <= weight) {
                curWeight += before.poll();
                middle.offer(0);  // 트럭 다리 위에 추가시 거리 0으로 추가
            }

            if (middle.isEmpty()) {  // 다리 위에 트럭 아무것도 없을 때 종료
                break;
            }
        }

        return answer;
    }
}
