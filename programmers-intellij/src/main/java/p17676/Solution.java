package p17676;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(String[] lines) throws ParseException {
        int answer = 0;
        List<Process> list = split(lines);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            long endTime = list.get(i).endTime;
            int temp = 0;
            for (Process process : list) {
                if(process.include(endTime)) temp++;
            }
            answer = Math.max(answer, temp);
        }


        return answer;
    }

    List<Process> split(String[] lines) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<Process> list = new ArrayList<>();
        for (String line : lines) {
            String[] splittedLine = line.split(" ");
            long endTime = dateFormat.parse(splittedLine[0] + " " + splittedLine[1]).getTime();
            long startTime = endTime - (long)(Double.parseDouble(splittedLine[2].substring(0, splittedLine[2].length() - 1)) * 1000) + 1;
            list.add(new Process(startTime, endTime));
        }
        return list;
    }
}

class Process implements Comparable<Process>{
    long startTime;
    long endTime;

    public Process(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean include(long target) {
        return startTime <= target && target <= endTime ;
    }

    @Override
    public String toString() {
        return "Prcoess{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(Process o) {
        return (int)(this.startTime - o.startTime);
    }
}
