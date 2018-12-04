package p42626;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        List<Integer> heapList = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        makeHeap(heapList);

        while (!heapList.isEmpty()) {
            int temp1 = heapList.remove(0);
            if(temp1 >= K) return answer;
            if(heapList.size() <= 0) return -1;
            int temp2 = heapList.get(0);

            heapList.set(0, temp1 + (temp2 * 2));
            heapify(heapList, 0, heapList.size() - 1);
            answer++;
        }
        return -1;
    }

    void heapify(List<Integer> list, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min;
        if (left <= size && list.get(left) < list.get(i)) {
            min = left;
        } else {
            min = i;
        }

        if (right <= size && list.get(right) < list.get(min)) {
            min = right;
        }

        if (min != i) {
            swap(list, i, min);
            heapify(list, min, size);
        }
    }

    void makeHeap(List<Integer> list) {
        for (int i = (list.size() - 1) / 2; i >= 0; i--) {
            heapify(list, i, list.size() - 1);
        }
    }

    void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}