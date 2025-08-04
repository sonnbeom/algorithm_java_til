package august;
import java.util.*;
public class 백준_보물섬 {
    static int r;
    static int c;
    static boolean[][] visited;
    static String[][] map;
    static int answer;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] storage;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new String[r][c];
        answer = -1;
        for(int i = 0; i < r; i++){
            String input = sc.next();
            for(int j = 0; j < input.length(); j++){
                String t = String.valueOf(input.charAt(j));
                map[i][j] = t;
            }
        }
        storage = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if (map[i][j].equals("L")) {
                    visited = new boolean[r][c];
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }
    static void bfs(int y, int x){
        Queue<Pair> q = new LinkedList<>();
        int max = 0;
        q.offer(new Pair(y,x,0));
        visited[y][x] = true;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            max = Math.max(max, pair.d);
            for(int i = 0; i < 4; i++){
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];
                if (0 <= ny && ny < r && 0 <= nx && nx < c){
                    if (map[ny][nx].equals("L") && !visited[ny][nx]){
                        q.offer(new Pair(ny,nx,pair.d+1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        answer = Math.max(answer, max);
    }
    static class Pair{
        int y;
        int x;
        int d;
        Pair(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
