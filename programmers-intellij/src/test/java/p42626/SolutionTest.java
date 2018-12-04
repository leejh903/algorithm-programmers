package p42626;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        assertThat(problem.solution(scoville, 7)).isEqualTo(2);
    }

    @Test
    public void test2() {
        // 0 0 1
        // 0 1
        // 2
        int[] scoville = {0, 0, 1};
        assertThat(problem.solution(scoville, 2)).isEqualTo(2);
    }

    @Test
    public void arraList_remove_테스트() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 4, 4, 5, 6));
        list.remove(3);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    @Test
    public void swap_테스트() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        List<Integer> scovilleList = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        swap(scovilleList, 1, 2);
        assertThat(scovilleList.get(1)).isEqualTo(3);
        assertThat(scovilleList.get(2)).isEqualTo(2);
    }

    @Test
    public void 힙_만들기() {
        int[] scoville = {1, 5, 2, 9, 12, 10};
        List<Integer> heapList = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        makeHeap(heapList);
        print(heapList);
    }

    @Test
    public void 힙_정렬() {
        int[] scoville = {1, 5, 2, 9, 12, 10};
        List<Integer> heapList = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        makeHeap(heapList);

        int sizeOfHeap = heapList.size() - 1;
        for (int i = sizeOfHeap; i > 0; i--) {
            swap(heapList, 0, i);
            sizeOfHeap--;
            heapify(heapList, 0, sizeOfHeap);
        }
        print(heapList);
    }

    void heapify(List<Integer> list, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min;
        if(left <= size && list.get(left) < list.get(i)) {
            min = left;
        } else {
            min = i;
        }

        if(right <= size && list.get(right) < list.get(min)) {
            min = right;
        }

        if(min != i) {
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

    void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}