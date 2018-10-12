package p42746;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String solution(int[] numbers) {
        List<String> numbersText = new ArrayList<>();

        for (int number : numbers) {
            numbersText.add(String.valueOf(number));
        }

        Collections.sort(numbersText, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) == o2.charAt(0)) {
                    int aa = Integer.parseInt(o1 + o2);
                    int bb = Integer.parseInt(o2 + o1);
                    return bb-aa;
                }
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : numbersText) {
            sb.append(s);
        }

        return sb.charAt(0) == '0'? "0" : sb.toString();
    }
}
