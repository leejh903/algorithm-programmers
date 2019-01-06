package p42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> kindsOfClothes = new HashMap<>();
        init(clothes, kindsOfClothes);

        for (List<String> value : kindsOfClothes.values()) {
            answer *= (value.size() + 1);
        }
        return answer - 1;
    }

    private void init(String[][] clothes, Map<String, List<String>> kindsOfClothes) {
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            String name = clothe[0];

            if (!kindsOfClothes.containsKey(kind)) {
                List<String> newKind = new ArrayList<>(Arrays.asList(name));
                kindsOfClothes.put(kind, newKind);
                continue;
            }
            kindsOfClothes.get(kind).add(name);
        }
    }
}
