package kakao2021_72414;

class Solution {
	public String solution(String play_time, String adv_time, String[] logs) {
		int playTime = convertToSecond(play_time);
		int advTime = convertToSecond(adv_time);
		int[] counts = new int[playTime + 1];

		if (playTime <= advTime)
			return "00:00:00";

		for (int i = 0; i < logs.length; i++) {
			String[] splitted = logs[i].split("-");
			int start = convertToSecond(splitted[0]);
			int end = convertToSecond(splitted[1]);

			for (int j = start; j < end; j++) {
				counts[j]++;
			}
		}

		long sum = 0;
		int startTime = 0;
		int endTime = advTime;
		for (int i = startTime; i < endTime; i++) {
			sum += counts[i];
		}

		long max = sum;
		int maxStartTime = 0;
		while (endTime <= playTime) {
			sum -= counts[startTime];
			sum += counts[endTime];
			if (sum > max) {
				max = sum;
				maxStartTime = startTime + 1;
			}
			startTime++;
			endTime++;
		}
		return convertToTimeFormat(maxStartTime);
	}

	static public int convertToSecond(String timeStr) {
		String[] splitted = timeStr.split(":");
		int hour = Integer.parseInt(splitted[0]);
		int minute = Integer.parseInt(splitted[1]);
		int second = Integer.parseInt(splitted[2]);
		return hour * 60 * 60 + minute * 60 + second;
	}

	static public String convertToTimeFormat(int time) {
		int hour = time / 60 / 60;
		time -= hour * 60 * 60;
		int minute = time / 60;
		time -= minute * 60;
		int second = time;
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}
