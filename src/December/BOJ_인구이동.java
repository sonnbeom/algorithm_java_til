package December;

import java.util.*;
import java.io.*;

public class BOJ_인구이동 {
    static int[][] land;
    static int cnt, N, L, R;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};
    static boolean[][] visited;
    static boolean point;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =  Integer.parseInt(st.nextToken());
        L =  Integer.parseInt(st.nextToken());
        R =  Integer.parseInt(st.nextToken());

        land = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            point = false;
            visited = new boolean[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]){
                        visited[y][x] = true;
                        bfs(y, x);
                    }
                }
            }
            if (!point){
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
    static void bfs(int sy, int sx){
        List<int[]> target = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        target.add(new int[]{sy, sx});
        q.add(new int[]{sy, sx});

        int check = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int y = now[0]; int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i]; int nx = x + dx[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N){
                    if (visited[ny][nx]){
                        continue;
                    }
                    int diff = Math.abs(land[ny][nx] - land[y][x]);
                    if (diff >= L && diff <= R){
                        check += 1;
                        target.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < target.size(); i++) {
            int[] temp = target.get(i);
            sum += land[temp[0]][temp[1]];
        }
        sum = sum / target.size();

        for (int i = 0; i < target.size(); i++) {
            int[] temp = target.get(i);
            land[temp[0]][temp[1]] = sum;
        }
        if (check > 0) {
            point = true;

        }
    }
}
