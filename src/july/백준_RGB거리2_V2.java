package july;

import  java.util.*;
public class 백준_RGB거리2_V2 {
    static int[][] arr;
    static int[][] dp;
    static int n;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        min = Integer.MAX_VALUE;
        for (int start = 0; start < 3; start++){
            dp = new int[n][3];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][start] = arr[0][start];
            func(start,1, start);
        }

        System.out.println(min);

    }
    static void func(int past, int depth, int start){

        if (depth == n-1){
            decideLastIndex(past, depth, start);
            return;
        }
        for (int next = 0; next < 3; next++){
            if (next != past){
                int nextCost = dp[depth-1][past] + arr[depth][next];
                if (nextCost < dp[depth][next]){
                    dp[depth][next] = nextCost;
                    func(next, depth+1, start);
                }
            }
        }

    }
    static void decideLastIndex(int past, int depth, int start){
        for (int last = 0; last < 3 ; last++) {
            if (last != past && last != start){
                dp[depth][last] = Math.min(dp[depth][last], dp[depth-1][past] + arr[depth][last]);
                min = Math.min(min, dp[depth][last]);
            }
        }
    }
}
