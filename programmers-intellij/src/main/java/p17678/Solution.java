package p17678;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<LocalTime> queue = init(timetable);

        LocalTime shuttleTime = LocalTime.of(9, 0);
        LocalTime temp = queue.peek();
        int remainingSeat = m;

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && remainingSeat > 0 && shuttleTime.compareTo(queue.peek()) >= 0) {
                temp = queue.poll();
                remainingSeat--;
            }

            if (i + 1 < n) {  // 버스가 더 남아있다
                shuttleTime = shuttleTime.plusMinutes(t);
                remainingSeat = m;
            }
        }

        if (remainingSeat > 0) return shuttleTime.toString();
        else return temp.minusMinutes(1).toString();
    }

    Queue<LocalTime> init(String[] timetable) {
        DateTimeFormatter TIMEFORMAT = DateTimeFormatter.ofPattern("HH:mm");
        Queue<LocalTime> timeList = new PriorityQueue<>();
        for (String s : timetable) {
            if(s.equals("24:00")) s = "23:59";
            LocalTime time = LocalTime.parse(s, TIMEFORMAT);
            timeList.offer(time);
        }
        return timeList;
    }
}
