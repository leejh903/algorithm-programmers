package l119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            List<Integer> current = new ArrayList<>();

            for (int col = 0; col < row + 1; col++) {
                if (col == 0 || col == row) {
                    current.add(1);
                    continue;
                }
                current.add(last.get(col - 1) + last.get(col));
            }
            last = current;
        }
        return last;
    }
}
