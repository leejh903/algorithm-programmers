package p42883;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void greedySelect() {
        String number = "4177252841";
        int k = 4;

        List<Character> index = new ArrayList();
        for (int i = 0; i < number.length(); i++) {
            index.add(number.charAt(i));
        }
    }
}