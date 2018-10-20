package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MIN_SIZE = 0;
    public static final int LOTTO_MAX_SIZE = 45;

    protected List<Integer> lottoNum;

    protected Lotto(List<Integer> lottoNums) {
        lottoNum = checkNum(lottoNums);
    }

    static Lotto init(List<Integer> lottoNums) {
        return new Lotto(lottoNums);
    }

    static List<Integer> checkNum(List<Integer> lottoNums) {
        isDuplicated(lottoNums);
        isOver(lottoNums);
        isOverAmount(lottoNums);

        return lottoNums;
    }

    private static void isOverAmount(List<Integer> lottoNums) {
        if(lottoNums.size() != LOTTO_SIZE){
            System.out.println("is not 6");
            throw new IllegalArgumentException("is not 6");
        }
    }

    private static void isOver(List<Integer> lottoNums) {
        for (Integer integer : lottoNums) {
            if (integer <= LOTTO_MIN_SIZE || integer > LOTTO_MAX_SIZE){
                System.out.println("over");
                throw new IllegalArgumentException("값 초과");
            }
        }
    }

    private static void isDuplicated(List<Integer> lottoNums) {
        Set<Integer> set = new HashSet<>(lottoNums);
        if (lottoNums.size() != set.size()) {
            throw new IllegalArgumentException("같은 값을 입력하셨습니다");
        }
    }

}
