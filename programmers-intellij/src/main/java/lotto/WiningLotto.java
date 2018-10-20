package lotto;

import java.util.List;

class WiningLotto extends Lotto {
    private int bonusNum;

    private WiningLotto(List<Integer> lottoNums, int bonusNum) {
        super(lottoNums);
        this.bonusNum = checkBonusNo(bonusNum);
    }

    static WiningLotto init(List<Integer> lottoNums, int bonusNum) {
        return new WiningLotto(lottoNums, bonusNum);
    }

    private int checkBonusNo(int bonusNum) {
        if (this.lottoNum.contains(bonusNum)) {
            System.out.println("bono!");
            throw new IllegalArgumentException("bono!");
        }
        return bonusNum;
    }

    int isJackpot(Lotto lotto) {
        return Prize.matchRank(matchCount(lotto), bonus(lotto));
    }

    private boolean bonus(Lotto lotto) {
        return lotto.lottoNum.contains(bonusNum);
    }

    private int matchCount(Lotto lotto) {
        int count = 0;
        for (Integer integer : lotto.lottoNum) {
            count += getCount(integer);
        }
        return count;
    }

    private int getCount(Integer integer) {
        if (this.lottoNum.contains(integer)) {
            return 1;
        }
        return 0;
    }

}
