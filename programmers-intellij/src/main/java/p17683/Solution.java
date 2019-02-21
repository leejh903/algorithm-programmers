package p17683;

import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Song> answer = new ArrayList<>();
        List<Song> list = init(musicinfos);

        for (Song song : list) {
            if (matchCheck(m, song.notes)) answer.add(song);
        }

        Collections.sort(answer);
        if (answer.isEmpty()) return "(None)";
        return answer.get(0).name;
    }

    private List<Song> init(String[] musicinfos) {
        List<Song> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] splittedInfo = musicinfos[i].split(",");
            list.add(new Song(i + 1, timeDifference(splittedInfo[0], splittedInfo[1]), splittedInfo[2], splittedInfo[3]));
        }
        return list;
    }

    public int timeDifference(String time1, String time2) {
        int[] splittedTime1 = split(time1);
        int[] splittedTime2 = split(time2);
        LocalTime localTime1 = LocalTime.of(splittedTime1[0], splittedTime1[1]);
        LocalTime localTime2 = LocalTime.of(splittedTime2[0], splittedTime2[1]);
        return (int) localTime1.until(localTime2, MINUTES);
    }

    private int[] split(String time) {
        int[] output = new int[2];
        String[] splittedTime = time.split(":");
        output[0] = Integer.parseInt(splittedTime[0]);
        output[1] = Integer.parseInt(splittedTime[1]);
        return output;
    }

    public boolean matchCheck(String m, String n) {
        Queue<Integer> start = getStartTime(m, n);
        while (!start.isEmpty()) {
            int mPointer = 0;
            int nPointer = start.poll();
            int min = Math.min(m.length(), n.length());
            for (int i = 0; i < min; i++) {
                if (m.charAt(mPointer) != n.charAt(nPointer)) break;
                if(hasSharp(m, mPointer) || hasSharp(n, nPointer)) {
                    mPointer++;
                    nPointer++;
                    if (mPointer >= m.length()) mPointer = 0;
                    if (nPointer >= n.length()) nPointer = 0;
                    if (m.charAt(mPointer) != n.charAt(nPointer)) break;
                }
                mPointer++;
                nPointer++;
                if (mPointer >= m.length()) mPointer = 0;
                if (nPointer >= n.length()) nPointer = 0;
                if (i == min - 1) return true;
            }
        }
        return false;
    }

    private boolean hasSharp(String m, int pointer) {
        return m.length() - 1 != pointer && m.charAt(pointer + 1) == '#';
    }

    private Queue<Integer> getStartTime(String m, String n) {
        Queue<Integer> start = new LinkedList<>();
        char target = m.charAt(0);
        for (int i = 0; i < n.length(); i++) {
            if (target == n.charAt(i)) {
                start.offer(i);
            }
        }
        return start;
    }
}

class Song implements Comparable<Song> {
    int index;
    int playTime;
    String name;
    String notes;

    public Song(int index, int playTime, String name, String notes) {
        this.index = index;
        this.playTime = playTime;
        this.name = name;
        this.notes = notes;
    }

    @Override
    public int compareTo(Song o) {
        if (o.playTime == playTime) {
            return index - o.index;
        }
        return o.playTime - playTime;
    }

    @Override
    public String toString() {
        return "Song{" +
                "index=" + index +
                ", playTime=" + playTime +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
