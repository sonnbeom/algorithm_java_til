package august;

import java.util.*;
public class 백준_회사문화1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n+1];
        int[] people = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            if (a == -1) a = 0;
            people[i] = ++a;

        }
        int[][] praise = new int[m][2];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            praise[i][0] = a;
            praise[i][1] = b;
        }
        Arrays.sort(praise, (a0, a1) -> a0[0]-a1[0]);
        int now = 0;
        for(int i = 0; i < m; i++){
            int idx = praise[i][0];
            int num = praise[i][1];
            now += num;
            dp[idx] = now;
        }
        for (int i = 1; i < n; i++){
            if (dp[i] < dp[i-1]){
                dp[i] = dp[i-1];
            }
        }
        for (int i = 1; i <=n; i++){
            System.out.print(dp[i]+" ");
        }
    }
}
