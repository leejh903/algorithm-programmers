package data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTest {

    @Test
    public void test1() {
        Array<Integer> array = new Array<>();
        array.init();
        array.set(0, 1);
        assertThat(array.get(0)).isEqualTo(1);
    }

    @Test
    public void test2() {
        Array<String> array = new Array<>();
        array.init();
        array.set(0, "a");
        assertThat(array.get(0)).isEqualTo("a");
    }

    @Test
    public void test3() {
        Array<String> array = new Array<>();
        array.init();
        array.set(0, "a");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("------------------");
        array.set(4, "b");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("------------------");
        array.set(10, "c");
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("------------------");
    }

    @Test
    public void test4() {
        Array<Integer> array = new Array<>();
        array.init();
        array.set(0, 1);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("------------------");
        array.set(4, 2);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("------------------");
        array.set(10, 3);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("------------------");
    }
}