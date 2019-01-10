package p42839;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> numSet = new HashSet<>();

    public int solution(String numbers) {
        String[] numText = numbers.split("");
        int[] num = new int[numText.length];
        for (int i = 0; i < numText.length; i++) {
            num[i] = Integer.valueOf(numText[i]);
        }

        for (int i = 1; i <= num.length; i++) {
            int[] data = new int[i];
            combinationUtil(num, data, 0, num.length - 1, 0, i);
        }

        return numSet.size();
    }

    void combinationUtil(int arr[], int data[], int start,
                         int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            permutation(data, 0, data.length, data.length);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    void myswap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void permutation(int[] arr, int d, int n, int r) {
        if (r == 0) {
            int num = makeNum(arr, d);
            if(isDecimal(num)) {
                numSet.add(num);
            }
            return;
        }
        for (int i = d; i < n; i++) {
            myswap(arr, d, i);
            permutation(arr, d + 1, n, r - 1);
            myswap(arr, d, i);
        }
    }

    private boolean isDecimal(int num) {
        if(num < 2) return false;
        for (int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    private int makeNum(int[] arr, int d) {
        int num = 0;
        for (int i = 0; i < d; i++) {
            if(i > 0) num *= 10;
            num += arr[i];
        }
        return num;
    }

}
