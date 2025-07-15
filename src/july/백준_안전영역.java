package july;

import java.util.*;

public class 백준_안전영역 {
    static int[][] land;
    static int n;
    static int max;
    static int[] dy = {-1, 1, 0 ,0};
    static int[] dx = {0, 0, 1 ,-1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        max = 0;
        land = new int[n][n];
        int response = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < n; j++){
                int input = sc.nextInt();
                land[i][j] = input;
                // 최고 높이를 알고 0부터 최고 높이까지 반목문을 돌면 된다.
                max = Math.max(input, max);
            }
        }
        for (int i = 0; i < max; i++){
            visited = new boolean[n][n];
            int tempCount = 0;

            for (int y = 0; y < n; y++){
                for (int x = 0; x < n; x++){
                    if (!visited[y][x] &&  land[y][x] > i){
                        bfs(i, y, x);
                        // 안전 지대를 발견하면 카운팅 + 1
                        tempCount += 1;
                    }
                }
            }
            // 높이를 순차적으로 올라가면서 가장 큰 값을 기록
            response = Math.max(tempCount, response);
        }
        System.out.print(response);
    }
    static void bfs(int h, int y, int x){
        // bfs를 할 것이므로 queue를 선택했다.
        Queue<int[]> q = new LinkedList<>();
        //처음 시작된 값 방문처리, q에 넣기
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()){
            int[] pair = q.poll();
            // 델타 탐색
            for (int i = 0; i < 4; i++){
                int ny = pair[0] + dy[i];
                int nx = pair[1] + dx[i];
                // 배열 범위 체크
                if (0 <= nx && nx < n  && 0<= ny && ny< n){
                    // 높이보다 크다면! 즉 같은 안전지대라면 방문 체크, 큐에 넣기
                    if (!visited[ny][nx] && land[ny][nx] > h){
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }

    }
}
