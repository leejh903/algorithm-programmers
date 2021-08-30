package l58;


class Solution {
    public int lengthOfLastWord(String s) {
	String[] splits = s.split(" ");
	return splits[splits.length - 1].length();
    }
}
