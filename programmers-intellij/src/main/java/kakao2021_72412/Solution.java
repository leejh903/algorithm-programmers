package kakao2021_72412;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Solution {
	private List<Developer> developers = new ArrayList<>();

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		for (String i : info) {
			String[] splitted = i.split(" ");
			int score = Integer.parseInt(splitted[4]);
			developers
					.add(new Developer(splitted[0], splitted[1], splitted[2], splitted[3], score));
		}

		for (int i = 0; i < query.length; i++) {
			String[] splitted = query[i].split(" ");
			Stream<Developer> stream = developers.stream();
			int checkIndex = 0;
			for (String q : splitted) {
				if (q.equals("and"))
					continue;
				if (q.equals("-")) {
					checkIndex++;
					continue;
				}

				switch (checkIndex) {
					case 0:
						stream = stream.filter(d -> d.language.equals(q));
						break;
					case 1:
						stream = stream.filter(d -> d.category.equals(q));
						break;
					case 2:
						stream = stream.filter(d -> d.proficiency.equals(q));
						break;
					case 3:
						stream = stream.filter(d -> d.soulFood.equals(q));
						break;
					case 4:
						int criteria = Integer.parseInt(q);
						stream = stream.filter(d -> d.score >= criteria);
				}
				checkIndex++;
			}
			answer[i] = (int) stream.count();
		}
		return answer;
	}

	class Developer {
		private String language;
		private String category;
		private String proficiency;
		private String soulFood;
		private int score;

		public Developer(String language, String category, String proficiency, String soulFood,
				int score) {
			this.language = language;
			this.category = category;
			this.proficiency = proficiency;
			this.soulFood = soulFood;
			this.score = score;
		}
	}
}
