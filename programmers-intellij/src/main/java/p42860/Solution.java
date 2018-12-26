package p42860;

class Solution {
    public static final char A = 'A';
    public String target;
    public int answer;

    public int solution(String name) {
        answer = Integer.MAX_VALUE;
        StringBuilder changingText = new StringBuilder(name);
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            target.append(A);
        }
        this.target = target.toString();

        dfs(changingText, 0, 0);

        if (answer == Integer.MAX_VALUE) return 0;

        return answer;

    }

    public void dfs(StringBuilder changingText, int count, int curIndex) {
        if (isSame(changingText)) {
            answer = Math.min(answer, count);
            return;
        }

        char data = changingText.charAt(curIndex);
        if (data != A) {
            count += minChangeCount(data);
            changingText.setCharAt(curIndex, A);
        }

        if (!isSame(changingText)) {
            dfs(changingText, ++count, ++curIndex);
        }
    }

    private boolean isSame(StringBuilder changingText) {
        return changingText.toString().equals(target);
    }

    public int minChangeCount(char data) {
        return Math.min(data - A, 'Z' - data + 1);
    }
}
