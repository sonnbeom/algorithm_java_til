package December;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_맥주어쩌구 {
    static int[][] arr;
    static int n;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int u = 0; u < t; u++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+2][2];
            visited = new boolean[n+2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][0] = Integer.parseInt(st.nextToken());
            arr[0][1] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            arr[n+1][0] = Integer.parseInt(st.nextToken());
            arr[n+1][1] = Integer.parseInt(st.nextToken());

            System.out.println(bfs());

        }

    }
    static String bfs(){
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()){
            int now = q.poll();
            if(now == n+1){
                return "happy";
            }
            for (int i = 0; i < n+2; i++) {
                if (!visited[i]){
                    int diff = Math.abs(arr[now][0] - arr[i][0]) + Math.abs(arr[now][1] - arr[i][1]);
                    if (diff <= 1000){
                        visited[i] = true;
                        q.add(i);
                    }
                }

            }
        }
        return "sad";
    }
}
