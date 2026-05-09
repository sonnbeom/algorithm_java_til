package may;
import java.util.*;
public class PRG_게임맵최단거리 {

    class Solution {
        static int[] dy = {1,-1,0,0};
        static int[] dx = {0,0,1,-1};
        static boolean[][] visited;
        static int n,m, answer;
        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;
            answer = n*m +1;
            visited = new boolean[n][m];
            visited[0][0] = true;
            dfs(0, 0, 0, maps);
            if (answer == n*m + 1){
                return -1;
            }
            else return answer + 1;
        }
        public static void dfs(int depth, int y, int x, int[][] maps){
            if (depth >= answer) return;
            if (y == n-1 && x == m-1){
                answer = Math.min(depth, answer);

                return;
            }
            for (int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny && ny < n && 0 <= nx && nx < m){
                    if(!visited[ny][nx]){
                        if(maps[ny][nx] == 1){
                            visited[ny][nx] = true;
                            dfs(depth+1, ny, nx, maps);
                            visited[ny][nx] = false;
                        }
                    }
                }

            }

        }
    }

    class SolutionBfs {
        static int[] dy = {1,-1,0,0};
        static int[] dx = {0,0,1,-1};
        static boolean[][] visited;
        static int n,m;
        public int solution(int[][] maps) {
            n = maps.length;
            m = maps[0].length;
            visited = new boolean[n][m];
            visited[0][0] = true;
            return bfs(0, 0, maps);
        }
        public static int bfs(int sy, int sx, int[][] maps){
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{sy, sx,1});
            int answer = Integer.MAX_VALUE;
            while(!q.isEmpty()){
                int[]node = q.poll();
                int y = node[0];
                int x = node[1];
                int d = node[2];
                if(d >= answer) continue;
                if (y == n-1 && x == m-1) {
                    answer = Math.min(answer, d);
                    continue;
                }
                for (int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(0 <= ny && ny < n && 0 <= nx && nx < m){
                        if(!visited[ny][nx] && maps[ny][nx] == 1){
                            q.offer(new int[]{ny,nx,d+1});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
            if (answer == Integer.MAX_VALUE){
                return -1;
            }
            else return answer;
        }
    }
}
