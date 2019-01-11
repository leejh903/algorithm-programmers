package hello2019;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char first = s.charAt(0);
        char second = s.charAt(1);

        String ss = br.readLine();
        StringTokenizer stk = new StringTokenizer(ss);
        while (stk.hasMoreTokens()) {
            String target = stk.nextToken();
            if(target.charAt(0) == first || target.charAt(1) == second) {
                bw.write("YES");
                bw.close();
                return;
            }
        }
        bw.write("NO");
        bw.close();
    }
}
