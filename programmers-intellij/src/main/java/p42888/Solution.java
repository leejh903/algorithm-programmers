package p42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = init(record);
        print(answer, record, map);
        return answer.toArray(new String[answer.size()]);
    }

    private void print(List<String> answer, String[] record, Map<String, String> map) {
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            String command = split[0];
            String userId = split[1];

            if (command.equals("Enter")) {
                answer.add(map.get(userId) + "님이 들어왔습니다.");
            }
            if (command.equals("Leave")) {
                answer.add(map.get(userId) + "님이 나갔습니다.");
            }
        }
    }

    public Map<String, String> init(String[] record) {
        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            String userId = split[1];
            if (command.equals("Enter") || command.equals("Change")) {
                String name = split[2];
                map.put(userId, name);
            }
        }
        return map;
    }
}