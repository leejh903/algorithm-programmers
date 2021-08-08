package l36;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < N; i++) {
            if (!isValid(board[i])) return false;
        }

        for (int i = 0; i < N; i++) {
            char[] target = new char[N];
            for (int j = 0; j < N; j++) {
                target[j] = board[j][i];
            }
            if (!isValid(target)) return false;
        }

        for (int i = 0; i < N; i += 3) {
            for (int j = 0; j < N; j += 3) {
                int n = 0;
                char[] target = new char[N];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        target[n] = board[k][l];
                        n++;
                    }
                }
                if (!isValid(target)) return false;
            }
        }

        return true;
    }

    private boolean isValid(char[] chars) {
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (c != '.' && set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
