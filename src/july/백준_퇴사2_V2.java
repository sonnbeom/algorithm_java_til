package july;
import java.util.*;

public class 백준_퇴사2_V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 2]; // n+1까지 고려

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            // 이전까지의 최대 수익을 갱신
            dp[i] = Math.max(dp[i], dp[i - 1]);
            // 상담이 끝나는 날에 이익을 반영
            if (i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }

        // 최대 수익 출력
        System.out.println(Math.max(dp[n], dp[n + 1]));
    }
}
