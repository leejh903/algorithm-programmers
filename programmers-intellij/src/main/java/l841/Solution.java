package l841;

import java.util.List;

class Solution {
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];

        visited[0] = true;
        dfs(rooms, 0);

        boolean result = true;
        for (boolean v : visited) {
            if (!v) {
                result = false;
            }
        }
        return result;
    }

    void dfs(List<List<Integer>> rooms, int index) {
        for (int i = 0; i < rooms.get(index).size(); i++) {
            int next = rooms.get(index).get(i);
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            dfs(rooms, next);
        }
    }
}
