package p17677;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = init(str1);
        Map<String, Integer> map2 = init(str2);

        double intersection = 0;
        double union = 0;

        for (String s : map1.keySet()) {
            if(map2.containsKey(s)) {
                intersection += Math.min(map1.get(s), map2.get(s));
                union += Math.max(map1.get(s), map2.get(s));
                map2.remove(s);
                continue;
            }
            union += map1.get(s);
        }

        for (String s : map2.keySet()) {
            union += map2.get(s);
        }

        double divied;
        if(union == 0.0) divied = 1;
        else divied = intersection / union;

        return (int)(divied * 65536);
    }

    public Map<String, Integer> init(String str) {
        Map<String, Integer> map = new HashMap<>();
        char[] charStr = str.toCharArray();
        return mapInit(map, charStr);
    }

    private Map<String, Integer> mapInit(Map<String, Integer> map, char[] charStr) {
        for (int i = 0; i < charStr.length - 1; i++) {
            if(isValid(charStr[i]) && isValid(charStr[i + 1])){
                StringBuilder sb = new StringBuilder();
                sb.append(toUpperCase(charStr[i]));
                sb.append(toUpperCase(charStr[i + 1]));
                String text = sb.toString();
                int num = map.getOrDefault(text, 0);
                map.put(text, num + 1);
            }
        }
        return map;
    }

    char toUpperCase(char c) {
        if(c >= 'a' && c <= 'z') return (char) (c - 32);
        return c;
    }

    boolean isValid(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
