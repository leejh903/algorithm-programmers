package lotto;

import util.Parser;

public class LottoGame {
    public static final String COMMA = ",";

    public static int match(String inputLottoNum, String winningLottoNum, String bonusNum) {
        String[] inputLottoSplit = inputLottoNum.split(COMMA);
        String[] winningLottoSplit = winningLottoNum.split(COMMA);

        Lotto lotto = Lotto.init(Parser.parsing(inputLottoSplit));
        WiningLotto winingLotto = WiningLotto.init(Parser.parsing(winningLottoSplit), Integer.parseInt(bonusNum));

        return winingLotto.isJackpot(lotto);
    }

}
