package p42891;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[] food_times, long k) {
        List<Food> foods = init(food_times);

        Comparator<Food> timeComp = (o1, o2) -> o1.time - o2.time;

        Comparator<Food> indexComp = (o1, o2) -> o1.index - o2.index;

        foods.sort(timeComp);

        int remaining = food_times.length;
        int previous = 0;
        int i = 0;
        for (Food food : foods) {
            long diff = food.time - previous;

            if (diff != 0) {
                long spend = diff * remaining;
                if (spend <= k) {
                    k -= spend;
                    previous = food.time;
                } else {
                    k %= remaining;
                    foods.subList(i, food_times.length).sort(indexComp);
                    return foods.get(i + (int) k).index;
                }
            }
            remaining--;
            i++;
        }

        return -1;
    }

    List<Food> init(int[] food_times) {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }
        return foods;
    }
}

class Food {
    int index;
    int time;

    public Food(int index, int time) {
        this.index = index;
        this.time = time;
    }
}