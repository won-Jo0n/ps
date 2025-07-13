class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;

        int[] weekdays = new int[7];
        for (int i = 0; i < 7; i++) {
            weekdays[i] = (startday + i - 1) % 7 + 1;
        }

        for (int i = 0; i < n; i++) {
            boolean success = true;

            for (int j = 0; j < 7; j++) {
                int day = weekdays[j];
                if (day == 6 || day == 7) continue;

                int scheduled = schedules[i];
                int log = timelogs[i][j];

                if (!onTime(scheduled, log)) {
                    success = false;
                    break;
                }
            }

            if (success) answer++;
        }

        return answer;
    }

    private boolean onTime(int scheduled, int log) {
        int scheduledMinutes = (scheduled / 100) * 60 + (scheduled % 100);
        int logMinutes = (log / 100) * 60 + (log % 100);
        return logMinutes <= scheduledMinutes + 10;
    }
}
