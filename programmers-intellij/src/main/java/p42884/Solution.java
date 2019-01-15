package p42884;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<Route> routeList = initRoute(routes);
        Collections.sort(routeList);

        for (Route route : routeList) {
            if(route.checked) continue;
            int start = route.start;

            for (Route route1 : routeList) {
                if(route1.checked == false && start <= route1.end) route1.checked = true;
            }
            answer++;
        }

        return answer;
    }

    private List<Route> initRoute(int[][] routes) {
        List<Route> routeList = new ArrayList<>();
        for (int[] route : routes) {
            if(route[0] > route[1]) {
                int temp = route[0];
                route[0] = route[1];
                route[1] = temp;
            }
            routeList.add(new Route(route[0], route[1], false));
        }
        return routeList;
    }
}

class Route implements Comparable<Route>{
    int start;
    int end;
    boolean checked;

    public Route(int start, int end, boolean checked) {
        this.start = start;
        this.end = end;
        this.checked = checked;
    }

    @Override
    public int compareTo(Route o) {
        return o.start - this.start;
    }

    @Override
    public String toString() {
        return "Route{" +
                "start=" + start +
                ", end=" + end +
                ", checked=" + checked +
                '}';
    }
}
