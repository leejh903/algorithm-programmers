package p17683;

import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Song> answer = new ArrayList<>();
        List<Song> list = init(musicinfos);

        for (Song song : list) {
            if (matchCheck(parse(m), song)) answer.add(song);
        }
        Collections.sort(answer);

        if (answer.isEmpty()) return "(None)";
        return answer.get(0).name;
    }

    private List<Song> init(String[] musicinfos) {
        List<Song> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] splittedInfo = musicinfos[i].split(",");
            list.add(new Song(i + 1, timeDifference(splittedInfo[0], splittedInfo[1]), splittedInfo[2], parse(splittedInfo[3])));
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

    public boolean matchCheck(String m, Song song) {
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (int i = 0; i < song.playTime; i++) {
            j = i % song.notes.length();
            sb.append(song.notes.charAt(j));
        }
        return sb.toString().contains(m);
    }

    public String parse(String s) {
       return s.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
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
