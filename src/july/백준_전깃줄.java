package july;

import java.util.*;

public class 백준_전깃줄 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] lines = new int[n][2];

        for (int i = 0; i < n; i++){
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();
        }
        Arrays.sort(lines, (a0, a1)-> a0[0] - a1[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if(lines[j][1] < lines[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
    }
}
