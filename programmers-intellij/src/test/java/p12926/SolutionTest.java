package p12926;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void 아스키코드_검사() {
        char test3 = 'A';
        System.out.println((int)test3);  // 65
        char test4 = 'Z';
        System.out.println((int)test4);  // 90
        char test = 'a';
        System.out.println((int)test);  // 97
        char test2 = 'z';
        System.out.println((int)test2);  // 122
        System.out.println((int)' ');  // 공백은 32
        System.out.println((char)32);
    }

    @Test
    public void 밀어내기() {
        String s = "AB";
        int n = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);

            if(target >= 65 && target <= 90) sb.append((char)((target - 65 + n) % 26 + 65));
            if(target >= 97 && target <= 122) sb.append((char)((target - 97 + n) % 26 + 97));
            if(target == 32) sb.append(target);
        }

        assertThat(sb.toString()).isEqualTo("BC");
    }

    @Test
    public void test1() {
        assertThat(problem.solution("z", 1)).isEqualTo("a");
    }

    @Test
    public void test2() {
        assertThat(problem.solution("a B z", 4)).isEqualTo("e F d");
    }
}