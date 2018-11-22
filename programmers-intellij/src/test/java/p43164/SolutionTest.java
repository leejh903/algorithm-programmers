package p43164;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();
    boolean flag = false;

    @Test
    public void 배열_정렬() {
        String[] array = {"ICN", "JFK", "HND", "IAD"};  // [HND, IAD, ICN, JFK]으로 정렬 가능
        List<String> arrayList = new ArrayList<>(Arrays.asList(array));
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    @Test
    public void 입력값_구성() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        Map<String, List<Ticket>> map = init(tickets);

        // 출력
        for (String s : map.keySet()) {
            for (Ticket ticket : map.get(s)) {
                System.out.println(ticket.departure + " -> " + ticket.arrival + " : " + (ticket.used ? "true" : "false"));
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

    @Test
    public void DFS_구성() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        Map<String, List<Ticket>> map = init(tickets);
        Stack<String> answer = new Stack<>();
        answer.push("ICN");
        dfs(map, answer, "ICN", 0, tickets.length);
        System.out.println(answer);
    }

    @Test
    public void test2() {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        Map<String, List<Ticket>> map = init(tickets);
        Stack<String> answer = new Stack<>();
        answer.push("ICN");
        dfs(map, answer, "ICN", 0, tickets.length);
        System.out.println(answer);
    }

    void dfs(Map<String, List<Ticket>> map, Stack<String> answer, String departure, int pass, int target) {
        for (Ticket ticket : map.get(departure)) {
            System.out.println(ticket.departure + " -> " + ticket.arrival + " : " + (ticket.used ? "true" : "false") + " pass : " + pass);
            if(flag) ticket.used = true;
            if (ticket.used == false) {
                if (pass == target - 1) {
                    answer.push(ticket.arrival);
                    flag = true;
                    System.out.println("끝 : " + answer);
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

    @Test
    public void test3() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        problem.solution(tickets);
    }

    @Test
    public void test4() {
        String[][] tickets = {{"ICN", "BBB"}, {"ICN", "BBC"}, {"BBB", "CCC"}, {"CCC", "ICN"}, {"ICN", "DDD"}, {"DDD", "EEE"}, {"EEE", "ICN"}};
        problem.solution(tickets);
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

