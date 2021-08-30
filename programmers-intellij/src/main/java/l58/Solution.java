package l58;


class Solution {
	public int lengthOfLastWord(String s) {
	int length = 0;
	for(int i = s.length() - 1; i >= 0; i--){
	    if(s.charAt(i) == ' ' && length == 0) continue;
	    if(s.charAt(i) == ' ' && length != 0) break;
	    length++;
	}
	return length;
    }
}
