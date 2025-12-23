package December;
import java.util.*;
import java.io.*;
public class BOJ_줄세우기 {
    static int[] line;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        line = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(br.readLine());
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (line[j] < line[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N - max);
    }
}
