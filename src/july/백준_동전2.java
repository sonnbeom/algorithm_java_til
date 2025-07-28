package july;

import java.util.*;
public class 백준_동전2 {
    static int n;
    static int k;
    static int[] dp;
    static int[] coin;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        answer = Integer.MAX_VALUE;
        coin = new int[n];
        for (int i = 0; i < n; i++){
            coin[i] = sc.nextInt();
        }
        dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        for(int c: coin){
            if (c <= k){
                q.offer(new int[]{1, c});
            }
        }
        while (!q.isEmpty()){
            int[] pair = q.poll();
            int num = pair[0];
            int cost = pair[1];
            if (cost > k){
                continue;
            }
            if (num > answer){
                continue;
            }
            if (cost == k){
                answer = Math.min(answer, num);
            }
            for(int i = 0; i < n; i++){
                int c = coin[i];
                if (num + 1 <= k &&  cost + c <= k && dp[cost + c] > dp[cost] + 1){
                    dp[cost + c] = dp[cost] + 1;
                    q.offer(new int[]{num+1, cost + c});
                }
            }
        }
        if (answer == Integer.MAX_VALUE)System.out.print(-1);

        else System.out.println(answer);
    }
}
