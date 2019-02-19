package p17686;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (String file : files) {
            list.add(parse(file));
        }
        Collections.sort(list);

        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).origin;
        }

        return answer;
    }

    public File parse(String fileData) {
        int numStart = 0;
        int numEnd = 0;
        for (int i = 0; i < fileData.length() - 1; i++) {
            char prev = fileData.charAt(i);
            char after = fileData.charAt(i + 1);

            if(!isNumber(prev) && isNumber(after)) numStart = i + 1;
            if(isNumber(prev) && !isNumber(after)) {
                numEnd = i;
                break;
            }
        }

        if(numEnd == 0) numEnd = fileData.length() - 1;

        return new File(fileData, fileData.substring(0, numStart).toUpperCase(), Integer.parseInt(fileData.substring(numStart, numEnd + 1)));
    }

    private boolean isNumber(char temp) {
        return temp >= '0' && temp <= '9';
    }
}

class File implements Comparable<File> {
    String origin;
    String head;
    int number;

    public File(String origin, String head, int number) {
        this.origin = origin;
        this.head = head;
        this.number = number;
    }

    @Override
    public String toString() {
        return "File{" +
                "origin='" + origin + '\'' +
                ", head='" + head + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(File o) {
        if(o.head.equals(head)) {
            return number - o.number;
        }
        return head.compareTo(o.head);
    }
}