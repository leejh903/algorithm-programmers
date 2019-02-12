package p17678;

import java.time.LocalTime;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<LocalTime> queue = init(timetable);

        LocalTime shuttleTime = LocalTime.of(9, 0);
        LocalTime temp = shuttleTime;
        int remainingSeat = m;
        int remainingBus = n - 1;
        while (!queue.isEmpty()) {
            temp = queue.peek();
            if (remainingSeat > 0 && shuttleTime.compareTo(temp) >= 0) {
                // can board, 셔틀 시간보다 작은 값
                remainingSeat--;
                queue.poll();
                continue;
            }

            // cannot board, 셔틀 시간보다 큰 값
            if (remainingBus == 0) break;
            shuttleTime = shuttleTime.plusMinutes(t);
            remainingBus--;
            remainingSeat = m;
        }

//        System.out.println("shuttleTime : " + shuttleTime);
//        System.out.println("remainingSeat : " + remainingSeat);
//        System.out.println("remainingBus : " + remainingBus);

//        while (remainingBus > 0) {
//            shuttleTime = shuttleTime.plusMinutes(t);
//            remainingBus--;
//            remainingSeat = m;
//        }
        if (remainingSeat > 0) return shuttleTime.toString();
        else return temp.minusMinutes(1).toString();
    }

    Queue<LocalTime> init(String[] timetable) {
        Queue<LocalTime> timeList = new PriorityQueue<>();
        for (String s : timetable) {
            String[] splitted = s.split(":");
            if (splitted[0].equals("24")) splitted[0] = "00";
            timeList.offer(LocalTime.of(Integer.parseInt(splitted[0]),
                    Integer.parseInt(splitted[1])));
        }
        return timeList;
    }
}
