package p17682;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] value = new int[3];
        String[][] result = split(dartResult, value);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if(result[i][j] == null) break;
                String temp = result[i][j];
                if(temp.equals("D")) value[i] = (int)Math.pow(value[i], 2);
                else if(temp.equals("T")) value[i] = (int)Math.pow(value[i], 3);
                else if(temp.equals("*")) {
                    value[i] = value[i] * 2;
                    if(i >= 1) value[i - 1] = value[i - 1] * 2;
                }else if(temp.equals("#")) {
                    value[i] = value[i] * (-1);
                }
            }
        }

        for (int i : value) {
            answer += i;
        }

        return answer;
    }

    public String[][] split(String dartResult, int[] value) {
        char[] splitted = dartResult.toCharArray();
        String[][] result = new String[3][2];
        int i = -1; int j = 0;
        for (int c = 0; c < splitted.length; c++) {
            if(splitted[c] >= '0' && splitted[c] <= '9') {
                if(splitted[c+1] == '0') {
                    i++; j = 0;
                    value[i] = 10;
                    c++;
                    continue;
                }
                i++; j = 0;
                value[i] = splitted[c] - '0';
                continue;
            }
            result[i][j] = String.valueOf(splitted[c]);
            j++;
        }
        return result;
    }
}
