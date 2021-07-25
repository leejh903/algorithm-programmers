package l39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        recursive(candidates, target, combination, 0);
        return answer;
    }

    public void recursive(int[] candidates, int target, List<Integer> combination, int offset) {
        int sum = 0;
        for (Integer integer : combination) {
            sum += integer;
        }

        if(sum == target) {
            answer.add(new ArrayList<>(combination));
            return;
        }
        if(sum > target || offset == candidates.length) return;

        combination.add(candidates[offset]);
        recursive(candidates, target, combination, offset);
        combination.remove((Integer) candidates[offset]);
        recursive(candidates, target, combination, offset + 1);
    }
}