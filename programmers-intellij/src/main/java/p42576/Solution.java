package p42576;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hash = new HashMap<>();
        for (String s : participant) {
            if(hash.get(s) == null) {
                hash.put(s, 1);
            } else {
                hash.put(s, hash.get(s) + 1);
            }
        }

        for (String s : completion) {
            hash.put(s, hash.get(s) - 1);
            if(hash.get(s) == 0) {
                hash.remove(s);
            }
        }

        return hash.keySet().toArray()[0].toString();
    }
}
