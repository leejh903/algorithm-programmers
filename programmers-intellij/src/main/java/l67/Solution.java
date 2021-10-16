package l67;

import java.util.Stack;

class Solution {
	public String addBinary(String a, String b) {
		Stack<String> stack = new Stack<>();

		if (b.length() > a.length()) {
			String temp = a;
			a = b;
			b = temp;
		}

		int upper = 0;
		for (int i = 0; i < a.length(); i++) {
			int aa = a.charAt(a.length() - 1 - i) - '0';

			int bb = 0;
			if (b.length() - 1 - i >= 0) {
				bb = b.charAt(b.length() - 1 - i) - '0';
			}
			int sum = aa + bb + upper;
			stack.push(Integer.toString(sum % 2));
			upper = sum / 2;
		}
		if (upper == 1) {
			stack.push("1");
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
