package p49191;

<<<<<<< HEAD
=======
import java.util.*;

>>>>>>> 5b10347
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

<<<<<<< HEAD
        boolean[][] chk = new boolean[n + 1][n + 1];

        for(int i = 0; i < results.length; i++) {
            chk[results[i][0]][results[i][1]] = true;
        }

        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(i != j && chk[i][k] && chk[k][j]) {
                        chk[i][j] = true;
=======
        boolean[][] m = new boolean[n + 1][n + 1];
        Map<Integer, List<Integer>> map = init(results);

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = true;
            while(!queue.isEmpty()) {
                int num = queue.poll();
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                for (Integer integer : list) {
                    if(!visit[integer]) {
                        visit[integer] = true;
                        m[i][integer] = true;
                        queue.add(integer);
>>>>>>> 5b10347
                    }
                }
            }
        }

<<<<<<< HEAD
        for (boolean[] booleans : chk) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + " ");
            }
            System.out.println();
=======
        for (int i = 1; i < n + 1; i++) {
            boolean pass = true;
            for (int j = 1; j < n + 1; j++) {
                if(i != j && !m[i][j] && !m[j][i]) {
                    pass = false;
                    break;
                }
            }
            if(pass) answer++;
>>>>>>> 5b10347
        }

        for(int i = 1; i < n + 1; i++) {
            boolean pass = true;
            for(int j = 1; j < n + 1; j++) {
                if(i != j && !(chk[i][j] || chk[j][i])) {
                    pass = false;
                    break;
                }
            }
            if(pass) {
                answer++;
            }
        }

        return answer;
    }
}