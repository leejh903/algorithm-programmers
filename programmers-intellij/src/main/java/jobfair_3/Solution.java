package jobfair_3;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] healths, int[][] items) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> heals = Arrays.stream(healths).boxed().collect(Collectors.toList());
        Queue<Item> itemQ = init(items);

        Collections.sort(heals);
        while (!heals.isEmpty() && !itemQ.isEmpty()) {
            ListIterator<Integer> iterator = heals.listIterator();
            Item item = itemQ.poll();

            while (iterator.hasNext()) {
                int heal = iterator.next();
                if (heal - item.lifeDown >= 100) {
                    answer.add(item.index);
                    iterator.remove();
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public Queue<Item> init(int[][] items) {
        Queue<Item> queue = new PriorityQueue<>();
        for (int i = 1; i <= items.length; i++) {
            queue.offer(new Item(i, items[i - 1][0], items[i - 1][1]));
        }
        return queue;
    }
}

class Item implements Comparable<Item> {
    int index;
    int attackUp;
    int lifeDown;

    public Item(int index, int attackUp, int lifeDown) {
        this.index = index;
        this.attackUp = attackUp;
        this.lifeDown = lifeDown;
    }

    @Override
    public int compareTo(Item o) {
        return o.attackUp - attackUp;
    }
}