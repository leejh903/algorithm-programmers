package l71;

import java.util.Stack;

class Solution {
	public String simplifyPath(String path) {
		String[] splitted = path.split("/");

		Stack<String> stack = new Stack<>();
		for (String s : splitted) {
			switch (s) {
				case "..": {
					if (!stack.isEmpty()) {
						stack.pop();
					}
					break;
				}
				case ".":
				case "": {
					break;
				}
				default: {
					stack.add(s);
				}
			}
		}

		if (stack.isEmpty()) {
			return "/";
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.pop());
		}
		return sb.toString();
	}
}
