package p17686;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void parse() {
        String fileData = "foo010bar020.zip";
        File file = problem.parse(fileData);
        System.out.println(file);
    }

    @Test
    public void parse2() {
        String fileData = "F-15";
        File file = problem.parse(fileData);
        System.out.println(file);
    }

    @Test
    public void parse3() {
        String fileData = "foo9.txt";
        File file = problem.parse(fileData);
        System.out.println(file);
    }

    @Test
    public void parse4() {
        String fileData = "foo9";
        File file = problem.parse(fileData);
        System.out.println(file);
    }

    @Test
    public void test() {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        problem.solution(files);
    }

    @Test
    public void test2() {
        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        problem.solution(new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"});
    }
}