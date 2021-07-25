package l30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> perm = new ArrayList<>();

    public List<Integer> findSubstring(String s, String[] words) {
        permutation(words, 0, words.length, words.length);

        Set<Integer> answer = new HashSet<>();
        for (String str : perm) {
            int res = 0;
            int index = 0;
            while(res != -1) {
                res = s.indexOf(str, index);
                if(res != -1) {
                    answer.add(res);
                    index += 1;
                }
            }
        }
        return new ArrayList<>(answer);
    }

    void permutation(String[] arr, int depth, int n, int r) {
        if (depth == r) {
            String str = "";
            for (String s : arr) {
                str = str.concat(s);
            }
            perm.add(str);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
