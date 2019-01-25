package Codeforces535_1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] splitted = br.readLine().split(" ");
            int[] nums = new int[splitted.length];
            for (int j = 0; j < splitted.length; j++) {
                nums[j] = Integer.parseInt(splitted[j]);
            }

            int ll = nums[0];
            int lr = nums[1];
            int rl = nums[2];
            int rr = nums[3];

            int a = 0;
            int b = 0;
            for (a = ll; a <= lr; a++) {
                boolean flag = false;
                for (b = rl; b <= rr; b++) {
                    if(a != b) {
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            System.out.println(a + " " + b);
        }
    }
}
