package p42839;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String numbers = "17";
        assertThat(problem.solution(numbers)).isEqualTo(3);
    }

    @Test
    public void test2() {
        String numbers = "011";
        assertThat(problem.solution(numbers)).isEqualTo(2);
    }

    @Test
    public void test3() {
        int[] arr = {1, 3, 5};
        int[] data = new int[arr.length];
        combinationUtil(arr, data, 0, arr.length - 1, 0, 2);
    }

    void combinationUtil(int arr[], int data[], int start,
                         int end, int index, int r) {
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();

        if (index == r) {
            System.out.print("------>");
            for (int i : data) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            System.out.println(String.format("end-i+1: %d, r-index: %d", end - i + 1, r - index));
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

}