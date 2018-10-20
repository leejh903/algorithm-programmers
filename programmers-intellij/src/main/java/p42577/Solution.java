package p42577;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> phoneBook = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(phoneBook);
        for (int i = 1; i < phoneBook.size(); i++) {
            String back = phoneBook.get(i);
            if(phoneBook.get(i).length() > phoneBook.get(i-1).length()) {
                back = phoneBook.get(i).substring(0, phoneBook.get(i-1).length());
            }
            if(back.equals(phoneBook.get(i-1))){
                answer = false;
            }
        }
        return answer;
    }
}
