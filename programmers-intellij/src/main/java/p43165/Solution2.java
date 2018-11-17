package p43165;

public class Solution2 {

    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, numbers.length - 1);
        return answer;
    }

    int dfs(int[] numbers, int target, int sum, int index) {
        if (index < 0) {
            if (sum == target) return 1;
            else return 0;
        }

        return dfs(numbers, target, sum + numbers[index], index - 1) +
                dfs(numbers, target, sum - numbers[index], index - 1);
    }
}
