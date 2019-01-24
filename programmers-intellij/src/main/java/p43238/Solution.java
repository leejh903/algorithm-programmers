package p43238;

class Solution {
    public int solution(int n, int[] times) {
        int max = 0;
        for (int time : times) {
            if(time > max) max = time;
        }

        long low = 1;
        long high = max * n;

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long count = passCount(mid, times);
            if (count < n) low = mid;
            else high = mid;
        }

        if(passCount(low, times) >= n) return (int)low;
        return (int)high;
    }


    public long passCount(long mid, int[] times) {
        long count = 0;
        for (int time : times) {
            if (time > mid) continue;
            count += (mid / time);
        }
        return count;
    }
}