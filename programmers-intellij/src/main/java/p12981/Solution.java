package p12981;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int drop = 0;
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String now = words[i];
            String before = words[i - 1];
            if (used.contains(now) || now.charAt(0) != before.charAt(before.length() - 1)) {
                drop = i;
                break;
            }
            used.add(now);
        }

        if (drop == 0) {
            return new int[]{0, 0};
        }
        return new int[]{drop % n + 1, drop / n + 1};
    }
}
