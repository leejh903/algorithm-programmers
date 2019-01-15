package p42886;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < Math.pow(2, weight.length); i++) {
            String[] binaryString = Integer.toBinaryString(i).split("");
            int index = 0;
            int num = 0;
            for (int j = binaryString.length - 1; j >= 0; j--) {
                num += Integer.parseInt(binaryString[j]) * weight[index];
                index++;
            }
            System.out.println(num);
            set.add(num);
        }

        for (int i = 1; i < Math.pow(2, weight.length); i++) {
            if(!set.contains(i)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
