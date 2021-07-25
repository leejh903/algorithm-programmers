package p12980;


public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n != 1) {
            if(n % 2 == 1) {
                n--;
                ans++;
            }
            n /= 2;
        }
        return ans + 1;
    }
}