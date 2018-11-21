package p43164;

import java.util.*;

class Solution {
    boolean flag = false;

    public String[] solution(String[][] tickets) {
        Map<String, List<Ticket>> map = init(tickets);
        Stack<String> answer = new Stack<>();
        answer.push("ICN");
        dfs(map, answer, "ICN", 0, tickets.length);
        String[] submit = new String[answer.size()];
        for (int i = answer.size() - 1; i >= 0; i--) {
            submit[i] = answer.pop();
        }
        return submit;
    }

    void dfs(Map<String, List<Ticket>> map, Stack<String> answer, String departure, int pass, int target) {
        for (Ticket ticket : map.get(departure)) {
            if(flag) ticket.used = true;
            if (ticket.used == false) {
                if (pass == target - 1) {
                    answer.push(ticket.arrival);
                    flag = true;
                    return;
                }
                ticket.used = true;
                answer.push(ticket.arrival);
                dfs(map, answer, ticket.arrival, pass + 1, target);
                if (!flag) {
                    ticket.used = false;
                    answer.pop();
                }
            }
        }
    }

    private Map<String, List<Ticket>> init(String[][] tickets) {
        Map<String, List<Ticket>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(new Ticket(ticket[0], ticket[1], false));
                continue;
            }
            List<Ticket> tempList = new ArrayList<>();
            tempList.add(new Ticket(ticket[0], ticket[1], false));
            map.put(ticket[0], tempList);
        }
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));  // 정렬
        }
        return map;
    }
}

class Ticket implements Comparable<Ticket> {
    String departure;
    String arrival;
    boolean used;

    public Ticket(String departure, String arrival, boolean used) {
        this.departure = departure;
        this.arrival = arrival;
        this.used = used;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.arrival.compareTo(o.arrival);
    }
}