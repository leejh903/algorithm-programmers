package permutation;

import java.util.Arrays;

public class Combination {

    void combination(int[] arr, int data[], int start, int end, int index, int r) {
        if(index == r) {
            System.out.println(Arrays.toString(data));
            return;
        }

        for (int i = start; i < end && end - i >= r - index; i++) {
            data[index] = arr[i];
            combination(arr, data, i + 1, end, index + 1, r);
        }
    }
}
