package December;
import java.util.*;

public class BJ_연구소 {
    static int[][] arr;
    static int n;
    static int m;
    static int max;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        max = 0;
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(max);

    }
    static void dfs(int wallCount){
        if (wallCount == 3){
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(wallCount + 1);
                    arr[i][j] = 0;
                }
            }
        }


    }
    static void bfs(){
        Queue<int[]> q  = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] copyArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyArr[i] = arr[i].clone();
        }
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (copyArr[ny][nx] == 0){
                        q.offer(new int[]{ny, nx});
                        copyArr[ny][nx] = 2;
                    }
                }
            }
        }
        checkSafeZone(copyArr);

    }
    static void checkSafeZone(int[][] copyArr){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0){
                    count++;
                }
            }
        }
        max = Math.max(count, max);
    }
}
