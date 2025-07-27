package july;

import java.util.*;
public class 백준_연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }

        if (arr[0] > 0){
            dp[0] = arr[0];
        }

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]+arr[i]);
        }

        int max = -1001;

        for (int d : dp){
            max = Math.max(d, max);
        }
        if (max == 0){
            int answer = -1001;
            for (int a: arr){
                answer = Math.max(answer, a);
            }
            System.out.println(answer);
        }
        else System.out.println(max);

    }
}
