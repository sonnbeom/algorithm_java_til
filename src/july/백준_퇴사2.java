package july;
import java.util.*;
public class 백준_퇴사2 {
    static int[] dp;
    static int n;
    static List<pair> list;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList<>();
        dp = new int[n];


        for (int i = 0; i < n; i++){
            int d = sc.nextInt();
            int p = sc.nextInt();
            list.add(new pair(d,p));
        }
        func(0, 0);
        int max = 0;
        for (int i = 0; i < n; i++){
            if (dp[i] > max){
                max = dp[i];
            }
        }
        System.out.print(max);
    }
    static void func(int cur, int now){
        if (cur >= n){
            return;
        }
        // 한다.
        pair pa = list.get(cur);
        if (pa.day + cur <= n){
            int next = now + pa.profit;
            dp[cur] = Math.max(dp[cur], next);
            if (cur + pa.day <= n){
                if (cur+pa.day < n && dp[cur+pa.day] < next){
                    func(cur+pa.day, next);
                }
                //func(cur+pa.day, next);
            }
            // 위 if 문 없이
            //               func(cur+pa.day, next);
        }
        // 안한다.
        if (cur + 1 < n && dp[cur+1] <= now){
            func(cur+1, now);
        }

    }
    public static class pair{
        int day;
        int profit;
        pair(int day, int profit){
            this.day = day;
            this.profit = profit;
        }
    }
}
