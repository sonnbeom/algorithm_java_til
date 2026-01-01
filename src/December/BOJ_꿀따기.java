package December;

import java.io.*;
import java.util.*;
public class BOJ_꿀따기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        long[] p = new long[n];
        p[0] = h[0];
        for (int i = 1; i < n; i++) {
            p[i] = h[i] + p[i-1];
        }
        long honeySum = p[n-1];
        long answer = 0;

        /*
         * 경우 1) 벌(0), 벌(i), 벌통(N-1)
         *  - 벌통은 맨 오른쪽, 한 벌은 맨 왼쪽 고정
         *  - 다른 벌 위치 i(1 ~ N-2)를 바꿔가며 최대값 찾기
         */
        for (int i = 1; i <= n-2; i++) {
            long beeRight = honeySum - h[0] - h[i];
            long beeMid = honeySum - p[i];
            answer = Math.max(answer, beeMid + beeRight);
        }
        /*
         * 경우 2) 벌통(0), 벌(i), 벌(N-1)
         *  - 경우 1의 좌우 반전
         */
        for (int i = 1; i <= n-2; i++) {
            long beeRight = honeySum - h[n-1] - h[i];
            long beeMid = p[i-1];
            answer = Math.max(answer, beeMid + beeRight);
        }
        /*
         * 경우 3) 벌(0), 벌통(i), 벌(N-1)
         *  - 벌은 양 끝 고정, 벌통 위치 i(1 ~ N-2)를 바꿔가며 최대값 찾기
         */
        for (int i = 1; i <= n-2; i++) {
            long beeLeft = p[i] - h[0];
            long beeRight = honeySum - p[i-1] - h[n-1];
            answer = Math.max(answer, beeRight + beeLeft);
        }
        System.out.println(answer);
    }
}
/*
dp를 만들어서
꿀 위치만 정해
그리고 l tq
 */