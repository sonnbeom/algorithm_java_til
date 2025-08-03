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
        arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < t; i++){

        }
        if (arr[0] == 0) dp[0][w] = 1;
        else dp[0][w] = 1;

        func(0,w,0);
        func(0,w,1);
        System.out.println(Arrays.deepToString(dp));

    }
    static int switchNum(int i){
        if (i == 1) return 2;
        else return 1;
    }
    // rest는 무빙 남은 횟수 now는 현재 위치
    static void func(int idx, int rest, int now){
        if (idx >= t-1) return;
        System.out.println("idx: "+ idx);
        // rest가 1보다 큰 경우

        // rest가 1보다 작은 경우
        //현재 위치 일치
        if (arr[idx+1] == now){
            // 안 움직인다.
            dp[idx+1][rest] = Math.max(dp[idx+1][rest], dp[idx][rest]+1);
            func(idx+1, rest, now);
            // 움직인다.
            if (rest > 1){
                dp[idx+1][rest-1] = Math.max(dp[idx][rest]+1, dp[idx+1][rest-1]);
                func(idx+1, rest-1, switchNum(now));
            }
        } else if (arr[idx+1] != now) {
            dp[idx+1][rest] = Math.max(dp[idx+1][rest], dp[idx][rest]);
            func(idx+1, rest, now);
            if (rest > 1){
                dp[idx+1][rest-1] = Math.max(dp[idx][rest], dp[idx+1][rest-1]);
                func(idx+1, rest-1, switchNum(now));
            }
        }

//        if (rest > 1){
//            if (arr[idx+1] == now){
//                dp[idx+1][rest] = Math.max(dp[idx][rest]+1, dp[idx+1][rest]);
//            }
//            else {
//                dp[idx+1][rest-1] = Math.max(dp[idx][rest]+1, dp[idx+1][rest-1]);
//            }
//        }
//        else {
//            if (arr[idx+1] == now){
//                dp[idx+1][rest] = Math.max(dp[idx+1][rest], dp[idx][rest]+1);
//            }
//            else {
//                dp[idx+1][rest] = Math.max(dp[idx+1][rest], dp[idx][rest]+1);
//
//            }
//        }

    }
}
