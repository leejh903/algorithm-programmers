package hello2019_3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        int count = Integer.valueOf(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] line = br.readLine().split("");
            int result = checkLine(line);
            int value = map.getOrDefault(result, 0);
            map.put(result, value + 1);
        }

        for (Integer integer : map.keySet()) {
            if(integer == 0) answer += map.get(0) / 2;
            if(integer < 0) continue;
            if(integer > 0) {
                answer += Math.min(map.getOrDefault(integer, 0), map.getOrDefault(integer * (-1), 0));
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static int checkLine(String[] line) {
        Stack<String> stack = new Stack();
        for (String s : line) {
            if(!stack.isEmpty()) {
                if((s.equals(")") && stack.peek().equals("("))) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s);
        }

        int left = 0;
        int right = 0;
        for (String s : stack) {
            if(s.equals(")")) right++;
            if(s.equals("(")) left++;
        }
        if(left == 0 && right != 0) return right;
        if(left != 0 && right == 0) return left * (-1);
        if(left == 0 && right == 0) return 0;
        return Integer.MAX_VALUE;
    }
}
