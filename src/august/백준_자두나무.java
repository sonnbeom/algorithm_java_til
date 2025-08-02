package august;

import java.util.*;

public class 백준_자두나무 {
    static int t;
    static int w;
    static int[][] dp;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        w = sc.nextInt();
        dp = new int[t+1][w+1];
        arr = new int[t+1];
        for (int i = 1; i <= t; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i < t+1; i++){
            for(int j = 0; j <= w; j++){
                int now;
                if (j % 2 == 0) now = 1;
                else now = 2;

                if (j == 0){
                    dp[i][j] = dp[i-1][j];
                    if (arr[i] == 1) dp[i][j]++;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                    if (arr[i] == now) dp[i][j] ++; 
                }
            }
        }
        int answer = 0;
        for(int i = 0; i <= w; i++){
            answer = Math.max(answer, dp[t][i]);
        }
        System.out.println(answer);
//        System.out.println(Arrays.deepToString(dp));

    }



}
