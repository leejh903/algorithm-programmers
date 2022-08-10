package l797;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> visits = new ArrayList<>();
            visits.add(0);
            int nextNode = graph[0][i];
            visits.add(nextNode);
            dfs(graph, nextNode, visits);
        }
        return answer;
    }

    void dfs(int[][] graph, int currentNode, List<Integer> visits) {
        if (currentNode == graph.length - 1) {
            answer.add(new ArrayList<>(visits));
            return;
        }

        for (int i = 0; i < graph[currentNode].length; i++) {
            int nextNode = graph[currentNode][i];
            visits.add(nextNode);
            dfs(graph, nextNode, visits);
            visits.remove(visits.size() - 1);
        }
    }
}
