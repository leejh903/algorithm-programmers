package p12978;

import java.util.*;

class Solution {
    private Map<Integer, List<To>> connections = new HashMap<>();
    private boolean[] visited; // 1base
    private int answer = 0;
    private int K;

    public int solution(int N, int[][] road, int K) {
        visited = new boolean[N + 1];
        this.K = K;

        createConnections(road);

        visited[1] = true;
        dfs(1, 0);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public void dfs(int from, int sum) {
        List<To> tos = connections.get(from);
        for (To toData : tos) {
            int to = toData.getTo();
            if(visited[to] || sum + toData.getEffort() > K) {
                answer = Math.max(answer, checkVisited());
                continue;
            }
            visited[to] = true;
            dfs(to, sum + toData.getEffort());
            visited[to] = false;
        }
    }

    public int checkVisited() {
        int res = 0;
        for (boolean b : visited) {
            if(b) res++;
        }
        return res;
    }

    private void createConnections(int[][] road) {
        Map<String, Integer> data = new HashMap<>();
        for (int[] ints : road) {
            int from = ints[0];
            int to = ints[1];
            int val = ints[2];

            String history = History.printHistory(from, to);
            int v = data.getOrDefault(history, Integer.MAX_VALUE);
            data.put(history, Math.min(val, v));
        }

        for (String s : data.keySet()) {
            int from = History.extractFrom(s);
            int to = History.extractTo(s);
            int val = data.get(s);

            List<To> tos = connections.getOrDefault(from, new ArrayList<>());
            List<To> froms = connections.getOrDefault(to, new ArrayList<>());
            tos.add(new To(to, val));
            froms.add(new To(from, val));
            connections.put(from, tos);
            connections.put(to, froms);
        }
    }

    static class To {
        private final int to;
        private final int effort;

        public To(int to, int effort) {
            this.to = to;
            this.effort = effort;
        }

        public int getTo() {
            return to;
        }

        public int getEffort() {
            return effort;
        }

        @Override
        public String toString() {
            return "{to=" + to + ", effort=" + effort + '}';
        }
    }

    static class History {
        private static final String historyFormat = "(%d,%d)";
        private Set<String> history;

        public History() {
            this.history = new HashSet<>();
        }

        public void saveHistory(int from, int to) {
            history.add(printHistory(from, to));
        }

        public void removeHistory(int from, int to) {
            history.remove(printHistory(from, to));
        }

        public boolean hasHistory(int from, int to) {
            return history.contains(printHistory(from, to));
        }

        public static int extractFrom(String history) {
            String sub = history.substring(1, history.length() - 1);
            return Integer.parseInt(sub.split(",")[0]);
        }

        public static int extractTo(String history) {
            String sub = history.substring(1, history.length() - 1);
            return Integer.parseInt(sub.split(",")[1]);
        }

        public static String printHistory(int from, int to) {
            return String.format(historyFormat, from, to);
        }
    }
}