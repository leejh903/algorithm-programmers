package kickstart_2021a_1;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String S = br.readLine();

            int k = 0;
            for (int j = 0; j < N / 2; j++) {
                if (S.charAt(j) != S.charAt(N - j - 1))
                    k++;
            }

            System.out.printf("Case #%d: %d\n", i, Math.abs(K - k));
        }
    }
}
