package p49994;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        Movement movement = new Movement(5, 5);
        for (char c : dirs.toCharArray()) {
            boolean isNewWay;
            switch (c) {
                case 'U': {
                    isNewWay = movement.up();
                    break;
                }
                case 'D': {
                    isNewWay = movement.down();
                    break;
                }
                case 'R': {
                    isNewWay = movement.right();
                    break;
                }
                case 'L': {
                    isNewWay = movement.left();
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + c);
            }

            if (isNewWay) answer++;
        }

        return answer;
    }

    static class Movement {
        private Set<String> history;
        private int row;
        private int col;

        public Movement(int row, int col) {
            this.history = new HashSet<>();
            this.row = row;
            this.col = col;
        }

        private boolean isOutOfRange(int row, int col) {
            return row < 0 || row > 10 || col < 0 || col > 10;
        }

        // point + direction
        // from: 해당 포인트를 기준으로 *오는* 방향
        private boolean visited(char from) {
            String straight = GetHistoryData(this.row, this.col, from);
            String reverse = GetReverseHistoryData(this.row, this.col, from);
            if (this.history.contains(straight) || this.history.contains(reverse)) {
                return true;
            }
            this.history.add(straight);
            this.history.add(reverse);
            return false;
        }

        public static String GetReverseHistoryData(int row, int col, char from) {
            char reverseDirection;
            switch (from) {
                case 'L':
                    reverseDirection = 'R';
                    col--;
                    break;
                case 'R':
                    reverseDirection = 'L';
                    col++;
                    break;
                case 'D':
                    reverseDirection = 'U';
                    row--;
                    break;
                case 'U':
                    reverseDirection = 'D';
                    row++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + from);
            }

            return GetHistoryData(row, col, reverseDirection);
        }

        public static String GetHistoryData(int row, int col, char from) {
            return String.format("(%d,%d)%s", row, col, from);
        }

        public boolean up() {
            if (isOutOfRange(this.row + 1, this.col)) return false;
            this.row++;
            return !visited('D');
        }

        public boolean down() {
            if (isOutOfRange(this.row - 1, this.col)) return false;
            this.row--;
            return !visited('U');
        }

        public boolean right() {
            if (isOutOfRange(this.row, this.col + 1)) return false;
            this.col++;
            return !visited('L');
        }

        public boolean left() {
            if (isOutOfRange(this.row, this.col - 1)) return false;
            this.col--;
            return !visited('R');
        }
    }
}
