package l49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> mapper = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> val = mapper.getOrDefault(key, new ArrayList<>());
            val.add(str);
            mapper.put(key, val);
        }

        for (String s : mapper.keySet()) {
            answer.add(mapper.get(s));
        }

        return answer;
    }
}
