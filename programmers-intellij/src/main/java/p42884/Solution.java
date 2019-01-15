package p42884;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<Route> routeList = initRoute(routes);
        Collections.sort(routeList);

        while(!routeList.isEmpty()) {
            int position = 0;
            int max = 0;
            Route route = routeList.get(0);
            for (int i = route.start; i <= route.end; i++) {
                int encountNum = 0;
                for (Route targetRoute : routeList) {
                    if(targetRoute.start <= i && i <= targetRoute.end) {
                        encountNum++;
                    }
                }
                if(encountNum > max) {
                    max = encountNum;
                    position = i;
                }
            }

            Iterator<Route> routeIterator = routeList.iterator();
            while(routeIterator.hasNext()) {
                Route mayDeletedRoute = routeIterator.next();
                if(mayDeletedRoute.start <= position && position <= mayDeletedRoute.end) {
                    routeIterator.remove();
                }
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
            routeList.add(new Route(route[0], route[1], route[1] - route[0]));
        }
        return routeList;
    }
}

class Route implements Comparable<Route>{
    int start;
    int end;
    int length;

    public Route(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    @Override
    public int compareTo(Route o) {
        return o.length- this.length;
    }

    @Override
    public String toString() {
        return "Route{" +
                "start=" + start +
                ", end=" + end +
                ", length=" + length +
                '}';
    }
}
