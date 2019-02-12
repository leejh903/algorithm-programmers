package p17678;

import java.time.LocalTime;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<LocalTime> queue = init(timetable);

        LocalTime shuttleTime = LocalTime.of(9, 0);
        LocalTime temp = queue.peek();
        int remainingSeat = m;

        for (int i = 0; i < n; i++) {
            while(!queue.isEmpty() && remainingSeat > 0 && shuttleTime.compareTo(queue.peek()) >= 0) {
                temp = queue.poll();
                remainingSeat--;
            }

            if(i + 1 < n) {  // 버스가 더 남아있다
                shuttleTime = shuttleTime.plusMinutes(t);
                remainingSeat = m;
            }
        }

        if (remainingSeat > 0) return shuttleTime.toString();
        else return temp.minusMinutes(1).toString();
    }

    Queue<LocalTime> init(String[] timetable) {
        Queue<LocalTime> timeList = new PriorityQueue<>();

        for (String s : timetable) {
            String[] splitted = s.split(":");
            if (splitted[0].equals("24")) splitted[0] = "00";
            LocalTime time = LocalTime.of(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]));
            timeList.offer(time);
        }
        return timeList;
    }
}
