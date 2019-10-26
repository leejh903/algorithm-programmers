package kakao2020_60063;

import java.util.*;
import java.util.function.Function;

class Solution {
    private static int[][] _board;
    private static int N;

    public int solution(int[][] board) {
        N = board.length;
        _board = board;
        Set<Robot> history = new HashSet<>();
        List<Function<Robot, Boolean>> motions = new ArrayList<>(
                Arrays.asList(
                        Robot::right, Robot::left, Robot::up, Robot::down,
                        Robot::firstClockWise, Robot::firstCounterClockWise,
                        Robot::secondClockWise, Robot::secondCounterClockWise
                )
        );

        Robot initialRobot = new Robot(
                new ArrayList<>(Arrays.asList(new Coordinate(0, 0), new Coordinate(0, 1))), 0
        );
        Queue<Robot> queue = new LinkedList<>();
        queue.add(initialRobot);
        history.add(initialRobot);
        int answer = -1;
        boolean reached = false;
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            for (Function<Robot, Boolean> motion : motions) {
                Robot copy = robot.clone();
                Boolean canMove = motion.apply(copy);

                if (copy.reachFinal()) {
                    reached = true;
                    answer = copy.getCount();
                }
                if (canMove && !history.contains(copy)) {
                    queue.add(copy);
                    history.add(copy);
                }
            }
            if (reached) break;
        }
        return answer;
    }

    static class Robot {
        private List<Coordinate> coordinates;
        private int count;

        public Robot(List<Coordinate> coordinates, int count) {
            this.coordinates = coordinates;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public Robot clone() {
            List<Coordinate> temp = new ArrayList<>();
            for (Coordinate coordinate : coordinates) {
                temp.add(coordinate.clone());
            }
            return new Robot(temp, count + 1);
        }

        public boolean right() {
            if (coordinates.get(0).col == N - 1 || coordinates.get(1).col == N - 1) return false;
            for (Coordinate coordinate : coordinates) {
                coordinate.col++;
            }
            return true;
        }

        public boolean left() {
            if (coordinates.get(0).col == 0 || coordinates.get(1).col == 0) return false;
            for (Coordinate coordinate : coordinates) {
                coordinate.col--;
            }
            return true;
        }

        public boolean up() {
            if (coordinates.get(0).row == 0 || coordinates.get(1).row == 0) return false;
            for (Coordinate coordinate : coordinates) {
                coordinate.row--;
            }
            return true;
        }

        public boolean down() {
            if (coordinates.get(0).row == N - 1 || coordinates.get(1).row == N - 1) return false;
            for (Coordinate coordinate : coordinates) {
                coordinate.row++;
            }
            return true;
        }

        private boolean clockWise(Coordinate target, Coordinate axis) {
            // 축이 위쪽
            if (axis.row == target.row - 1 && axis.col == target.col) {
                if (target.col == 0 || _board[target.row][target.col - 1] == 1) return false;
                target.col--;
                target.row--;
            }
            // 축이 아래쪽
            if (axis.row == target.row + 1 && axis.col == target.col) {
                if (target.col == N - 1 || _board[target.row][target.col + 1] == 1) return false;
                target.col++;
                target.row++;
            }
            // 축이 오른쪽
            if (axis.row == target.row && axis.col == target.col + 1) {
                if (target.row == 0 || _board[target.row - 1][target.col] == 1) return false;
                target.col++;
                target.row--;
            }
            // 축이 왼쪽
            if (axis.row == target.row && axis.col == target.col - 1) {
                if (target.row == N - 1 || _board[target.row + 1][target.col] == 1) return false;
                target.col--;
                target.row++;
            }
            return true;
        }

        private boolean counterClockWise(Coordinate target, Coordinate axis) {
            // 축이 위쪽
            if (axis.row == target.row - 1 && axis.col == target.col) {
                if (target.col == N - 1 || _board[target.row][target.col + 1] == 1) return false;
                target.col++;
                target.row--;
            }
            // 축이 아래쪽
            if (axis.row == target.row + 1 && axis.col == target.col) {
                if (target.col == 0 || _board[target.row][target.col - 1] == 1) return false;
                target.col--;
                target.row++;
            }
            // 축이 오른쪽
            if (axis.row == target.row && axis.col == target.col + 1) {
                if (target.row == N - 1 || _board[target.row + 1][target.col] == 1) return false;
                target.col++;
                target.row++;
            }
            // 축이 왼쪽
            if (axis.row == target.row && axis.col == target.col - 1) {
                if (target.row == 0 || _board[target.row - 1][target.col] == 1) return false;
                target.col--;
                target.row--;
            }
            return true;
        }

        public boolean firstClockWise() {
            return clockWise(coordinates.get(0), coordinates.get(1));
        }

        public boolean firstCounterClockWise() {
            return counterClockWise(coordinates.get(0), coordinates.get(1));
        }

        public boolean secondClockWise() {
            return clockWise(coordinates.get(1), coordinates.get(0));
        }

        public boolean secondCounterClockWise() {
            return counterClockWise(coordinates.get(1), coordinates.get(0));
        }

        public boolean reachFinal() {
            for (Coordinate coordinate : coordinates) {
                if (coordinate.col == N - 1 && coordinate.row == N - 1) return true;
            }
            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Robot robot = (Robot) o;
            Set<Coordinate> set1 = new HashSet<>(this.coordinates);
            Set<Coordinate> set2 = new HashSet<>(robot.coordinates);
            return Objects.equals(set1, set2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(coordinates);
        }
    }

    static class Coordinate {
        private int row;
        private int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Coordinate clone() {
            return new Coordinate(row, col);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}