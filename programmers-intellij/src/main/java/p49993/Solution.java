package p49993;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> charMapper = new HashMap<>();  // Integer is index of skill

        for (int i = 0; i < skill.length(); i++) {
            charMapper.put(skill.charAt(i), i);
        }

        for (String skill_tree : skill_trees) {
            int currentIndex = -1;
            boolean pass = true;
            for (char ch : skill_tree.toCharArray()) {
                if (charMapper.containsKey(ch)) {
                    int i = charMapper.get(ch);

                    if ((currentIndex == -1 && i != 0) ||  // check first point
                            (currentIndex != -1 && currentIndex != i - 1)) {  // check sequential process
                        pass = false;
                        break;
                    }

                    currentIndex++;
                }
            }

            if (pass) answer++;
        }

        return answer;
    }
}