package p17681;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];

        String[] array1 = new String[arr1.length];
        String[] array2 = new String[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            array1[i] = toBinary(n, arr1[i]);
            array2[i] = toBinary(n, arr2[i]);
            answer[i] = addBinary(array1[i], array2[i]);
        }
        return answer;
    }

    private String addBinary(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == '0' && s2.charAt(i) == '0') {
                sb.append(" ");
                continue;
            }
            sb.append("#");
        }
        return sb.toString();
    }

    public String toBinary(int num, int i) {
        int n = num - 1;
        StringBuilder sb = new StringBuilder();
        while(n > -1) {
            int divider = (int)Math.pow(2, n);
            if(i < divider) {
                sb.append("0");
            } else {
                sb.append("1");
                i = i % divider;
            }
            n--;
        }
        return sb.toString();
    }
}
