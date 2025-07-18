package july;

import java.util.*;
public class 백준_미로탈출 {
    static int[][] miro;
    static int n;
    static int m;
    static int ty;
    static int tx;
    static boolean[][] visited;
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static int response;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        miro = new int[n][m];
        visited = new boolean[n][m];
        response = 1000 * 1000 + 1;
        int sy = sc.nextInt() - 1;
        int sx = sc.nextInt() - 1 ;
        ty = sc.nextInt() - 1;
        tx = sc.nextInt() - 1;
        for (int y = 0; y < n; y++){
            for (int x = 0; x < m; x++){
                miro[y][x] = sc.nextInt();
            }
        }
        dfs(sy, sx, 0, 1);
        if (response == 1000 * 1000 + 1) System.out.println(-1);
        else System.out.println(response);

    }
    static void dfs(int y, int x, int cnt, int chance){
       // System.out.println("y: " + y + "x: " + x + "cnt: " + cnt + "chance: "+ chance );
        if (cnt > response){
            return;
        }
        if (y == ty && x == tx){
//            System.out.println("IS COME y = " + y +"x = " + x +"cnt= "+ cnt + "chance="+ chance );
            response = Math.min(response, cnt);
            return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < n && 0 <= nx && nx < m){
                if (!visited[ny][nx]){
                    if (miro[ny][nx] == 0){
                        dfs(ny, nx, cnt+1, chance);
                        visited[ny][nx] = false;
                    }
                    else if(miro[ny][nx]==1 && chance > 0){
                        dfs(ny, nx, cnt+1, 0);
                        visited[ny][nx] = false;
                    }
                }
            }
        }

    }
}
