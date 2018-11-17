package p43165;

class Solution {
    int answer, target;

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        int[] sign = {-1, 1};

        visit(numbers, sign, numbers.length - 1, 0);
        return answer;
    }

    public void visit(int[] numbers, int[] sign, int index, int sum) {
        if(index < 0) {
            if(sum == target) answer++;
            return;
        }
        for (int i = 0; i < sign.length; i++) {
            visit(numbers, sign, index - 1, sum + (numbers[index] * sign[i]));
        }
    }
}
