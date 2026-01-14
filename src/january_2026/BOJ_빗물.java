package january_2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_빗물 {
    static int h, w, ans;
    static int[][] arr;
    static boolean[][] visited, rain;
    static int[] dx = {1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new boolean[h][w];
        rain = new boolean[h][w];
        ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int x = Integer.parseInt(st.nextToken());
            for (int j = h - 1; j >= h-x ; j--) {
                arr[j][i] = 1;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 0 && !visited[i][j]){
                    func(i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(rain));
        System.out.println(ans);
    }
    static void func(int sy, int sx){
        ArrayList<int[]>p = new ArrayList<>();
        p.add(new int[]{sy,sx});
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{sy,sx});
        boolean right = false;
        boolean left = false;
        visited[sy][sx] = true;
        while (!q.isEmpty()){
            int[] now = q.poll();
            int y = now[0]; int x = now[1];
            for (int i = 0; i < 2; i++) {
                int nx = dx[i] + x;
                if (0 <= nx && nx < w){
                    if (arr[y][nx] == 0 && !visited[y][nx]){
                        q.add(new int[]{y,nx});
                        visited[y][nx] = true;
                        p.add(new int[]{y,nx});
                    }
                    if (nx == 0 && arr[y][nx] == 1) left = true;
                    if (nx == w-1 && arr[y][nx] == 1) right = true;
                }
            }
        }
        if (right && left){
            for (int[]temp : p){
                int y = temp[0];
                int x = temp[1];
                if (!rain[y][x]){
                    rain[y][x] = true;
                    ans +=1 ;
                }
            }
        }
    }
}

/*
1. 벽이 있는 곳을 1 아닌 곳을 0으로 칠한다.
2. for문을 돌려 방문 처리를 한다.
3. 0일 경우, 왼쪽 오른쪽으로만 탐색한다. 왼쪽 오른쪽에 벽이 있는 경우 그동안의 탐색 횟수를 체크한다. 만약 오른쪽 왼쪽 둘 다 벽이 없다면 리턴
오른쪽 왼쪽 둘 다 벽이 있다면 빗물 체크
4. 출력

3,0 2,0 1,0
1,3.1
 */