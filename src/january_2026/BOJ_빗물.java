package january_2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_빗물 {
    static int h, w;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int x = Integer.parseInt(st.nextToken());
        }
    }
}

/*
1. 벽이 있는 곳을 1 아닌 곳을 0으로 칠한다.
2. for문을 돌려 방문 처리를 한다.
3. 0일 경우, 왼쪽 오른쪽으로만 탐색한다. 왼쪽 오른쪽에 벽이 있는 경우 그동안의 탐색 횟수를 체크한다.
4. 출력
 */