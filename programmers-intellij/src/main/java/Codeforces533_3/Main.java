package Codeforces533_3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        String min = input[1];
        String max = input[2];

        StringBuilder sbMin = new StringBuilder();
        StringBuilder sbMax = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sbMin.append(min);
            sbMax.append(max);
        }

        long start = Long.parseLong(sbMin.toString());
        long end = Long.parseLong(sbMax.toString());


        int answer = 0;
        for (long i = start; i < end; i++) {
            long temp = i;
            long a = temp % 10;
            temp /= 10;
            long b = temp % 10;
            long num = b * 10 + a;
            System.out.println(num);
            if(num % 3 == 0) {
                answer++;
//                answer = (int) ((answer++) % (Math.pow(10, 9) + 7));
            }
        }

        System.out.println(answer);
        bw.close();
    }

}
