package kakao2021_72411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	Map<String, List<Integer>> chosen = new HashMap<>();
	Map<Integer, Integer> answerRecord = new HashMap<>();
	Map<Integer, List<String>> answer = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		for (int i = 0; i < orders.length; i++) {
			String[] foods = orders[i].split("");
			for (String food : foods) {
				List<Integer> who = chosen.getOrDefault(food, new ArrayList<>());
				who.add(i);
				chosen.put(food, who);
			}
		}

		String[] foods = new String[chosen.size()];
		int i = 0;
		for (String key : chosen.keySet()) {
			foods[i] = key;
			i++;
		}

		for (int count : course) {
			combination(foods, new boolean[foods.length], 0, foods.length, count, count);
		}

		List<String> output = new ArrayList<>();
		for (int key : answer.keySet()) {
			output.addAll(answer.get(key));
		}
		Collections.sort(output);
		return output.toArray(new String[answer.size()]);
	}

	void combination(String[] arr, boolean[] visited, int start, int n, int r, int target) {
		if (r == 0) {
			int[] records = new int[20];
			String[] foods = new String[target];
			int index = 0;
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i])
					continue;

				foods[index] = arr[i];
				index++;
				List<Integer> who = chosen.get(arr[i]);
				for (int whoNum : who) {
					records[whoNum]++;
				}
			}

			int courseSelected = 0;
			for (int i = 0; i < records.length; i++) {
				if (records[i] == target)
					courseSelected++;
			}

			if (courseSelected >= 2) {
				int selected = answerRecord.getOrDefault(target, courseSelected);
				if (courseSelected < selected) {
					return;
				}

				Arrays.sort(foods);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < foods.length; i++) {
					sb.append(foods[i]);
				}

				String current = sb.toString();
				List<String> chosen = new ArrayList<>();
				if (courseSelected == selected) {
					chosen = answer.getOrDefault(target, new ArrayList<>());
				}
				chosen.add(current);
				answer.put(target, chosen);
				answerRecord.put(target, courseSelected);
			}
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1, target);
			visited[i] = false;
		}
	}
}
