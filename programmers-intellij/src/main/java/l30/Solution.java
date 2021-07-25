package l30;

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) {
            return answer;
        }

        int count = words.length;
        int length = words[0].length();
        for (int i = 0; i <= s.length() - (count * length); i++) {
            Map<String, Integer> seen = new HashMap<>();

            // 1개씩 사용할 수 있도록 count
            for (int j = 0; j < count; j++) {
                int next = i + (j * length);
                // 하나씩 단어 추출
                String word = s.substring(next, next + length);

                if(!map.containsKey(word)) break;

                // 단어 개수 저장
                seen.put(word, seen.getOrDefault(word, 0) + 1);

                // 본게(seen) 기존 사용 가능 개수 넘어가면 return
                if(seen.get(word) > map.getOrDefault(word, 0)) break;

                // 마지막까지 1개씩 사용했을 때 유효한 케이스
                if(j + 1 == count) answer.add(i);
            }
        }

        return answer;
    }
}
