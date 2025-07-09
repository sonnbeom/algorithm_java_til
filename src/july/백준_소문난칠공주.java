package july;

import java.util.*;

public class 백준_소문난칠공주 {
    /**
     * 1. 각 위치 별로 dfs를 실행
     * 2. 7칸을 움직이면서 4명 체크
     * 3. 호출이 끝나면서 방문 처리를 끝내야 함
     *
     */
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static boolean[][] visited;
    static char[][] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new char[5][5];
        visited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < 5; j++){
                arr[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, 0);
            }
        }
    }
    static void dfs(int sy, int sx, int som, int im){
        if (som + im > 7){
            return;
        }
        if (im >= 4){
            return;
        }
        if (som + im == 7 && som >= 4){
            count += 1;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = sy + dy[i];
            int nx = sx + dx[i];
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5){

            }
        }
    }
}

