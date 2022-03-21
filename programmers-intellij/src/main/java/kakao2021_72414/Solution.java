package kakao2021_72414;

import java.util.Arrays;

class Solution {
	public String solution(String play_time, String adv_time, String[] logs) {
		int playTime = convertToSecond(play_time);
		int advTime = convertToSecond(adv_time);

		if (playTime <= advTime)
			return "00:00:00";

		Program[] programs = new Program[logs.length];
		for (int i = 0; i < logs.length; i++) {
			String[] splitted = logs[i].split("-");
			programs[i] = new Program(splitted[0], splitted[1]);
		}
		Arrays.sort(programs);

		long max = 0;
		String answer = "";
		for (int i = 0; i < programs.length; i++) {
			int advStartTime = programs[i].getStartTime();
			int advEndTime = programs[i].getStartTime() + advTime < playTime
					? programs[i].getStartTime() + advTime
					: playTime;
			long sum = 0;

			for (int j = 0; j < programs.length; j++) {
				if (advStartTime >= programs[j].getEndTime())
					continue;
				if (advEndTime <= programs[j].getStartTime())
					break;
				sum += programs[j].overlappedTime(advStartTime, advEndTime);
			}

			if (sum > max) {
				max = sum;
				answer = Solution.convertToTimeFormat(programs[i].getStartTime());
			}
		}
		return answer;
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


class Program implements Comparable<Program> {
	private int startTime;
	private int endTime;

	public Program(String startTimeStr, String endTimeStr) {
		this.startTime = Solution.convertToSecond(startTimeStr);
		this.endTime = Solution.convertToSecond(endTimeStr);
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int overlappedTime(int advStartTime, int advEndTime) {
		if (advStartTime >= this.endTime)
			return 0;
		if (advEndTime <= this.startTime)
			return 0;

		int start = advStartTime > this.startTime ? advStartTime : this.startTime;
		int end = advEndTime < this.endTime ? advEndTime : this.endTime;
		return end - start;
	}


	@Override
	public int compareTo(Program p) {
		if (this.startTime > p.startTime) {
			return 1;
		} else if (this.startTime == p.startTime) {
			if (this.endTime > p.endTime) {
				return 1;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Program [startTime=" + startTime + ", " + "endTime=" + endTime + "]";
	}

}
