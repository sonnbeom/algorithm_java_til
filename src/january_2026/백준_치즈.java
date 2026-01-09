package january_2026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_치즈 {
    static boolean[][] visited;
    static int rest, n, m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,1,-1};
    static int[][] chz;
    static List<int[]> storage;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chz = new int[n][m];
        rest = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                chz[i][j] = input;
                if (input == 1) rest++;
            }
        }

        int cnt = 0;
        int last = 0;
        while (rest > 0){
            visited = new boolean[n][m];
            storage = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && chz[i][j] == 0){
                        func(i, j);
                    }
                }
            }
            int melt = 0;
            for (int i = 0; i < storage.size(); i++) {
                int[]p = storage.get(i);
                int y = p[0]; int x = p[1];
                chz[y][x] = 0;
                melt++;
                rest--;
            }
            cnt++;
            if (rest == 0) last = melt;
        }
        System.out.println(cnt);
        System.out.println(last);

    }
    static void func(int sy, int sx){
        visited[sy][sx] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sy, sx});
        boolean isIn = true;
        List<int[]> tempStorage = new ArrayList<>();
        // 빈 공간에서 돌고 치즈를 만나면 q에는 넣지 않기 빈공간이면 넣기
        while (!q.isEmpty()){
            int[] pair = q.poll();
            int y = pair[0];
            int x = pair[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m){
                    if (!visited[ny][nx] && chz[ny][nx] == 0){
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    } else if (!visited[ny][nx] && chz[ny][nx] == 1) {
                        tempStorage.add(new int[]{ny,nx});
                        visited[ny][nx] = true;
                    }
                    if (ny == n || nx == m || ny == 0 || nx == 0){
                        isIn = false;
                    }
                }
            }
        }
        if (!isIn){
            for(int[] pair: tempStorage){
                storage.add(pair);
            }
        }

    }
}
