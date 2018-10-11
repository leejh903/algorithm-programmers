import java.util.Arrays;
import java.util.Collections;

class KthNum {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for (int[] command : commands) {
            int startIndex = command[0] - 1;
            int endIndex = command[1] - 1;
            int nthIndex = command[2] - 1;

            int temp[] = Arrays.copyOfRange(array, startIndex, endIndex+1);
            Arrays.sort(temp);
            answer[index] = temp[nthIndex];
            index++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer;
        KthNum problem = new KthNum();
        answer = problem.solution(array, commands);
        for (int var : answer) {
            System.out.println(var);
        }
    }
}