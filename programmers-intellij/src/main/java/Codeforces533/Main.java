package Codeforces533;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] numsText = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numsText[i]);
        }

        Arrays.sort(nums);
        int max = nums[N - 1];
        int min = nums[0];

        int answer = 0;
        int cost = 100000;
        for (int t = max; t >= min; t--) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if(nums[i] >= -1 + t && nums[i] <= 1 + t) continue;
                else {
                    temp += Math.min(Math.abs(nums[i] - t + 1), Math.abs(nums[i] - t - 1));
                }
            }

            if(temp < cost) {
                answer = t;
                cost = temp;
            }
        }

        bw.write(answer + " " + cost);
        bw.close();
    }
}
