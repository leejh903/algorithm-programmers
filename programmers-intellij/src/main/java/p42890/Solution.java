package p42890;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    List<String> combinations = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        init(relation[0].length);

        boolean[] checked = new boolean[combinations.size()];
        for (int i = 0; i < combinations.size(); i++) {
            String indexText = combinations.get(i);

            if (!checked[i]) {
                int[] indexs = toIntArray(indexText);
                Set<String> set = makeSet(indexs, relation);

                if (set.size() == relation.length) {
                    for (int j = i + 1; j < combinations.size(); j++) {
                        if (contains(indexs, toIntArray(combinations.get(j)))) checked[j] = true;
                    }
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean contains(int[] indexs, int[] nextIndexs) {
        List<Integer> index1 = Arrays.stream(indexs).boxed().collect(Collectors.toList());
        List<Integer> index2 = Arrays.stream(nextIndexs).boxed().collect(Collectors.toList());
        for (Integer integer : index1) {
            if(!index2.contains(integer)) return false;
        }
        return true;
    }

    private Set<String> makeSet(int[] indexs, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] strings : relation) {
            StringBuilder sb = new StringBuilder();
            for (int index : indexs) {
                sb.append(strings[index] + " ");
            }
            set.add(sb.toString());
        }
        return set;
    }

    private int[] toIntArray(String indexText) {
        String[] texts = indexText.split(" ");
        int[] indexs = new int[texts.length];
        for (int i = 0; i < texts.length; i++) {
            indexs[i] = Integer.parseInt(texts[i]);
        }
        return indexs;
    }

    void init(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            int[] data = new int[i + 1];
            combination(arr, data, 0, arr.length, 0, i + 1);
        }
    }

    void combination(int[] arr, int data[], int start, int end, int index, int r) {
        if (index == r) {
            Arrays.sort(data);
            StringBuilder sb = new StringBuilder();
            for (int datum : data) {
                sb.append(datum + " ");
            }
            combinations.add(sb.toString());
            return;
        }

        for (int i = start; i < end && end - i >= r - index; i++) {
            data[index] = arr[i];
            combination(arr, data, i + 1, end, index + 1, r);
        }
    }
}