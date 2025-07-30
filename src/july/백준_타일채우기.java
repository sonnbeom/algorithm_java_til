package july;
import java.util.*;
public class 백준_타일채우기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[31];
        if (n % 2 != 0) System.out.println(0);
        else {
            dp[2] = 3;
            dp[4] = 11;
            for(int i = 6; i <= n; i++){
                if (n % 2 != 0) continue;
                else {
                    dp[i] = dp[i-2] * 4 - dp[i-4];
                }
            }
            System.out.println(dp[n]);
        }

    }
}
