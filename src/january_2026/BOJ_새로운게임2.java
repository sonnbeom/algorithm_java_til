package january_2026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_새로운게임2 {
    static int N, K;
    static int[][] arr;
    static int[][][] horses;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        horses = new int[N][N][K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
            }
        }
        // 이동방향 배열을 따로 적어줘야 할 듯 이 말은 이렇게

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) -1;
            int x = Integer.parseInt(st.nextToken()) -1;
            int m = Integer.parseInt(st.nextToken()) -1;
//            horses[y][x][0] =

        }

    }
}
