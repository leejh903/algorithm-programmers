package kakao2021_72410;

class Solution {
	public String solution(String new_id) {
		// step1
		new_id = new_id.toLowerCase();

		// step2
		StringBuilder sb = new StringBuilder();
		for (char c : new_id.toCharArray()) {
			if ('a' <= c && c <= 'z') {
				sb.append(c);
			}
			if ('0' <= c && c <= '9') {
				sb.append(c);
			}
			if (c == '-' || c == '_' || c == '.') {
				sb.append(c);
			}
		}
		new_id = sb.toString();

		// step3
		new_id = new_id.replaceAll("\\.{2,}", ".");

		// step4
		if (new_id.startsWith(".")) {
			new_id = new_id.substring(1);
		}
		if (new_id.endsWith(".")) {
			new_id = new_id.substring(0, new_id.length() - 1);
		}

		// step5
		if (new_id.isEmpty()) {
			new_id = "a";
		}

		// step6
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.endsWith(".")) {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}

		// step7
		if (new_id.length() <= 2) {
			char last = new_id.charAt(new_id.length() - 1);
			new_id = new_id + Character.toString(last).repeat(3 - new_id.length());
		}

		return new_id;
	}
}
