package july;

import java.util.*;
public class 백준_RGB거리2 {
    static int[][] arr;
    static int[][] dp;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 0; i < 3; i++) {
            if (i == 0){
                func(1, 1, 0, 0);
                func(2, 1, 0, 0);
            } else if (i==1) {
                func(0, 1, 1, 1);
                func(2, 1, 1, 1);
            }
            else {
                func(1, 1, 2, 1);
                func(0, 1, 2, 1);
            }
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(dp[n-1][0], dp[n-1][1]);
        min = Math.min(dp[n-1][2], min);
        System.out.println(min);

        System.out.println(Arrays.deepToString(dp));
    }

    static void func(int next, int idx, int past, int start){
        if (idx >= n){
            return;
        }
        if (idx == n-1){
            if (next == 0){
                if (past == 1){
                    if (start == 1){
                        dp[idx][2] = Math.min(dp[idx][2], dp[idx-1][0] + arr[idx][2]);

                    } else if (start == 2) {

                    }

                }
            }
        }
        if (next == 0){
            if (past == 1){
                dp[idx][2] = Math.min(dp[idx][2], dp[idx-1][0] + arr[idx][2]);
                func(2, idx+1, next, start);
            }
            else if (past == 2){
                dp[idx][1] = Math.min(dp[idx][1], dp[idx-1][0] + arr[idx][1]);
                func(1,idx+1, next, start);
            }
        }
        else if (next == 1){
            if (past == 2){
                dp[idx][0] = Math.min(dp[idx][0], dp[idx-1][1] + arr[idx][0]);
                func(0,idx+1, next, start);
            }
            else if(past == 0){
                dp[idx][2] = Math.min(dp[idx][2], dp[idx-1][1] + arr[idx][2]);
                func(2, idx+1, next, start);
            }
        }
        else if (next == 2){
            if (past == 1){
                dp[idx][0] = Math.min(dp[idx][0], dp[idx-1][2] + arr[idx][0]);
                func(0,idx+1, next, start);
            }
            else if (past == 0){
                dp[idx][1] = Math.min(dp[idx][1], dp[idx-1][2] + arr[idx][1]);
                func(1, idx+1, next, start);
            }
        }
    }
}
