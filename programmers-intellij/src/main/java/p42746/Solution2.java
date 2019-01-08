package p42746;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution2 {
    public String solution(int[] numbers) {
        List<String> texts = new ArrayList<>();

        for (int number : numbers) {
            texts.add(String.valueOf(number));
        }
        Collections.sort(texts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) == o2.charAt(0)) {
                    int num1 = Integer.valueOf(o1 + o2);
                    int num2 = Integer.valueOf(o2 + o1);
                    return num2 - num1;
                }
                return o2.compareTo(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String text : texts) {
            sb.append(text);
        }

        return sb.charAt(0) == '0'? "0" : sb.toString();
    }
}
