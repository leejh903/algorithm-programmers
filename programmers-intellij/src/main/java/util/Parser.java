package util;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Integer> parsing(String[] arr1) {
        List<Integer> result = new ArrayList<>();
        for (String s : arr1) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

}
