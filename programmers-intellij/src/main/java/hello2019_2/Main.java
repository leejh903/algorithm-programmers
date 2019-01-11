package hello2019_2;

import java.io.*;

public class Main {
    static boolean passed = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.valueOf(br.readLine());
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.valueOf(br.readLine());
        }

        search(nums, 0, 0, count);

        if(passed) {
            bw.write("YES");
            bw.close();
            return;
        }
        bw.write("NO");
        bw.close();
    }

    static void search(int[] nums, int sum, int index, int count) {
        boolean pass = false;
        if(index == count && sum % 360 == 0) {
            passed = true;
        }

        if(index >= count) {
            return;
        }

        search(nums, sum - nums[index], index + 1, count);
        search(nums, sum + nums[index], index + 1, count);
    }
}
