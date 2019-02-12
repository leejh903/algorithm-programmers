package p17676;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() throws ParseException {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        assertThat(problem.solution(lines)).isEqualTo(1);
    }

    @Test
    public void test2() throws ParseException {
        String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        assertThat(problem.solution(lines)).isEqualTo(2);
    }

    @Test
    public void split() throws ParseException {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<Long> list = new ArrayList<>();
        for (String line : lines) {
            String[] splittedLine = line.split(" ");
            list.add(dateFormat.parse(splittedLine[0] + " " + splittedLine[1]).getTime());
        }

        System.out.println(list.get(1) - list.get(0));

    }
}