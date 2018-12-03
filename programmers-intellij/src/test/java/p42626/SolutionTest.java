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
        List<Integer> scovilleList = new ArrayList<>();
        for (int i = 0; i < scoville.length; i++) {
            scovilleList.add(scoville[i]);
            while(scovilleList.get(i / 2) > scoville[i]) {
                swap(scovilleList, i / 2, i);
            }
        }
    }

    @Test
    public void 하나_추출후_정렬() {
        int[] scoville = {1, 5, 2, 9, 12, 10};
        List<Integer> heapList = makeHeap(scoville);

        while(!heapList.isEmpty()) {
            swap(heapList, 0, heapList.size() - 1);
            System.out.println(heapList.remove(heapList.size() - 1));  // 제일 작은 수
            //todo 위에 것만 바꿔주는 것이 아니라 아래것도 계속 바꾸어줘야함
        }

    }

    List<Integer> makeHeap(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
            while(list.get(i / 2) > array[i]) {
                swap(list, i / 2, i);
            }
        }
        return list;
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