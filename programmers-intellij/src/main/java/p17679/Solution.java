package p17679;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        List<List<String>> lists = init(m, n, board);

        while(true) {
            int deleted = 0;

            for (int i = 0; i < n - 1; i++) {
                List<String> list = lists.get(i);
                for (int j = 0; j < list.size() - 1; j++) {
                    if(haveSquare(lists, i, j)){
                        // 재귀 사용해서 삭제할 수 있도록 함수로 따로 뺄것
                    }
                }
            }

            answer += deleted;
            if(deleted == 0) break;
        }

        return answer;
    }

    private boolean haveSquare(List<List<String>> lists, int i, int j) {
        return lists.get(i).size() >= j && lists.get(i + 1).size() >= j;
    }

    public List<List<String>> init(int m, int n, String[] board) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            lists.add(list);
        }

        for (int i = 0; i < m; i++) {
            String[] splitted = board[i].split("");
            for (int j = 0; j < n; j++) {
                lists.get(j).add(splitted[j]);
            }
        }

        return lists;
    }

    private void printList(List<List<String>> lists) {
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
