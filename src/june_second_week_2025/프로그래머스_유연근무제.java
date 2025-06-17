package june_second_week_2025;

public class 프로그래머스_유연근무제 {
}
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int seq = 0;
        for(int s: schedules){
            boolean lateCheck = true;
            int today = startday;
            int goal = decideTime(s);
            int [] timelog = timelogs[seq];
            for(int time: timelog){
                if (!isWeekday(today)){
                    if (goal < time){
                        lateCheck = false;
                    }
                }

                today = today % 7 + 1;  // 7 다음은 1로 순환
            }
            seq += 1;
            if (lateCheck == true){
                answer += 1;
            }
        }

        return answer;
    }
    static boolean isWeekday(int day){
        if (day == 6 || day == 7){
            return true;
        }
        else{
            return false;
        }
    }

    static int decideTime(int time){
        int hour = time / 100;
        int min = time % 100;

        min += 10;

        if (min >= 60){
            min -= 60;
            hour += 1;
        }
        if (hour >= 24) {
            hour = 0;
        }

        return hour * 100 + min;
    }
}