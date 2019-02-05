package p17680;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(50);
    }

    @Test
    public void test2() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(21);
    }

    @Test
    public void test3() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(60);
    }

    @Test
    public void test4() {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(52);
    }

    @Test
    public void test5() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(16);
    }

    @Test
    public void test6() {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(25);
    }

    @Test
    public void test6_1() {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "a", "b"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(35);
    }

    @Test
    public void test6_2() {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju", "Jeju"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(30);
    }

    @Test
    public void test7() {
        int cacheSize = 1;
        String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju", "Jeju"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(9);
    }

    @Test
    public void test8() {
        int cacheSize = 0;
        String[] cities = {"Jeju"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(5);
    }

    @Test
    public void test9() {
        int cacheSize = 10;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertThat(problem.solution(cacheSize, cities)).isEqualTo(25);
    }
}