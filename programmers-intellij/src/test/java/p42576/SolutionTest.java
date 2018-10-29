package p42576;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem;

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void 해시_스터디() {
        String[] participant = {"leo", "kiki", "kiki", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Map<String, Integer> hash = new HashMap<>();
        for (String s : participant) {
            if(hash.get(s) == null) {
                hash.put(s, 1);
            } else {
                hash.put(s, hash.get(s) + 1);
            }
        }

        assertThat(hash.get("kiki")).isEqualTo(3);
    }

    @Test
    public void 해시_스터디2() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Map<String, Integer> hash = new HashMap<>();
        for (String s : participant) {
            if(hash.get(s) == null) {
                hash.put(s, 1);
            } else {
                hash.put(s, hash.get(s) + 1);
            }
        }

        for (String s : completion) {
            hash.put(s, hash.get(s) - 1);
            if(hash.get(s) == 0) {
                hash.remove(s);
            }
        }

        assertThat(hash.keySet().toArray()[0]).isEqualTo("leo");
    }

    @Test
    public void 해시_스터디3() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        Map<String, Integer> hash = new HashMap<>();
        for (String s : participant) {
            if(hash.get(s) == null) {
                hash.put(s, 1);
            } else {
                hash.put(s, hash.get(s) + 1);
            }
        }

        for (String s : completion) {
            hash.put(s, hash.get(s) - 1);
            if(hash.get(s) == 0) {
                hash.remove(s);
            }
        }

        assertThat(hash.keySet().toArray()[0]).isEqualTo("vinko");
    }

    @Test
    public void 해시_스터디4() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Map<String, Integer> hash = new HashMap<>();
        for (String s : participant) {
            if(hash.get(s) == null) {
                hash.put(s, 1);
            } else {
                hash.put(s, hash.get(s) + 1);
            }
        }

        for (String s : completion) {
            hash.put(s, hash.get(s) - 1);
            if(hash.get(s) == 0) {
                hash.remove(s);
            }
        }

        assertThat(hash.keySet().toArray()[0]).isEqualTo("mislav");
    }

    @Test
    public void 해시_스터디5() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        assertThat(problem.solution(participant, completion)).isEqualTo("mislav");
    }

    @Test
    public void 문자열_쉼표_붙이기() {
        String s = "stanko, ana, mislav";
        String[] sArray = s.split(",");
        List<String> sList = new ArrayList<>();
        for (int i = 0; i < sArray.length; i++) {
            sList.add("\"" + sArray[i].trim() + "\"");
        }

        System.out.println(Arrays.toString(sList.toArray()));
    }
}