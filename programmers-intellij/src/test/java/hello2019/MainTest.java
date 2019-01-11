package hello2019;

import org.junit.Test;

import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class MainTest {
    Main main = new Main();

    @Test
    public void test() {
        String test = "2H 4C TH JH AD";
        StringTokenizer stk = new StringTokenizer(test);
        while(stk.hasMoreTokens()){
            System.out.println(stk.nextToken());
        }
    }
}