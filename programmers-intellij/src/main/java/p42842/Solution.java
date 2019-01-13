package p42842;

class Solution {
    public int[] solution(int brown, int red) {
        int width = red;
        int height = 0;
        while(width >= height) {
            height = red / width;
            if(red % width == 0) {
                int temp = width * 2 + (height + 2) * 2;
                if(temp == brown) break;
            }
            width--;
        }
        return new int[]{width + 2, height + 2};
    }
}
