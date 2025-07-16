package july;

import java.util.*;
public class 백준_ACM_Craft {
    static int[] buildTime;
    static List<Integer>[] edges;
    static int n;
    static int k;
    static int[] inDegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 0; o < t; o++){
            n = sc.nextInt();
            k = sc.nextInt();
            buildTime = new int[n+1];
            edges = new ArrayList[n+1];
            inDegree = new int[n+1];
            for (int i = 1; i <= n; i ++){
                buildTime[i] = sc.nextInt();
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < k; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                edges[from].add(to);
                inDegree[to]++;
            }
            int goal = sc.nextInt();
            int[] dp = new int[n+1];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++){
                dp[i] = buildTime[i];
                if (inDegree[i]==0){
                    q.offer(i);
                }
            }
            while (!q.isEmpty()){
                int now = q.poll();
                for (int next : edges[now]){
                    dp[next] = Math.max(dp[next], dp[now]+buildTime[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0){
                        q.offer(next);
                    }
                }
            }
            System.out.println(dp[goal]);
        }
    }
}

