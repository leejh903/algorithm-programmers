package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prize {
    private int matchCnt;
    private boolean bonus;
    private static Map<Prize, Integer> matcher = new HashMap<>();

    static {
        matcher.put(new Prize(6, false), 1);
        matcher.put(new Prize(5, true), 2);
        matcher.put(new Prize(5, false), 3);
        matcher.put(new Prize(4, false), 4);
        matcher.put(new Prize(3, false), 5);
    }

    static int matchRank(int matchCnt, boolean bonus) {
        if(matchCnt != 5) {
            return matcher.get(new Prize(matchCnt, false));
        }
        return matcher.get(new Prize(matchCnt, bonus));
    }

    Prize(int matchCnt, boolean bonus) {
        this.matchCnt = matchCnt;
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return matchCnt == prize.matchCnt &&
                bonus == prize.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCnt, bonus);
    }

}
