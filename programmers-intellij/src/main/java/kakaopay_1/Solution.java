package kakaopay_1;

public class Solution {
    public int solution(String phone_number) {
        int answer = 0;

        String[] splitted = phone_number.split("-");

        if(splitted.length == 1) {
            if(splitted[0].startsWith("010")) {
                return 2;
            }
        } else if(splitted.length == 3) {
            if(splitted[0].equals("010") && splitted[1].length() == 4 && splitted[2].length() == 4) {
                return 1;
            }
        } else if(splitted.length == 4) {
            if(splitted[0].equals("+82") && splitted[1].equals("10") && splitted[2].length() == 4 && splitted[3].length() == 4) {
                return 3;
            }
        }
        return -1;
    }
}
